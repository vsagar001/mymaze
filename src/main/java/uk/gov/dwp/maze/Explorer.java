package uk.gov.dwp.maze;

import uk.gov.dwp.maze.model.CurrentLocation;
import uk.gov.dwp.maze.model.Location;
import uk.gov.dwp.maze.model.MoveOptions;

import java.util.List;

public interface Explorer {

	void moveForward();

	void turnLeft();

	void turnRight();

	String getFront();

	MoveOptions getMoveOptions();

	List<Location> getVisitedLocations();

	CurrentLocation getCurrentLocation();
}
