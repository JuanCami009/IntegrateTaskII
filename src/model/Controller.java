package model;

import java.util.Calendar;


public class Controller {

	private Project[] projects;
	
	private static final int SIZE = 10;



	public Controller() {

		projects = new Project[SIZE];

	}
	
	public void registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {
		Project project = new Project(name, clientName, initialDate, finalDate, budget);
		int pos = getFirstValidPosition();

		if(pos != -1){
			projects[pos]= project;
		}

	}

	public String addManager(String name, String phone){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Manager manager = new Manager(name, phone);
			msg = projects[0].addManager(manager);
		}
		return msg;
	}

	public String addStage(Calendar initialDate, Calendar finalDate){
		String msg = "No project registered";
		
		if(projects[0] != null){
			StageProject stageProject = new StageProject(initialDate, finalDate);
			msg = projects[0].addStage(stageProject);
		}
		return msg;
	} 

	public String culminateStage(String nameSatge){
		String msg = "No Stage registered";

		if(projects[0] != null){
			msg = projects[0].culminateStage(nameSatge);
		}
		return msg;


	}

	

    public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(projects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

}
