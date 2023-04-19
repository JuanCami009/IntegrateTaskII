package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Project is the class that represents the system projects
 */
public class Project{
	
	/**
	 * SIZE the total managers and stages
	 */
	private static final int SIZE = 10;
	/**
	 * Attribute declaration
	 */
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget; 
	private DateFormat formatter;
	/**
	 * Represents the array of Manager
	 */
	private Manager[] managers;
	/**
	 * Represents the array of stages
	 */
	private StageProject[] stageProjects;
	/**
	 * Represents the array of String
	 */
	
	
	

	public Project(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd-MM-yyyy");

		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;

		managers = new Manager[SIZE];
		stageProjects = new StageProject[SIZE];

		
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}
	
	public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getProjectInfo(){
		return "\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}
	
	/**
	 * addManager: add one manager to a project
	 * @param manager It is an object of type manager
	 * @return msg will be a message that will say if a manager is not added, if it will create the manager in the project
	 */
	public void addManager(Manager manager){
		int pos = getFirstValidPositionManager(); 
		if(pos != -1){
			managers[pos] = manager; 
		}
	}
	/**
	 * addStage:add the stages to the project 
	 * @param stage It is an object of type StageProject
	 * @return will be a message that will say if a stages is not added, if it will create the stages in the project
	 */
	public void addStage(StageProject stage){
		int pos = getFirstValidPositionStage(); 
		if(pos != -1){
			stageProjects[pos] = stage; 
		}

	}
	/**
	 * searchStages: Search for a project stage
	 * @param nameStage It will be the name of the stage
	 * @return the position where the stage was located
	 */
	public  int searhStages(String nameStage){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(stageProjects[i].getNameStage().equalsIgnoreCase(nameStage)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}
	/**
	 * culminateStages: Culminates the stage of a project 
	 * @param nameStages will be the name of the stage
	 * @return will be a message that will say if a stages is not culminated, if it will culiminate the stages in the project
	 */
	public void culminateStage(String nameStages){
		int pos = searhStages(nameStages);
		if(pos != -1){
			stageProjects[pos].setStatusStage("Desactivate");
			stageProjects[pos+1].setStatusStage("Active");
		}

	}
	/**
	 * Initializes the stages of the project
	 */
	

	/**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
	 * */
	public int getFirstValidPositionManager(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(managers[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
	/**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
	 * */
	public int getFirstValidPositionStage(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(stageProjects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
	
	
	
}


