package uk.gov.dwp.maze.impl;

import uk.gov.dwp.maze.Explorer;
import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.model.CurrentLocation;
import uk.gov.dwp.maze.model.Direction;
import uk.gov.dwp.maze.model.Location;
import uk.gov.dwp.maze.model.MoveOptions;
import uk.gov.dwp.maze.model.Type;

import java.util.ArrayList;
import java.util.List;

public class ExplorerImpl implements Explorer {

	private CurrentLocation currentLocation;
	private Maze maze;
	private List<Location> pastLocations = new ArrayList<>();
	private MoveOptions moveOptions;

	public ExplorerImpl(Maze maze){
		this.maze = maze;
		currentLocation = new CurrentLocation(Direction.NORTH,maze.getStartPoint());
		getMoveOptions();
	}

	@Override
	public void moveForward() {
		int currentX = currentLocation.getLocation().getX();
		int currentY = currentLocation.getLocation().getY();

		if(moveOptions.getFront()!=Type.EMPTY){

			//  TODO can't move forward
			System.out.println("can't move Forward, its a WALL");
			return;
		}

		switch (currentLocation.getDirection()) {
			case NORTH:
				currentLocation = new CurrentLocation(Direction.NORTH,new Location(currentX, currentY - 1));
				break;
			case SOUTH:
				currentLocation = new CurrentLocation(Direction.SOUTH, new Location(currentX, currentY + 1));
				break;
			case EAST:
				currentLocation = new CurrentLocation(Direction.EAST, new Location(currentX + 1, currentY));
				break;
			case WEST:
				currentLocation = new CurrentLocation(Direction.WEST, new Location(currentX - 1, currentY));
				break;
		}

		currentX = currentLocation.getLocation().getX();
		currentY = currentLocation.getLocation().getY();

		addPastLocations(currentX, currentY);

	}

	private void addPastLocations(int x, int y) {
		Location location = new Location(x, y);

		if (pastLocations.contains(location)) {
			// TODO already been at this location
		} else {
			// Todo FIRST TIME HERE
			pastLocations.add(location);
		}
	}

	@Override
	public void turnLeft() {
		switch (currentLocation.getDirection()) {
			case NORTH:
				currentLocation.setDirection(Direction.WEST);
				break;
			case SOUTH:
				currentLocation.setDirection(Direction.EAST);
				break;
			case EAST:
				currentLocation.setDirection(Direction.NORTH);
				break;
			case WEST:
				currentLocation.setDirection(Direction.SOUTH);
				break;
		}
		getMoveOptions();
	}

	@Override
	public void turnRight() {
		switch (currentLocation.getDirection()) {
			case NORTH:
				currentLocation.setDirection(Direction.EAST);
				break;
			case SOUTH:
				currentLocation.setDirection(Direction.WEST);
				break;
			case EAST:
				currentLocation.setDirection(Direction.SOUTH);
				break;
			case WEST:
				currentLocation.setDirection(Direction.NORTH);
				break;
		}
		getMoveOptions();
	}

	@Override
	public String getFront() {
		return this.moveOptions.getFront().getType();
	}

	@Override
	public MoveOptions getMoveOptions() {
		Location location = currentLocation.getLocation();
		Type north = maze.getLocationType(location.getX(), location.getY() - 1);
		Type south = maze.getLocationType(location.getX(), location.getY() + 1);
		Type east = maze.getLocationType(location.getX() + 1, location.getY());
		Type west = maze.getLocationType(location.getX() - 1, location.getY());

		switch(currentLocation.getDirection()) {
			case NORTH:
				moveOptions = new MoveOptions(north, west, south, east);
				break;
			case SOUTH:
				moveOptions = new MoveOptions(south, east, north, west );
				break;
			case EAST:
				moveOptions = new MoveOptions(east, north, west, south);
				break;
			case WEST:
				moveOptions = new MoveOptions(west, south, east, north);
				break;
		}

		return moveOptions;
	}

	@Override
	public List<Location> getVisitedLocations() {
		return pastLocations;
	}

	@Override
	public CurrentLocation getCurrentLocation(){
		return this.currentLocation;
	}
}
