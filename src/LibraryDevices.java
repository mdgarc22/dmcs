import java.util.Scanner;
import java.util.ArrayList;

public class LibraryDevices {
	//initiate scanner object
	Scanner scnr = new Scanner(System.in);
	
	//declare/initialize array list object
	private ArrayList<Device> device = new ArrayList<Device>(); 
	
	
	//create loadData method to add 5 devices to arraylist immediately
	public ArrayList<Device> loadData()
	{
		//create new object
		Device Dev1 = new Device();
		//set the objects properties
		Dev1.setSKU("6757A");
		Dev1.setName("Apple 9.7-inch iPad Pro");
		//add object to arraylist
		device.add(Dev1);

		Device Dev2 = new Device();
		Dev2.setSKU("93P51B");
		Dev2.setName("Amazon Kindle Fire Kids Edition");
		device.add(Dev2);
			
		Device Dev3 = new Device();
		Dev3.setSKU("10N8C");
		Dev3.setName("LeapFrog Epic Learning Tablet");
		device.add(Dev3);
			
		Device Dev4 = new Device();
		Dev4.setSKU("85U2O");
		Dev4.setName("Amazon Kindle Fire HD 8");
		device.add(Dev4);
			
		Device Dev5 = new Device();
		Dev5.setSKU("91H2D");
		Dev5.setName("HP Envy 8 Note");
		device.add(Dev5);	
		//return all of the added devices	
		return device;
	}
	//create displayHeader method
	public void displayHeader(int input)
	{
		//print for spacing
		System.out.printf("\n\n\n\n\n\n");
		//switch case to determine the appropriate header
		switch (input)
		{
		
		case 1:
			System.out.printf("\t\t\tLibrary Device Checkout System - List\n\n\n\n");
			break;
		case 2:
			System.out.printf("\t\t\tLibrary Device Checkout System - Add New Devices\n\n");
			break;
		case 3:
			System.out.printf("\t\t\tLibrary Device Checkout System - List\n\n\n\n");
			break;
		case 4:
			System.out.printf("\t\t\tLibrary Device Checkout System - Search\n\n\n");
			break;
		case 5:
			System.out.printf("\t\t\tLibrary Device Checkout System - Check Out Devices\n\n\n\n");
			break;
		case 6:
			System.out.printf("\t\t\tLibrary Device Checkout System - Check In Devices\n\n\n\n");
			break;		
		}
	}
	
	//create displayDevice method
	public void displayDevice()
	{
		//initialize local variable to serve as device catalog number
		int index = 1;
		//format print the column headers
		System.out.printf("%-2s %-8s %-50s %-10s\n", "#", "SKU", "Name", "Availability");
		//enhanced loop the arraylist and print out all devices
		for(Device info : device)
		{
			System.out.printf("%-2d %-8s %-50s %-10s\n", index++, info.getSKU(), info.getName(), info.getAvailString(info.getAvail()));						
		}
		
	}
	
	//create addDevice method
	public ArrayList<Device> addDevice()
	{		
		//create tmp object to add new device
		Device dev = new Device();
		//ask user for SKU and set SKU
		System.out.print("SKU: ");
		dev.setSKU(scnr.nextLine().toUpperCase());
		//ask user for Name and set Name
		System.out.print("Name: ");
		dev.setName(scnr.nextLine());
		//add the temp obj to arrayList
		device.add(dev);
		//notify user device was added
		System.out.printf("\nAdded %s to Catalog", dev.getName());
		System.out.printf("\nPress Enter to continue. . .");
		scnr.nextLine();
		
		//return the device to the arrayList
		return device;
	}
	
	
	//create editDevice method
	public ArrayList<Device> editDevice()
	{
		//local var's		
		int index;
		
		//call the displayDevice method
		displayDevice();
		
		//ask user for input on device to be edited	
		System.out.printf("\nEnter Device number to edit (1-%d): ", device.size());
		//store the input as an int
		index = Integer.parseInt(scnr.nextLine());
		//ask user for the SKU
		//device.get will get the specified object in the arraylist and call the setters to update information
		System.out.print("SKU: ");
		device.get(index-1).setSKU(scnr.nextLine());
		//ask user for the Name
		System.out.print("Name: ");
		device.get(index-1).setName(scnr.nextLine());
		
		//notify user information was updated and ask for input to continue
		System.out.printf("\nDevice Information updated.\n\n"
				+ "Press Enter to continue. . .");
		scnr.nextLine();	
		
		return device;
	}
	
	
	//create searchDevice method
	public void searchDevice()
	{
		//declare local var's
		String input;
		int index = 1;
		
		//ask user for input
		System.out.printf("Enter Device to search for: ");
		//store input
		input = scnr.nextLine();
		//display header
		System.out.printf("\nListings for '%s'\n", input);
		
		System.out.printf("\n%-2s %-8s %-50s\n", "#", "SKU", "Name");
		//for loop to iterate through arraylist		
		for(Device object: device)
		{
			//if statement to only print values that contain the user input
			if(object.getName().toUpperCase().contains(input.toUpperCase()))
			{
				System.out.printf("%-2d %-8s %-50s\n", index, object.getSKU(), object.getName());
			}
			//index will serve as counter to print object location
			index++;
		}
		
		//Ask user for input to continue
		System.out.printf("\nPress Enter to continue. . .");
		scnr.nextLine();
	}
	
	
	//create checkOutDevice method
	public ArrayList<Device> checkOutDevice()
	{
		//declare local variable
		int index = 1;
		int input;
		//print the header and formatted column titles
		System.out.printf("\nAvailable Devices\n\n");
		System.out.printf("%-2s %-8s %-50s\n", "#", "SKU", "Name");
		
		//enhanced loop 
		for(Device dev: device)
		{
			//if the availability for the device is true print out
			if(dev.getAvail() == true)
			{
				//print statement
				System.out.printf("%-2s %-8s %-50s\n", index, dev.getSKU(), dev.getName());
			}
			//index counter
			index++;
		}		
		//ask user for device number
		System.out.printf("\nEnter device number: ");
		//store input
		input = Integer.parseInt(scnr.nextLine());
		//get the object from the arraylist and set its availability to false
		device.get(input-1).setAvail(false);
		//notify user the device was checked out
		System.out.printf("Device Checked Out.");
		//ask user for input to continue
		System.out.printf("\n\nPress Enter to continue. . .");
		scnr.nextLine();
		//return the object whose properties are being changed
		return device;
	}
	
	//create checkInDevice method
	public ArrayList<Device> checkInDevice()
	{
		//declare local variable
		int index = 1;	
		int input;
		//print out header statement and formatted column titles
		System.out.printf("\nChecked Out Devices\n\n");
		System.out.printf("%-2s %-8s %-50s\n", "#", "SKU", "Name");
				
		//enhanced loop 
		for(Device dev: device)
		{
			//if the availability for the device is true print out
			if(dev.getAvail() == false)
			{
				//print statement
				System.out.printf("%-2d %-8s %-50s\n", index, dev.getSKU(), dev.getName());
			}
			//index counter
			index++;
		}	
		//ask user to enter the device number
		System.out.printf("\nEnter device number: ");
		//store the input
		input = Integer.parseInt(scnr.nextLine());
		//if statement to determine if device is checked in already
		if(device.get(input-1).getAvail() == false)
		{
			//get the object in the index position that the user requested
			device.get(input-1).setAvail(true);
			//notify user the device was checked in
			System.out.printf("Device Checked In.");
		}
		else
		{
			System.out.printf("This device is already checked in.");
		}
		
		
		//ask user for input to continue
		System.out.printf("\n\nPress Enter to continue. . .");
		scnr.nextLine();
		//return object with its changed property
		return device;
	}
		
}
