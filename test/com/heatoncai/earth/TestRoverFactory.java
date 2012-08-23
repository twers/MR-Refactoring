package com.heatoncai.earth;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoverFactory {

	@Test
	public void testFind() {
		assertNotNull(new RoverFactory().find(1,2,'N'));
	}

}
