package com.heatoncai.earth;

import java.util.List;

/**
 * <p>Description: send signal of command to the mars</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public interface Transceiver {

	/**
	 * Add one command
	 * @param command
	 */
	public void addCommand(String command);

	/**
	 * send all command to the mars
	 * @return the response from the mars rover
	 */
	public List<String> send();
	
}
