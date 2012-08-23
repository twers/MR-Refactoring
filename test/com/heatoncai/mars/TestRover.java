package com.heatoncai.mars;

import static org.junit.Assert.*;

import org.junit.Test;

import com.heatoncai.CommandType;

public class TestRover {

	@Test
	public void testInit(){
		Rover rover = new Rover(1,2,'N');
		Storage s = rover.getStorage();
		assertNotNull(s);
		assertEquals(1, s.getPosition().x);
		assertEquals(2, s.getPosition().y);
		assertEquals('N', s.getDirection());
		assertEquals("1 2 N", s.getState());
	}
	
	@Test
	public void testExecute() {
		Rover rover = new Rover(1,2,'N');
		ControllerMock c1 = new ControllerMock();
		ControllerMock c2 = new ControllerMock();
		rover.registerCommand(CommandType.position, c1);
		rover.registerCommand(CommandType.explore, c2);
		assertNull(rover.execute("5 5"));
		assertFalse(c1.processed);
		assertFalse(c2.processed);
		String re = rover.execute("RMMLMMRLM");
		assertEquals("done", re);
		assertFalse(c1.processed);
		assertTrue(c2.processed);
	}

	private class ControllerMock implements Controller{
		
		private boolean processed = false;

		@Override
		public String process(String command) {
			processed = true;
			return "done";
		}
		
	}
}
