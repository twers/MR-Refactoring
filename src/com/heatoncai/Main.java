package com.heatoncai;

import java.util.List;

import com.heatoncai.earth.Console;

public class Main {

	/**
	 * @param args not use
	 */
	public static void main(String[] args) {
		Console console = new Console();
		String command = null;
		System.out.println("For controling the Mars Rover, write commands here:");
		do{
			if(command!=null)console.addCommand(command);
			command = System.console().readLine();
		}while(!"".equals(command));
	
		System.out.println("Mars Rovers now at:");
		List<String> re = console.send();
		for(String s : re){
			System.out.println(s);
		}
	}

}
