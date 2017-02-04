package design;

import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorControlTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Elevators: ");
		int elevators = sc.nextInt();
		System.out.println("Enter number of Floors: ");
		int floors = sc.nextInt();
		ElevatorSystemControl esc = new ElevatorSystemControl(elevators, floors);
		System.out.println("Enter '1' for Destination and '0' for pick-up: ");
		int flag = sc.nextInt();
		System.out.println("Which floor ? : ");
		int f = sc.nextInt();
		if (flag == 0) {
			esc.pickUp(f);
		    for(int idx=0;idx<f;idx++){
		      esc.timeStepping();
		    }
		    ArrayList<Elevator>ele = esc.getElevator();
		    System.out.println("Pick-up: " + ele.get(0).currentLevel());
		} else {
			System.out.println("Which elevator ? : ");
			int id = sc.nextInt();
			esc.destination(id, f);
			for(int idx=0;idx<f;idx++){
			      esc.timeStepping();
			    }
			    ArrayList<Elevator>ele = esc.getElevator();
			    System.out.println("Destination: " + ele.get(0).currentLevel());
		}
	}
}
