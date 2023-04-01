package model;

import java.util.Calendar;



public class Controller {

	private Project[] projects;
	private int projectCounter = 0;


	public Controller() {

		projects = new Project[10];
		

	
	}
	
	
	public String registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget, String projectType) {

		String validated = "The list is already full!";

		if(projectCounter < 10){
			projects[projectCounter++] = new Project(name, clientName, initialDate, finalDate, budget, projectType);
			validated = "Project registered successfully!";
		}

		return validated;
	}

	
	public String searchProjectsAfterDate(Calendar postDeadline){
		int controlVar = 1;
		String msg = "List of projects after deadline:";

		for (int i = 0; i < projectCounter; i++) {
			if(postDeadline.compareTo( projects[i].getInitialDate()  ) < 0){
				msg+="\n"+(controlVar++)+"."+projects[i].getName();
			}
		}

		msg = (msg.equalsIgnoreCase("Project list:"))?"The projects do not exist":msg;
		return msg;
	}
	
	
	public String searchProjectsBeforeDate(Calendar preDeadline) {
		int controlVar = 1;
		String msg = "List of projects before deadline:";

		for (int i = 0; i < projectCounter; i++) {
			if(preDeadline.compareTo( projects[i].getFinalDate()  ) > 0){
				msg+="\n"+(controlVar++)+"."+projects[i].getName();
			}
		}

		msg = (msg.equalsIgnoreCase("Project list:"))?"The projects do not exist":msg;
		return msg;
	}


}
