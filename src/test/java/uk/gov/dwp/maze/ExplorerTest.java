package uk.gov.dwp.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dwp.maze.impl.ExplorerImpl;
import uk.gov.dwp.maze.impl.MazeImpl;
import uk.gov.dwp.maze.model.CurrentLocation;
import uk.gov.dwp.maze.model.Location;
import uk.gov.dwp.maze.model.MoveOptions;

import java.util.List;
public class ExplorerTest {

	private Maze maze;
	private Explorer explorer;

	@Before
	public void before() {
		maze = new MazeImpl();
		maze.loadMaze("Maze1.txt");
		explorer = new ExplorerImpl(maze);
	}

	@Test
	public void testMoveForward() {
		System.out.println(explorer.getMoveOptions());
		explorer.moveForward();
		System.out.println(explorer.getMoveOptions());
		explorer.turnRight();
		System.out.println(explorer.getMoveOptions());
		explorer.moveForward();
		System.out.println(explorer.getMoveOptions());

	}

	@Test
	public void testTurnLeft() {
		MoveOptions moveOptions1 = explorer.getMoveOptions();
		System.out.println(moveOptions1);
		explorer.turnLeft();
		MoveOptions moveOptions2 = explorer.getMoveOptions();
		System.out.println(moveOptions2);
		Assert.assertTrue(moveOptions1
				                  .getBack()
				                  .equals(moveOptions2.getLeft()));
	}

	@Test
	public void testTurnRight() {
		MoveOptions moveOptions1 = explorer.getMoveOptions();
		System.out.println(moveOptions1);
		explorer.turnRight();
		MoveOptions moveOptions2 = explorer.getMoveOptions();
		System.out.println(moveOptions2);
		Assert.assertTrue(moveOptions1
				                  .getBack()
				                  .equals(moveOptions2.getRight()));
	}

	@Test
	public void testGetFront() {
		Assert.assertTrue(explorer.getFront().equals("X"));
		explorer.turnLeft();
		Assert.assertTrue(explorer.getFront().equals("X"));
		explorer.turnLeft();
		Assert.assertTrue(explorer.getFront().equals("X"));
		explorer.turnLeft();
		Assert.assertTrue(explorer.getFront().equals(" "));
	}

	@Test
	public void testGetVisitedLocations() {
		explorer.turnRight();
		explorer.moveForward();
		CurrentLocation currentLocation1 = explorer.getCurrentLocation();
		explorer.moveForward();
		CurrentLocation currentLocation2 = explorer.getCurrentLocation();
		List<Location> list = explorer.getVisitedLocations();
		list.stream().forEach(System.out::println);

		System.out.println(currentLocation1.getLocation());
		System.out.println(currentLocation2.getLocation());

		Assert.assertTrue(list.size()==2);
		Assert.assertTrue(list.get(0).getX()==currentLocation1.getLocation().getX());
		Assert.assertTrue(list.get(0).getY()==currentLocation1.getLocation().getY());

		Assert.assertTrue(list.get(1).getX()==currentLocation2.getLocation().getX());
		Assert.assertTrue(list.get(1).getY()==currentLocation2.getLocation().getY());
	}
}
