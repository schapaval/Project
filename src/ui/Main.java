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
		
	}

	public static void main(String[] args) {
		int option;
		Main exe = new Main();
		exe.menu();


	}

	
	public void menu() {
		System.out.println("Options:");
		System.out.println("1. Register project");
		System.out.println("2. Search project with deadline");
	}

	
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
		initialDate = project.calculateInitialDate(months);

		System.out.println("How long until the project ends? (Months)");
		finalDate = project.calculateFinalDate(months);
		
	}

	//Incomplete
	public void searchProjectsAfterDate() {

	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {

	}

	public void executeOption(int option){
		int exit = 0;
		do{
			switch(option){
				case 1:
					RegisterProject();
					exit = -1;
				break;
					
				case 2: 
					
					searchOptionSelection();
					exit = -1;
				break;
	
				default:
	
				System.out.println("Invalid selection, try again");
	
				break;
			}
		}while(exit != -1);

	
		
	}

	public void searchOptionSelection(){
		int exit = 0;
		int option = 0;
		do{
			option = reader.nextInt();
			switch(option){

				case 1:
				searchProjectsBeforeDate();
				exit = -1;
				break;
	
				case 2:
				searchProjectsAfterDate();
				exit = -1;
				break;

				default:

				System.out.println("Invalid selection, try again");

				break;
	
			}
		}while(exit != -1);
		
	}

	public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Please enter an int value"); 
        }
        return option; 
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
