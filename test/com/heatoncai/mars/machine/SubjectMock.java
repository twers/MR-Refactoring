package com.heatoncai.mars.machine;

import com.heatoncai.CommandType;
import com.heatoncai.mars.Controller;
import com.heatoncai.mars.Storage;
import com.heatoncai.mars.Subject;

public class SubjectMock implements Subject {

	private Storage storage;
	
	SubjectMock(Storage storage){
		this.storage = storage;
	}
	
	@Override
	public void registerCommand(CommandType type, Controller controller) {
	}

	@Override
	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
