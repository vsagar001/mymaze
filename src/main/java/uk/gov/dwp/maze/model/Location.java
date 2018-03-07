package uk.gov.dwp.maze.model;

public class Location {
	private final int x;
	private final int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object other) {

		boolean isEqual = false;

		if (other instanceof Location) {
			Location coordinates = (Location) other;
			isEqual = (this.getX() == coordinates.getX() && this.getY() == coordinates.getY());
		}

		return isEqual;
	}

	@Override
	public int hashCode() {
		return this.getX() * 31 + this.getY();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Location{");
		sb
				.append("x=")
				.append(x);
		sb
				.append(", y=")
				.append(y);
		sb.append('}');
		return sb.toString();
	}
}
