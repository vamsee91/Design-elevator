package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ElevatorSystemControl implements IElevatorControl {
	
	public static int MAX_ELEVATORS = 16;
	public static int MAX_FLOORS = 100;
	public int nElevators;
	public int nFloors;
	public Queue<Integer> pickUpFloors;
	public ArrayList<Elevator> elevators;
	
	public ElevatorSystemControl(int elevators, int floors) {
		if (elevators > MAX_ELEVATORS) {
			this.nElevators = MAX_ELEVATORS;
		} else {
			this.nElevators = elevators;
		}
		if (floors > MAX_FLOORS) {
			this.nFloors = MAX_FLOORS;
		} else {
			this.nFloors = floors;	
		}
		this.pickUpFloors = new LinkedList<>();
		init();
	}

	private void init() {
		elevators = new ArrayList<>();
		for (int i = 0; i < nElevators; i++) {
			elevators.add(new Elevator(1));
		}
	}

	@Override
	public void pickUp(int floor) {
		pickUpFloors.offer(floor);
	}

	@Override
	public void destination(int id, int destFloor) {
		elevators.get(id).floorsPressed(destFloor);
	}

	@Override
	public void timeStepping() {
		for (Elevator ele : elevators) {
			ElevatorState state = ele.getState();
			if (state == ElevatorState.ELEVATOR_STATE_EMPTY) {
				if (!pickUpFloors.isEmpty()) {
					ele.floorsPressed(pickUpFloors.poll());
				}
			} else if (state == ElevatorState.ELEVATOR_STATE_NON_EMPTY) {
				ElevatorDirection dir = ele.getDirection();
				if (dir == ElevatorDirection.ELEVATOR_DIRECTION_UP) {
					ele.moveUp();
				} else if (dir == ElevatorDirection.ELEVATOR_DIRECTION_DOWN) {
					ele.moveDown();
				} else {
					/*
					 * Elevator is not moving case
					 * Destination Floor is reached
					 * */
					ele.remove();
				}
			}
		}
	}

}
