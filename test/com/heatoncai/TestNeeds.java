package com.heatoncai;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.heatoncai.earth.Console;
import com.heatoncai.earth.Transceiver;

/**
 * <p>Description: test the need of this project</p>
 * CreateDate: Jun 21, 2012
 * @author HeatoN
 */
public class TestNeeds {

	@Test
	public void testSend() {
		String[] commands = {"5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM"};
		
		Transceiver console = new Console();
		for(String command : commands){
			console.addCommand(command);
		}
		List<String> results = console.send();
		assertEquals(2, results.size());
		assertEquals("1 3 N", results.get(0));
		assertEquals("5 1 E", results.get(1));
	}

}
