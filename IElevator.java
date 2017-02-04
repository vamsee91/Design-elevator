package design;

/*
 * This interface has the functionalities
 * of the elevator in itself, that is to move up or down
 * the direction of the movement, occupied or empty*/

public interface IElevator {
	public void moveUp();
	public void moveDown();
	public ElevatorDirection getDirection();
	public ElevatorState getState();
	public void floorsPressed(int floor);
}
