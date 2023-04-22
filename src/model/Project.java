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
	private static final int SIZE_MANAGERS = 10;

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
	private int countNumberCapsules;
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

		managers = new Manager[SIZE_MANAGERS];
		stageProjects = new StageProject[SIZE_STAGES];

		
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
	public int getCountNumberCapsules() {
		return countNumberCapsules;
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

	public void addCapsule(String nameStage, Capsule capsule){
		int pos = searhStages(nameStage);
		
		if(pos != -1){
			if(stageProjects[pos] != null){
				stageProjects[pos].addCapsule(capsule); 
				countNumberCapsules++;
			}
		}
		
	}

	public void addEmployee(String id, Employee employee){
		int pos = searhCapsule(id);
		if (pos != -1){
			if(stageProjects[pos] != null){
				stageProjects[pos].addEmployee(id, employee);
			}

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
		for(int i = 0; i<SIZE_STAGES && !isFound; i++){
			if(stageProjects[i].getNameStage().equalsIgnoreCase(nameStage)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}

	

	public String publicationCapsule(String nameStage, String id){
		int pos = searhCapsule(id);
		String msg = "The capsule could not be published";

		if (pos != -1){
			if(stageProjects[pos] != null){
				msg= stageProjects[pos].publicationCapsule(id);
			}
		}

		return msg;
	}
	
	/**
	 * culminateStages: Culminates the stage of a project 
	 * @param nameStages will be the name of the stage
	 * @return will be a message that will say if a stages is not culminated, if it will culiminate the stages in the project
	 */
	public void culminateStage(String nameStages){
		int pos = searhStages(nameStages);
		if(pos != -1){
			if(stageProjects[pos] != null){
				if(stageProjects[pos].getStatusStage() != "Desactivate"){
					stageProjects[pos].setStatusStage("Desactivate");
					stageProjects[pos+1].setStatusStage("Active");
				}
				
			}
			
		}

	}

	public String showCapsules(String nameStage){
		int pos = searhStages(nameStage);

		String msg = stageProjects[pos].showCapsules()+"\n";

		return msg; 
	}
	

	/**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
	 * */
	public int getFirstValidPositionManager(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_MANAGERS && !isFound; i++){
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
		for(int i = 0; i < SIZE_STAGES && !isFound; i++){
			if(stageProjects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
	public  int searhCapsule(String id){
		int pos = -1;
		for(int i = 0; i<SIZE_STAGES; i++){
			pos = stageProjects[i].searhCapsules(id);	
		}
		return pos;
	}

	public void approvalCapsule(String nameStage, String id){
		int pos = searhStages(nameStage);

		if(pos != -1){
			if(stageProjects[pos] != null){
				stageProjects[pos].approvalCapsule(id);
			}
		}
		
	}	
	
	public String toString(){
		return "The name project is: " +getName() + "\n" + "The client name is: " +getClientName() + "\n" +"The initial date is: "+getInitialDateFormated()+ "\n"+"the final date is: " +getFinalDateFormated()+"\n"+ "The budget project is: "+getBudget();
	}
	
}


