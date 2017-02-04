# Design-elevator
1) The Elevator design has two interfaces:
a) IElevator: the interface which has methods with an internal elevator operations
b) IElevatorControl: the interface which has methods with external control system, like pick up and elevators destination and time stepping simulation.

2) The design has two enum files:
a) The class representing the direction values
b) The class representing the state of the elevator; whether it has people or not.

3) The classes implementing methods:
a) Elevator.java: This class implements the methods of the IElevator interface
b) ElevatorSystemControl.java: This class implements the methods of IElevatorControl interface

The most crucial part of the design is the scheduling of requests by the users of the elevator. A simple design would be to use a FCFS formula, but then if the floor requests are not in order it would be meaningless to go to a higher floor and then return to a lower floor. 
The method implemented in this design is that of inserting in a sorted manner. A custom linkedList is used that adds the requests to the list in a sorted way in ascending or descending order depending on the direction in which the elevator is moving.
The time stepping simulation also plays an important role in handling the scheduling requests. The nodes in the Scheduling list is removed once the destination floor is reached. Hence, the node addition would make sense.
I have provided comments at two places in the code, that mention that the option selected is not allowed.

4) Things not handled:
When the elevator stops, there can be an alarm for leaving the door open for long or some maintainance work indication.
