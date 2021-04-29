package com.simplilearn.app;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LogicExecution {
	
	private static FileManager newFile = new FileManager();
	private static Menu menu = new Menu();
	private static Scanner sc = new Scanner(System.in);
	private static boolean quit;
	private static boolean quit1;
	
	public void mainExecution(){
		
		quit = false;
		while (!quit) {
			if(sc.hasNextInt()){
				int action = sc.nextInt();
				sc.nextLine();				

				switch (action) {
					
					case 1:
						System.out.println("your choice is: "+action+"\n");
						System.out.println("Enter Root Directory");
						String path = sc.nextLine();
						if(!path.isEmpty()){
							String[] container = newFile.getFilesList(path);
							
							LinkedList<String> list = new LinkedList<>();
							if(container != null){
								for (String names : container){
									 sortInOrder(list, names);
									 }
								
								System.out.println("\nAll files are sorted in Ascending Order:\n");
								
								for (String names : list){
									  System.out.println(names);
									 }
							}
						}else{
							System.out.println("Please provide a valid Directory");
						}
						 menu.printMenu();
						 break;
						 
					case 2:
						System.out.println("your choice is: "+action+"\n");
						System.out.println("File Management System: ");
						menu.subMenu();
						subExecution();
						if(quit == false){
							menu.printMenu();
						}
						break;
						
					default:
						System.out.println("This Aplication is now Closed..., ThankYou");
						quit = true;
						break;
				}
				
			} else{
				System.out.println("Invalid Entery. Please enter a valid number");
				sc.nextLine();
			}
		}
	}
	
	public void subExecution(){

		quit1 = false;
		String path2 = null;
		String fileName2 = null;
		while (!quit1) {
			if(sc.hasNextInt()){
				int action = sc.nextInt();
				sc.nextLine();

				switch (action) {
					case 1:
						System.out.println("your choice is: "+action+"\n");
						System.out.println("Back to main menu:");
						quit1 = true;
						break;
					
					case 2:
						System.out.println("your choice is: "+action+"\n");
						System.out.println("Enter file Directory");
						path2 = sc.nextLine();
						System.out.println("Enter file name you want to create: ");
						fileName2 = sc.nextLine();					
						
						newFile.addFile(path2, fileName2);
						menu.subMenu();
						break;
						
					case 3:
						System.out.println("your choice is: "+action+"\n");
						System.out.println("Enter file Directory");
						path2 = sc.nextLine();
						System.out.println("Enter file name you want to delete: ");
						fileName2 = sc.nextLine();
						
						newFile.deleteFile(path2, fileName2);
						menu.subMenu();
						break;
						
					case 4:
						System.out.println("your choice is: "+action+"\n");
						String searchedFile = null;
						System.out.println("Enter file Directory: ");
						path2 = sc.nextLine();
						System.out.println("Enter file name you want to search: ");
						fileName2 = sc.nextLine();
						
						String[] container = newFile.getFilesList(path2);
						
						if(container != null){
							boolean ifExist = false;
							for (String name : container) {
								if (name.equals(fileName2)) {
									ifExist = true;
									searchedFile = name;
								}
							}
							if(ifExist){
								System.out.println("found this file\n\n'"
										+ searchedFile +"'\nwhich action would you like to perform on it??");
								
								menu.searchMenu();
									if(sc.hasNextInt()){
										action = sc.nextInt();
										sc.nextLine();
										
										switch(action){
										
											case 1:
												System.out.println("your choice is: "+action+"\n");
												boolean close = false;
												while(!close){
													System.out.println("Enter new Name for this File: ");
													String newName = sc.nextLine();
													
													if(newFile.renameFile(path2, fileName2, newName)){
														System.out.println("Renamed successfully");
														close = true;
													}else{
														System.out.println("Error while renaming, use different Name.\n");
													}
												}
												break;
												
											case 2:
												System.out.println("your choice is: "+action+"\n");
												System.out.println("Enter the content for this file: \n");
												String content = sc.nextLine();
												
												newFile.editFile(path2, fileName2, content);
												break;
												
											case 3:
												System.out.println("your choice is: "+action+"\n");
												newFile.contentsOfFile(path2, fileName2);
												break;
												
											default:
												System.out.println("Back to main menu: \n");
												quit1 = true;
												break;												
										}
									}	
							} else{
								System.out.println("File does not exist,\n"
										+ "Pleas check the file name or the directory you have entered.");
							}
						}
						
						menu.subMenu();
						break;
						
					default:
						System.out.println("This Aplication is now Closed..., ThankYou");
						quit = true;
						quit1 = true;
						break;
							
				}
			} else{
				System.out.println("Invalid Entery. Please enter a valid number");
				sc.nextLine();
			}			
		}
	}
	
	public static boolean sortInOrder(LinkedList<String> linkedList, String fileName) {
		ListIterator<String> stringListIterator = linkedList.listIterator();

		while (stringListIterator.hasNext()) {
			int comparison = (stringListIterator.next()).compareToIgnoreCase(fileName);

			if (comparison == 0) {
				// this is not possible, as files name can't be same in same
				// folder
				return false;
			} else if (comparison > 0) {
				stringListIterator.previous();
				stringListIterator.add(fileName);
				return true;
			} else if (comparison < 0) {
				// lets just move to next file
			}
		}

		stringListIterator.add(fileName);
		return true;
	}
}
