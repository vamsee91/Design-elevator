package design;

/*
 * This interface has methods that has the external view 
 * of the elevator.*/
public interface IElevatorControl {
	public void pickUp(int floor);
	public void destination(int id, int destFloor);
	public void timeStepping();
}
