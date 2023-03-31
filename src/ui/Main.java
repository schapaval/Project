package ui;

import java.util.Scanner;
import model.Controller;
import java.util.Calendar;
import model.Project;

public class Main{

	private Scanner reader;
	private Controller controller;
	private Project project;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
		project = new Project();
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
		String name;
		String clientName;
		Calendar initialDate;
		Calendar finalDate;
		String projectType;
		double projectBudget;
		int months;
		String typeInput;

		System.out.println("Enter the name of the project");
		name = reader.next();

		System.out.println("Enter the name of the client");
		clientName = reader.next();

		System.out.println("Enter the project's type (Development, Maintenance or Deployment)");
		typeInput = reader.next();
		projectType = validateTypeInput(typeInput);

		System.out.println("Enter the project's budget");
		projectBudget = reader.nextDouble();

		System.out.println("How long until the project starts? (Months)");
		months = reader.nextInt();
		initialDate = calculateInitialDate(months);
		
	}

	//Incomplete
	public void searchProjectsAfterDate() {

	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {

	}

	public String validateTypeInput(String typeInput){
		String projectType = "";
		int whileExit = 0;
		do{
			if(typeInput.equalsIgnoreCase("Development")){
				projectType = typeInput;
				whileExit = -1;
			}
	
			else if(typeInput.equalsIgnoreCase("Maintenance")){
				projectType = typeInput;
				whileExit = -1;
			}
	
			else if(typeInput.equalsIgnoreCase("Deployment")){
				projectType = typeInput;
				whileExit = -1;
			}
	
			else{
				System.out.println("Invalid type input!");
			}
		}while(whileExit != -1);
		
		return projectType;
	}
}
