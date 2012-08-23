package com.heatoncai.mars.machine;

import com.heatoncai.CommandType;
import com.heatoncai.mars.Controller;
import com.heatoncai.mars.Storage;
import com.heatoncai.mars.Subject;

/**
 * <p>Description: compare the position between the rover and the command from the earth</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public class PositionController implements Controller {

	private Storage storage;
	
	public PositionController(Subject subject){
		this.storage = subject.getStorage();
		subject.registerCommand(CommandType.position, this);
	}
	
	@Override
	public String process(String command) {
		if(CommandType.check(command)!=CommandType.position)
			return null;
		storage.setReady(command.equals(storage.getState()));
		return null;
	}

}
