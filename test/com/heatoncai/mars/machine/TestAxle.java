package com.heatoncai.mars.machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAxle {

	@Test
	public void testProcess() {
		StorageImp storage = new StorageImp(3, 4, 'N');
		SubjectMock subject = new SubjectMock(storage);
		Axle axle = new Axle(subject);
		assertNull(axle.process("RM"));
		
		storage.setReady(true);
		axle.process("R");
		assertEquals('E', storage.getDirection());
		assertFalse(storage.isReady());
		storage.setReady(true);
		storage.setDirection('W');
		axle.process("R");
		assertEquals('N', storage.getDirection());
		storage.setReady(true);
		axle.process("L");
		assertEquals('W', storage.getDirection());
		
		storage.setLimit(5, 5);
		storage.setReady(true);
		axle.process("MM");
		assertEquals(1, storage.getPosition().x);
		storage.setReady(true);
		storage.setDirection('N');
		assertEquals("1 5 N", axle.process("M"));
		storage.setReady(true);
		assertEquals("1 5 N", axle.process("M"));
	}
	
}
