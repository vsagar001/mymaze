package uk.gov.dwp.maze.model;

public enum Type {

	EMPTY(" " , "EMPTY"),
	EXIT("F", "FINISH"),
	START("S", "START"),
	WALL("X", "WALL");

	private final String type;
	private final String description;

	Type(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public String getDescription() {
		return this.description;
	}
}

