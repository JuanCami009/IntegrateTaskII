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
	 * SIZE_STAGES the total stages
	 */
	private static final int SIZE_STAGES = 6;
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
	private String[] stages;
	
	
	

	public Project(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd-MM-yyyy");

		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;

		managers = new Manager[SIZE];
		stageProjects = new StageProject[SIZE];
		stages = new String[SIZE_STAGES];
		
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
	public String addManager(Manager manager){
		String msg = "Manager could not be added ";
		int pos = getFirstValidPositionManager(); 
		if(pos != -1){
			managers[pos] = manager; 
			msg = "Manager added"; 
		}

		return msg;
	}
	/**
	 * addStage:add the stages to the project 
	 * @param stage It is an object of type StageProject
	 * @return will be a message that will say if a stages is not added, if it will create the stages in the project
	 */
	public String addStage(StageProject stage){
		String msg = "Stages have not been created";
		int pos = getFirstValidPositionStage(); 
		if(pos != -1){
			initStages();
			stageProjects[pos] = stage; 
			msg = "Stages added"; 
		}

		return msg;
	}
	/**
	 * searchStages: Search for a project stage
	 * @param nameStages It will be the name of the stage
	 * @return the position where the stage was located
	 */
	public  int searhStages(String nameStages){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(stages[i].equalsIgnoreCase(nameStages)){
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
	public String culminateStage(String nameStages){
		String msg = "The stages not culminated";
		int pos = searhStages(nameStages);
		if(pos != -1){
			stages[pos]="";
			msg= "The stages has culminated";
		}

		return msg;
	}
	/**
	 * Initializes the stages of the project
	 */
	public void initStages(){
		stages[0] = "Start"; 
		stages[1] = "Analysis";
		stages[2] = "Design";
		stages[3] = "Execution";
		stages[4] = "ClosureMonitoring";
		stages[5] = "ProjectControl";
	}

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


