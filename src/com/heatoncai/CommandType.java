package com.heatoncai;

public enum CommandType {
	/**
	 * the upper-right coordinates of the plateau
	 */
	area("^\\d+ \\d+$"),
	/**
	 * give the rover's position
	 */
	position("^\\d+ \\d+ (N|S|E|W)$"),
	/**
	 * a series of instructions telling the rover how to explore the plateau
	 */
	explore("^(L|R|M)+$");

	private String format;
	
	private CommandType(String format){
		this.format = format;
	}
	
	public static CommandType check(String command){
		for(CommandType type : CommandType.values()){
			if(command.matches(type.format))
				return type;
		}
		return null;
	}
}
