package ui;

import java.util.Scanner;
import model.Controller;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main{

	private Scanner reader;
	private Controller controller;
	private SimpleDateFormat formatting = new SimpleDateFormat("dd-MM-yyyy");
	

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
		
	}

	public static void main(String[] args) {
		Main exe = new Main();
		
		int option = 0;
	
		exe.menu();
			do{
				option = exe.validateIntegerInput();
				
			}while(option != 3 && option != 1 && option != 2 && option != 4 );
	
	do{
		switch(option){
			case 1:
				exe.registerProject();
			
			break;

			case 2:
				exe.searchProjectsBeforeDate();

			break;

			case 3:
				exe.searchProjectsAfterDate();

			break;

			case 4: 
				System.out.println("Program ended");
			break;
			}

	}while(option != 4);
		

	}

	
	public void menu() {
		System.out.println("Options:");
		System.out.println("1. Register project");
		System.out.println("2. Search projects ending before deadline");
		System.out.println("3. Search projects ending after deadline");
		System.out.println("4. Exit");
	}

	
	public void registerProject() {
		String name = "";
		String clientName = "";
		String date = "";
		Calendar initialDate = Calendar.getInstance();
		Calendar finalDate = Calendar.getInstance();
		String projectType = "";
		double projectBudget = 0;
		int type = 0;
		

		System.out.println("Enter the name of the project");
		name = reader.next();

		System.out.println("Enter the name of the client");
		clientName = reader.next();

		System.out.println("Select the project's type (1. Development, 2. Maintenance or 3. Deployment)");
		type = validateIntegerInput();

		switch(type){
			case 1:
			projectType = "Development";

			break;

			case 2: 
			projectType = "Maintenance";
			break;

			case 3: 

			projectType = "Deployment";

			break;
		}

		System.out.println("Enter the initial date of the project: ");
		initialDate = setDate();

		System.out.println("Enter the final date of the project: ");
		finalDate = setDate();

		System.out.println("Enter the project's budget");
		projectBudget = reader.nextDouble();

		
		System.out.println(controller.registerProject(name, clientName, initialDate, finalDate, projectBudget, projectType));
	}

	
	public void searchProjectsAfterDate() {
		Calendar postDeadline = Calendar.getInstance();
		System.out.println("Enter project deadline:");
		postDeadline = setDate();
	}
	
	
	public void searchProjectsBeforeDate() {
		Calendar preDeadline = Calendar.getInstance();
		System.out.println("Enter project deadline:");
		preDeadline = setDate();
	}


	private Calendar setDate(){
		Calendar aDate = Calendar.getInstance();
		boolean validate;
		System.out.println("Enter date in following format: dd-MM-yyyy");
		
		do {
			validate = false;
			String dateIn = "";
			System.out.print("Enter a date: ");
			dateIn = reader.next();
			try {
				aDate.setTime(formatting.parse(dateIn));
				validate = true;
			} catch (ParseException e) {
				//e.printStackTrace();
				System.out.println("Try again");
			}
		} while (!validate);

		return aDate;
	}
	public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();// limpiar el scanner 
            option = -1; 
            System.out.println("Ingrese un valor entero."); 
        }
        return option; 
    }
}
