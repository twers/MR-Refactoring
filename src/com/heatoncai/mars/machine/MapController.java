package com.heatoncai.mars.machine;

import com.heatoncai.CommandType;
import com.heatoncai.mars.Controller;
import com.heatoncai.mars.Storage;
import com.heatoncai.mars.Subject;

/**
 * <p>Description: for setting the upper-right coordinates of the plateau</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public class MapController implements Controller {

	private Storage storage;
	
	public MapController(Subject subject){
		this.storage = subject.getStorage();
		subject.registerCommand(CommandType.area, this);
	}
	
	@Override
	public String process(String command) {
		if(CommandType.check(command)!=CommandType.area)
			return null;
		String[] s = command.split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		storage.setLimit(x, y);
		return null;
	}

}
