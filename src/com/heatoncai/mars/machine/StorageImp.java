package com.heatoncai.mars.machine;

import com.heatoncai.mars.Storage;
import com.heatoncai.mars.bean.Coordinate;

public class StorageImp implements Storage {
	
	private Coordinate position;
	private char direction;
	private Coordinate range;
	private boolean ready4move;

	public StorageImp(int x, int y, char direction){
		position = new Coordinate(x, y);
		this.direction = direction;
		range = new Coordinate(0, 0);
		ready4move = false;
	}
	
	@Override
	public void setPosition(int x, int y) {
		position.x = x;
		position.y = y;
	}

	@Override
	public Coordinate getPosition() {
		return position;
	}

	@Override
	public void setLimit(int x, int y) {
		range.x = x;
		range.y = y;
	}

	@Override
	public void setDirection(char d) {
		this.direction = d;
	}

	@Override
	public char getDirection() {
		return direction;
	}

	@Override
	public boolean isReady() {
		return ready4move;
	}

	@Override
	public void setReady(boolean ready) {
		this.ready4move = ready;
	}

	@Override
	public Coordinate getRange() {
		return range;
	}
	
	@Override
	public String getState() {
		return new StringBuilder().append(position.x)
				.append(' ').append(position.y).append(' ')
				.append(direction).toString();
	}

}
