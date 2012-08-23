package com.heatoncai.mars.machine;

import com.heatoncai.CommandType;
import com.heatoncai.mars.Controller;
import com.heatoncai.mars.Storage;
import com.heatoncai.mars.Subject;

public class Axle implements Controller {

	private Storage storage;
	private int x,y,d;
	
	public Axle(Subject subject){
		this.storage = subject.getStorage();
		subject.registerCommand(CommandType.explore, this);
	}
	
	@Override
	public String process(String command) {
		if(!storage.isReady() || CommandType.check(command)!=CommandType.explore)
			return null;
		init();
		for(char c : command.toCharArray()){
			switch(c){
			case 'R': turnRight();break;
			case 'L': turnLeft();break;
			case 'M': if(checkMove())move();break;
			}
		}
		save();
		return storage.getState();
	}
	
	private void init(){
		this.x = storage.getPosition().x;
		this.y = storage.getPosition().y;
		this.d = DIRECTIONS.indexOf(storage.getDirection());
	}
	
	private void save(){
		storage.setPosition(x, y);
		storage.setDirection(DIRECTIONS.charAt(d));
		storage.setReady(false);
	}
	
	private boolean checkMove(){
		int limit;
		int p;
		if(d%2==0){
			limit = storage.getRange().y;
			p = y + d - 1;
		}else{
			limit = storage.getRange().x;
			p = x + d - 2;
		}
		return p>=0 && p<=limit;
	}

	void turnRight(){
		d = (d+1)%4;
	}
	
	void turnLeft(){
		d = (d+3)%4;
	}
	
	void move(){
		if(d%2==0)
			y += d - 1;
		else
			x += d - 2;
	}
	
	private final static String DIRECTIONS = "SWNE";
	
}
