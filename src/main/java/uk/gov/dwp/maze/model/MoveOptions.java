package uk.gov.dwp.maze.model;

public class MoveOptions {

	Type front;
	Type back;
	Type left;
	Type right;

	public MoveOptions(Type front, Type left, Type back, Type right) {
		this.back = back;
		this.right = right;
		this.front = front;
		this.left = left;
	}
	public Type getFront() {
		return front;
	}

	public Type getBack() {
		return back;
	}

	public Type getLeft() {
		return left;
	}

	public Type getRight() {
		return right;
	}


	public String toString() {

		String s = String
				.format("In front is %s\n", front.getDescription())
				.concat(String.format("On the right is %s\n", right.getDescription()))
				.concat(String.format("On the left is %s\n", left.getDescription()))
				.concat(String.format("On the back is %s\n", back.getDescription()));
		return s.toString();

	}

}
