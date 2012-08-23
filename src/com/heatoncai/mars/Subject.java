package com.heatoncai.mars;

import com.heatoncai.CommandType;

/**
 * <p>Description: Subject of Rover, in fact this is a control center</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public interface Subject {

	public void registerCommand(CommandType type, Controller controller);
	
	public Storage getStorage();
	
}
