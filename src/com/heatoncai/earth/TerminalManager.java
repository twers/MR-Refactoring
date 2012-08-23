package com.heatoncai.earth;

import com.heatoncai.mars.Terminal;

/**
 * <p>Description: manage all terminal</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public interface TerminalManager {

	public Terminal find(int x, int y, char d);
	
}
