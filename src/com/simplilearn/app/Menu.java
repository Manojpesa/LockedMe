package com.simplilearn.app;

public class Menu {
	public void printMenu() {
		System.out.println("\nAvailable action:\npress ");
		System.out.println( "1 - To see all Files in root directory\n"
					+ "2 - To see other File Management operations\n"
					+ "press any other number to Exit\n");
	}

	public void subMenu() {
		System.out.println("\nAvailable action:\npress ");
		System.out.println("1 - go to Main Menu\n" 
					+ "2 - To create File\n" 
					+ "3 - To delete File\n"
					+ "4 - To search a File\n"
					+ "press any other number to Exit\n");
	}

	public void searchMenu() {
		System.out.println("\nAvailable action:\npress ");
		System.out.println("1 - To rename this File\n" 
					+ "2 - To edit this File\n"
					+ "3 - To check contents of this File\n"
					+ "press any other number to go back to Main Menu\n");
	}
	
	public void introMenu(){
		System.out.println("\n      Developed by : Manoj Pesa");
		System.out.println("   Contact details : manoj.pesa143@gmail.com");
	}
}
