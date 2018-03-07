package uk.gov.dwp.maze;

import uk.gov.dwp.maze.model.CurrentLocation;
import uk.gov.dwp.maze.model.Location;
import uk.gov.dwp.maze.model.Type;

/**
 * Created by sagarv on 06/03/2018.
 */
public interface Maze {

	/**
	 * Returns the number of walls the maze has
	 * @return number of walls
	 */
	int getNumberOfWalls();

	/**
	 * Returns the number of empty spaces within the maze
	 * @return number of empty spaces
	 */
	int getNumberOfEmptySpaces();


	/**
	 * Returns the type of space given a pair of coordinates. Coordinates' index begin from 0.
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The type of space e.g. WALL
	 */
	Type getLocationType(int x, int y);

	/**
	 * Returns a cursor for where the start point is marked on the Maze
	 * @return The cursor which includes direction as well as coordinates
	 */
	Location getStartPoint() ;

	void loadMaze(String fileName);

	CurrentLocation getEndLocation();
}
