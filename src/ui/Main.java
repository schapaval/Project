package ui;

import java.util.Scanner;
import model.Controller;

public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main exe = new Main();
		exe.menu();

	}

	// Incomplete
	public void menu() {

	}

	//Incomplete
	public void RegisterProject() {

	}

	//Incomplete
	public void searchProjectsAfterDate() {

	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {

	}
}
