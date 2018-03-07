package uk.gov.dwp.maze;

import org.junit.Before;
import org.junit.Test;
import uk.gov.dwp.maze.impl.MazeImpl;
import uk.gov.dwp.maze.model.Location;
import uk.gov.dwp.maze.model.Type;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MazeTest {

	private Maze maze;

	@Before
	public void before() {
		maze = new MazeImpl();
		maze.loadMaze("Maze1.txt");

	}

	@Test
	public void getNumberOfWalls() {
		assertEquals(149, maze.getNumberOfWalls());
	}

	@Test
	public void getNumberOfEmptySpaces() {
		assertEquals(74, maze.getNumberOfEmptySpaces());
	}

	@Test
	public void getSpaceType() {
		Type spaceType = maze.getLocationType(14, 14);

		assertNotNull(spaceType);
		assertEquals(Type.WALL, spaceType);
	}

	@Test
	public void getStartPoint() {
		Location location = maze.getStartPoint();

		assertNotNull(location);
		assertEquals(3, location.getX());
		assertEquals(3, location.getY());
	}

	@Test
	public void loadNewMaze() {
		maze.loadMaze("Maze2.txt");

		Type type = maze.getLocationType(1, 16);
		assertNotNull(type);
		assertEquals(Type.EXIT, type);
	}
}
