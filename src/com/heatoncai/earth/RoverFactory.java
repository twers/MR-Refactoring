package com.heatoncai.earth;

import com.heatoncai.mars.Rover;
import com.heatoncai.mars.Terminal;
import com.heatoncai.mars.machine.Axle;
import com.heatoncai.mars.machine.MapController;
import com.heatoncai.mars.machine.PositionController;

public class RoverFactory implements TerminalManager {

	@Override
	public Terminal find(int x,int y,char d) {
		Rover rover = new Rover(x, y, d);
		new Axle(rover);
		new MapController(rover);
		new PositionController(rover);
		return rover;
	}

}
