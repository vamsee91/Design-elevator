package design;

import java.util.Scanner;

public class ElevatorTest {

	public static void main(String[] args) {
		Elevator elevator = new Elevator(0);
		//Moving the elevator:
		Scanner sc = new Scanner(System.in);
		System.out.println("How many floors do you want to move up the elevator? ");
		int movesup = sc.nextInt();
		for (int i = 0; i < movesup; i++) {
			elevator.moveUp();
		}
		System.out.println("Current Floor: " + elevator.currentLevel());
		// Moving down
		System.out.println("How many floors do you want to move down the elevator? ");
		int movesdown = sc.nextInt();
		for (int i = 0; i < movesdown; i++) {
			elevator.moveDown();
		}
		System.out.println("Current Floor: " + elevator.currentLevel());
		
		System.out.println("Press a floor: ");
		int f = sc.nextInt();
		elevator.floorsPressed(8);
		System.out.println(elevator.getDirection());
	}
}
