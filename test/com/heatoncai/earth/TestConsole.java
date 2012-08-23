package com.heatoncai.earth;

import static org.junit.Assert.*;

import org.junit.Test;

import com.heatoncai.mars.Terminal;

public class TestConsole {

	@Test
	public void testSendCommand() {
		String re = "result";
		String comm = "command";
		TerminalMock2 t1 = new TerminalMock2(null);
		TerminalMock2 t2 = new TerminalMock2(re);
		TerminalMock2 t3 = new TerminalMock2(null);
		
		Console console = new Console();
		console.registerRover(t1);
		console.registerRover(t2);
		console.registerRover(t3);
		assertEquals(re, console.sendCommand("command"));
		assertEquals(comm, t1.command);
		assertEquals(comm, t2.command);
		assertNull(t3.command);
	}

	private class TerminalMock2 implements Terminal{
		
		private String command;
		private String result;

		private TerminalMock2(String result){
			this.result=result;
		}
		
		@Override
		public String execute(String command) {
			this.command = command;
			return result;
		}
		
	}
}
