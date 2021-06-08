
package wilfred.elevatorproject1;

import java.util.Scanner;

public class Elevator {
	public static void main (String []args) {
            Elevator A = new Elevator();
            Elevator B = new Elevator() {
               int minFloor = 0; 
            };
                   
                     
          
                A.selectElevator(); 
                A.callElevator();
	        A.ask();  
          
                           
                      
                       
        }
		
		
		//variables
		Scanner intel = new Scanner(System.in);
		int maxFloor = 10;//last floor of the building
		int minFloor = 1; //begining floor of the elevator
		int curFloor = 1; //where the elevator is 
		int desFloor = 0; //where the elevator must got
		int select = 0;
                char c = 'A';
		//functions for the elevator
                
                void selectElevator() {
                    
                    display("Choose Elevator A/B");
                    char c = intel.next().charAt(0);   
                   
                }
                
                
                void callElevator() {
                    display("SELECT YOUR FLOOR :");
                    curFloor = intel.nextInt();
                    
                 if (curFloor > 1 ) {
                
                    display("Going UP/DOWN");
                 }
                 else if (curFloor == 1 ) {
                     display("Going Up");
                 }
                 else if (curFloor == 10) {
                     display("Going Down");
                 }
                }
                
                
                
                
		void display(Object o) {
			System.out.println(o);
		} //method object to print to console
                
		void delay(int ms) {
			try {
				Thread.sleep(ms);
			} catch (Exception e) {}
		} 
		void goUp() {
			while (curFloor++ < desFloor) {
			display("going up....current floor: " + curFloor + " | DF: " + desFloor);
			delay(1000);
			}
			curFloor --; //function to move the elevator up
		}
		void goDown() {
			while(curFloor-- > desFloor) {
				display("going down....current floor: " + curFloor + " | DF: " + desFloor);
			delay(1000);
			}
			curFloor++; //function to move the elevator down
		}
	void ask() {
             System.out.println("Current Floor: "+ curFloor + " | Enter destination floor: ");
		desFloor = intel.nextInt();
		if(desFloor < minFloor || desFloor > maxFloor || desFloor == curFloor) {
			display("error.floor out of range or you have selected floor is curFloor.");
			ask();
		} else {
			display("door closing....");
			delay(1000);
			if(desFloor < curFloor) {
				goDown();
			} else if(desFloor > curFloor) {
				goUp();
			}
		}
		display("door opening....");
		ask(); //requires input from user once onboard the elevaltor/ checks if DF is above or bellow current floor
	}
}
				

