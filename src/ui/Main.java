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
		Main exe = new Main();
		
		int option = 0;

		do{
			exe.menu();
			option = exe.validateIntegerInput();
			exe.executeOption(option);
		}while(option != 3);

	}

	
	public void menu() {
		System.out.println("Options:");
		System.out.println("1. Register project");
		System.out.println("2. Search project with deadline");
		System.out.println("3. Exit");
	}

	
	public void registerProject() {
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

		System.out.println("How long until the project ends? (Months)");
		months = reader.nextInt();
		finalDate = calculateFinalDate(months);
		
		controller.registerProject(name, clientName, initialDate, finalDate, projectBudget);
	}

	//Incomplete
	public int searchProjectsAfterDate() {
		System.out.println("How long until the deadline? (Months)");
		int months = reader.nextInt();
		int projectCounter = controller.searchProjectsAfterDate(months);

		return projectCounter;
	}
	
	//Incomplete
	public int searchProjectsBeforeDate() {
		System.out.println("How long until the deadline? (Months)");
		int months = reader.nextInt();
		int projectCounter = controller.searchProjectsBeforeDate(months);
		
		return projectCounter;
	}

	public void executeOption(int option){
		int exit = 0;
		do{
			switch(option){
				case 1:
					registerProject();
					exit = -1;
				break;
					
				case 2: 
					searchOptionSelection();
					exit = -1;
				break;

				case 3:

					exit = -1;
	
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

			System.out.println("Search options:");
			System.out.println("1. Search projects before date");
			System.out.println("2. Search projects after date");
			System.out.println("Exit");
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

				case 3: 

				exit = -1;

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

	public void showBeforeProjects(){
		int projectCounter = searchProjectsBeforeDate();

		for(int i = 0; i < projectCounter; i++){
			String name = controller.getBeforeProjectsName(i);
			System.out.println(name);
		}
	}

	public void showAfterProjects(){
		int projectCounter = searchProjectsAfterDate();

		for(int i = 0; i < projectCounter; i++){
			String name = controller.getAfterProjectsName(i);
			System.out.println(name);
		}
	}

	public Calendar calculateInitialDate(int months){
		Calendar initialDate = Calendar.getInstance();

		initialDate.add(Calendar.MONTH, months);
		return initialDate; 

	}

	public Calendar calculateFinalDate(int months){
		Calendar finalDate = Calendar.getInstance();

		finalDate.add(Calendar.MONTH, months);
		return finalDate;
	}

}
