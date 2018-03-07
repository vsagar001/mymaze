package uk.gov.dwp.maze.impl;

import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.model.CurrentLocation;
import uk.gov.dwp.maze.model.Direction;
import uk.gov.dwp.maze.model.Location;
import uk.gov.dwp.maze.model.Type;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MazeImpl implements Maze {

	private List<String> lines;

	private int walls, spaces;

	public int getNumberOfWalls() {
		return walls;
	}

	public int getNumberOfEmptySpaces() {
		return spaces;
	}

	public Type getLocationType(int x, int y) {
		for(Type value : Type.values()) {
			if(lines
					.get(y)
					.charAt(x) == value
					.getType()
					.charAt(0)) {
				return value;
			}
		}
		return null;

	}

	public Location getStartPoint() {
		Location location = null;

		int x = 0;
		for(String line : lines) {
			if(line.contains("S")) {
				location = new Location(x, line.indexOf('S'));
			}
			x++;
		}
		return location;

	}

	public void loadMaze(String fileName) {
		try {
			Path path = Paths.get(this
					                      .getClass()
					                      .getResource(String.format("/%s", fileName))
					                      .getPath());
			lines = Files.readAllLines(path, Charset.defaultCharset());
			walls = getTypeCountFromMaze(lines, "X");
			spaces = getTypeCountFromMaze(lines, " ");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public CurrentLocation getEndLocation(){

		CurrentLocation currentLocation = new CurrentLocation(null, null);


		int x = 0;
		for(String line : lines) {
			if(line.contains("S")) {
				currentLocation.setLocation(x, line.indexOf('F'));
			}
			x++;
		}
		return currentLocation;



	}

	private int getTypeCountFromMaze(List<String> lines, String type) {
		int count = 0;

		for(String line : lines) {
			count += getTypeCountFromLine(line, type);
		}
		return count;
	}

	private int getTypeCountFromLine(String line, String type) {
		int count = 0;

		for(char letter : line.toCharArray()) {
			if(type.charAt(0) == letter) {
				count++;
			}
		}
		return count;
	}
}
