package uk.gov.dwp.maze.model;

public class CurrentLocation {
	private Direction direction;
	private Location location;

	public CurrentLocation(Direction direction, Location location){
		this.direction = direction;
		this.location = location;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(int x, int y) {
		this.location = new Location(x, y);
	}
}

