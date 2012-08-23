package com.heatoncai.mars.machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPositionController {

	@Test
	public void testProcess() {
		StorageImp storage = new StorageImp(3, 4, 'N');
		SubjectMock subject = new SubjectMock(storage);
		PositionController pc = new PositionController(subject);
		assertNull(pc.process("3 4 N"));
		assertTrue(storage.isReady());
		assertNull(pc.process("1 2 E"));
		assertFalse(storage.isReady());
	}

}
