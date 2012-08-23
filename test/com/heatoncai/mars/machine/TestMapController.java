package com.heatoncai.mars.machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMapController {

	@Test
	public void testProcess() {
		StorageImp storage = new StorageImp(3, 4, 'N');
		SubjectMock subject = new SubjectMock(storage);
		MapController mc = new MapController(subject);
		mc.process("5 6");
		assertEquals(5, storage.getRange().x);
		assertEquals(6, storage.getRange().y);
	}

}
