package com.simplilearn.app;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		LogicExecution execution = new LogicExecution();

		System.out.println("==========Welcome to the project LOckedMe==========");
		menu.introMenu();

		menu.printMenu();

		execution.mainExecution();

		System.out.println("===============LockedMe===============");
		menu.introMenu();

	}
}
