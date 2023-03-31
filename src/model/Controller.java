package model;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {

	private Project[] projects;
	private Project[] beforeProjects;
	private Project[] afterProjects;


	public Controller() {

		projects = new Project[10];
		

	
	}
	
	
	public void registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {

		Project project = new Project(name, clientName, initialDate, finalDate, budget);
		int pos = getFirstValidPosition();

		if(pos != -1){
			projects[pos] = project;
			for (int i = 0; i<projects.length; i++) {
				
			}
		}
		
	}

	//Incomplete
	// Date class also has their own before() and after() method
	public int searchProjectsAfterDate(int months) {

		int flag = 0;
		int projectCounter = 0;

		Project afterProjects[] = new Project[10];

		Calendar deadline = Calendar.getInstance();
		deadline.add(Calendar.MONTH, months);

		for(int i = 0; i < projects.length; i++){
			flag = projects[i].getFinalDate().compareTo(deadline);

			if(flag>0){
				afterProjects[i] = projects[i];
				projectCounter++;
			}
		}
		return projectCounter;

	}
	
	
	public int searchProjectsBeforeDate(int months) {
		int flag = 0;
		int projectCounter = 0;
		Project beforeProjects[] = new Project[10];

		Calendar deadline = Calendar.getInstance();
		deadline.add(Calendar.MONTH, months);
		for(int i = 0; i < 10; i++){
			flag = projects[i].getFinalDate().compareTo(deadline);
			if(flag<0){
				beforeProjects[i] = projects[i];
				projectCounter++;
			}
			
		}
		return projectCounter;
	}

	public int getFirstValidPosition(){
		int pos = -1; 

		boolean foundIt = false; 
		for(int i = 0; i < 10 && !foundIt; i++){
			if(projects[i] == null){
				pos = i; 
				foundIt = true;
			}
		}
		return pos; 
	}

	public String getBeforeProjectsName(int pos){
		String name = beforeProjects[pos].getName();

		return name;
	}
	
	public String getAfterProjectsName(int pos){
		String name = afterProjects[pos].getName();

		return name;
	}

}
