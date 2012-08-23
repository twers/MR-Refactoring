package com.heatoncai.mars;

import com.heatoncai.mars.bean.Coordinate;

/**
 * <p>Description: save all information about the Rover</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public interface Storage {
	
	public void setPosition(int x, int y);
	public Coordinate getPosition();
	public void setLimit(int x, int y);
	public Coordinate getRange();
	public void setDirection(char d);
	public char getDirection();
	
	/**
	 * return the Rover whether ready to move
	 * @return true if the Rover is ready, else false
	 */
	public boolean isReady();
	
	public void setReady(boolean ready);
	
	/**
	 * get the position and direction of the Rover
	 * @return format like:1 3 N
	 */
	public String getState();
}
