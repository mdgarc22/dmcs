import java.util.Scanner;

public class LibraryMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initiate var's
		int userInput = 0;
			
		//initiate other objects
		Scanner scnr = new Scanner(System.in);
		LibraryDevices menu = new LibraryDevices();
		//call loadData method
		menu.loadData();
		//do while loop the menu options to the user
		do {
			//try statement
			try {
				
				System.out.printf("\t\t\tLibrary Device Checkout System\n\n"
						+ "1. List Devices by Title\n"
						+ "2. Add New Devices\n"
						+ "3. Edit Device Information\n"
						+ "4. Search by Device Name\n"
						+ "5. Check Out Devices\n"
						+ "6. Check In Devices\n"
						+ "7. Exit\n\n\n\n"
						+ "Select menu options 1-7: ");
	
				userInput = Integer.parseInt(scnr.nextLine());
				
				//display the appropriate header using the input
				menu.displayHeader(userInput);
						
				//switch case statement to determine method that will be used
				switch(userInput)
				{
				case 1:
					menu.displayDevice();
					System.out.printf("\nPress Enter to continue. . .");
					scnr.nextLine();
					break;
				case 2:
					menu.addDevice();
					break;
					case 3:
					menu.editDevice();
					break;
				case 4:
					menu.searchDevice();
					break;
				case 5:
					menu.checkOutDevice();
					break;
				case 6:
					menu.checkInDevice();
					break;
				case 7:
					System.out.printf("Good bye!");
					System.exit(0);
				default:
					System.out.printf("\n\n\n\nPlease enter one of the listed options.");
					break;
				}
						
				//print out for spacing
				System.out.printf("\n\n\n\n\n\n");
			}
			//catch statement will catch all invalid inputs to notify user their entry is invalid
			catch(Exception err) 
			{
				System.out.printf("\n\n\n\nYour entry is not a valid input.\n\n\n\n\n\n\n");
			}
				
		//the input for exit will be the only way to leave the loop
		}while(userInput >= 1 || userInput <= 7);
		//close scanner once out of the loop
		scnr.close();				
	}
}


