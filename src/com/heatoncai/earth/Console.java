package com.heatoncai.earth;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.heatoncai.CommandType;
import com.heatoncai.mars.Terminal;

public class Console implements Transceiver {

	private List<Terminal> rovers;
	private Queue<String> commands;
	private TerminalManager terminalManager;
	
	public Console(){
		this(new RoverFactory());
	}
	
	public Console(TerminalManager terminalManager){
		rovers = new ArrayList<Terminal>();
		commands = new LinkedList<String>();
		this.terminalManager = terminalManager;
	}
	
	public String sendCommand(String command){
		String re = null;
		for(Terminal rover : rovers){
			re = rover.execute(command);
			if(re!=null)
				return re;
		}
		return null;
	}

	public void registerRover(Terminal rover){
		this.rovers.add(rover);
	}

	@Override
	public void addCommand(String command) {
		commands.offer(command); 
		preProcess(command);
	}

	@Override
	public List<String> send() {
		List<String> reList = new ArrayList<String>();
		String command;
		while((command=commands.poll())!=null){
			String re = sendCommand(command);
			if(re!=null)
				reList.add(re);
		}
		return reList;
	}
	
	private void preProcess(String command){
		if(CommandType.position==CommandType.check(command)){
			registerRover(findRover(command));
		}
	}
	
	/**
	 * find rover before send command
	 * @param state format like: 1 3 N
	 * @return a terminal on the Mars
	 */
	private Terminal findRover(String state){
		String[] s = state.split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		char d = s[2].charAt(0);
		return terminalManager.find(x, y, d);
	}
	
}
