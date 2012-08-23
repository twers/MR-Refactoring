package com.heatoncai.mars;

import java.util.HashMap;
import java.util.Map;

import com.heatoncai.CommandType;
import com.heatoncai.mars.machine.StorageImp;

public class Rover implements Terminal,Subject {
	
	private Storage storage;
	private Map<CommandType, Controller> controllers;
	
	public Rover(int x, int y, char direction){
		storage = new StorageImp(x, y, direction);
		controllers = new HashMap<CommandType, Controller>();
	}

	@Override
	public String execute(String command) {
		CommandType type = CommandType.check(command);
		if(type==null)return null;
		Controller c = controllers.get(type);
		if(c==null)return null;
		return c.process(command);
	}

	@Override
	public void registerCommand(CommandType type, Controller controller) {
		controllers.put(type, controller);
	}

	@Override
	public Storage getStorage() {
		return storage;
	}

}
