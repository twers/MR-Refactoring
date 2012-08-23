package com.heatoncai;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCommandType {

	@Test
	public void testCheck() {
		assertEquals(CommandType.area, CommandType.check("5 5"));
		assertEquals(CommandType.position, CommandType.check("1 2 N"));
		assertEquals(CommandType.explore, CommandType.check("LMLMLMLMM"));
	}

}
