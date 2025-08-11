This is a device management checkout system for a library. It's purpose is to keep track of devices that are available for checkout or check in a device.


The three files in this project work as intended:

  LibraryMenu.java
  This file will be the main user interface (UI). Users must select a listed menu option.
  
  LibraryDevices.java
  This file contains the main source code.  
  
  Device.java
  This file creates the device objects.


How it works:

  Upon running the program the user will be given 7 options to choose from: 
  1. List Devices by Title: Displays all options available for checkout.
  
  2. Add New Devices: Requests SKU and Title of device
  
  3. Edit Device Information: Allows user to choose from available devices and change their SKU and Title information.
  
  4. Search by Device Name: User must input keyword device. User will then receive all listings and their information that includes the keyword.
  
  5. Check Out Devices: User can choose from all availble listings to checkout. When the device is chosen. Afterwards the device will no longer be available to check out.
  
  6. Check In Devices: User can check in a device that was previously checked out. A list of devices will be shown and the user can choose what device will be checked in.
  
  7. Exit: Program will stop running.		
