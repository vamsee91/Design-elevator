package design;

public class SchedulingRequestList {
	public FloorNode head;
	public int size = 0;
	
	public void scheduleRequest(int floor, ElevatorDirection direction) {
		FloorNode newNode = new FloorNode(floor);
		FloorNode curr, prev = null;
		
		if (head == null) {
			newNode.next = head;
			head = newNode;
		
		} else {
			curr = head;
			if (direction == ElevatorDirection.ELEVATOR_DIRECTION_UP) {
				while (curr!= null && curr.floor < newNode.floor) {
					prev = curr;
					curr = curr.next;
				}
				newNode.next = curr;
				prev.next = newNode;
			} else if (direction == ElevatorDirection.ELEVATOR_DIRECTION_DOWN) {
				while (curr!= null && curr.floor > newNode.floor) {
					prev = curr;
					curr = curr.next;
				}
				newNode.next = curr;
				prev.next = newNode;
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public int peek() {
		return this.head.floor;
	}
	
	public void remove() {
		FloorNode curr = head;
		curr = curr.next;
		head.next = null;
		head = curr;
	}
}
