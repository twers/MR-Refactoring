package com.heatoncai.earth;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.heatoncai.earth.Console;
import com.heatoncai.mars.Terminal;

public class TestTransceiver {

	@Test
	public void testAddCommandAndSend() {
		String[] commands = {"5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM"};
		
		Transceiver console = new Console(new TerminalFactory());
		for(String command : commands){
			console.addCommand(command);
		}
		List<String> results = console.send();
		assertEquals(5, results.size());
		assertEquals("received", results.get(0));
	}

	private class TerminalFactory implements TerminalManager{
		
		@Override
		public Terminal find(int x, int y, char d) {
			TerminalMock t = new TerminalMock();
			return t;
		}
		
	}
	
	private class TerminalMock implements Terminal{

		@Override
		public String execute(String command) {
			return "received";
		}
		
	}
	
}
