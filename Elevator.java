package design;


public class Elevator implements IElevator{

	public static int GROUND_FLOOR = 1;
	public int current;
	//public PriorityQueue<Integer> levels;
	public SchedulingRequestList list;
	
	public Elevator(int floor) {
		this.current = floor;
		//this.levels = new PriorityQueue<>();
		this.list = new SchedulingRequestList();
	}
	
	@Override
	public void moveUp() {
		this.current++;
	}

	@Override
	public void moveDown() {
		this.current--;
	}

	@Override
	public ElevatorDirection getDirection() {
		if (list.size() > 0) {
			if (current < list.peek()) {
				return ElevatorDirection.ELEVATOR_DIRECTION_UP;
			}
			if (current > list.peek()) {
				return ElevatorDirection.ELEVATOR_DIRECTION_DOWN;
			}
		}
		return ElevatorDirection.ELEVATOR_DIRECTION_NONE;
	}

	@Override
	public ElevatorState getState() {
		if (list.size() > 0) {
			return ElevatorState.ELEVATOR_STATE_NON_EMPTY;
		}
		return ElevatorState.ELEVATOR_STATE_EMPTY;
	}

	@Override
	public void floorsPressed(int floor) {
		if (floor == GROUND_FLOOR) {
			list.scheduleRequest(floor, ElevatorDirection.ELEVATOR_DIRECTION_UP);
		
		} else {
			ElevatorDirection dir = getDirection();
			if (dir != ElevatorDirection.ELEVATOR_DIRECTION_NONE) {
				if (floor == current) {
					/*
					 * floor button pressed same as current floor*/
					System.out.println("Doors open");
				} else if ((dir == ElevatorDirection.ELEVATOR_DIRECTION_UP && 
						floor < current) || (dir == ElevatorDirection.ELEVATOR_DIRECTION_DOWN && 
						floor > current)) {
					/*
					 * the direction is different from the button being pressed*/
					System.out.println("Not Allowed");
				} else {
					list.scheduleRequest(floor, dir);
				}
			} else {
				if (floor > current) {
					list.scheduleRequest(floor, ElevatorDirection.ELEVATOR_DIRECTION_UP);
				} else if (floor < current) {
					list.scheduleRequest(floor, ElevatorDirection.ELEVATOR_DIRECTION_DOWN);
				}
			}
		}
	}
	
	public int next() {
		return list.peek();
	}
	
	public int currentLevel() {
		return this.current;
	}
	
	public void remove() {
		list.remove();
	}
	
}
