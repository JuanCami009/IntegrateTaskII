package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Project is the class that represents the system projects
 */
public class Project{
	
	/**
	 * SIZE the total managers 
	 */
	private static final int SIZE_MANAGERS = 10;

	/**
	 * SIZE_STAGE the total stage
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
	private int countNumberCapsules;

	/**
	 * Represents the array of Manager
	 */
	private Manager[] managers;
	/**
	 * Represents the array of stages
	 */
	private StageProject[] stageProjects;
	
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
	 */
	public void addStage(StageProject stage){
		int pos = getFirstValidPositionStage(); 
		if(pos != -1){
			stageProjects[pos] = stage; 
		}

	}
	/**
	 * addCapsule: add the capsula to the stage project
	 * @param nameStage It will be the name of the stage
	 * @param capsule It is an object of type Capsule
	 */
	public void addCapsule(String nameStage, Capsule capsule){
		int pos = searchStages(nameStage);
		
		if(pos != -1){
			if(stageProjects[pos] != null){
				stageProjects[pos].addCapsule(capsule); 
				countNumberCapsules++;
			}
		}
		
	}
	/**
	 * addEmployee: add the employee to the capsule
	 * @param id It will be the id of the capsule
	 * @param employee It is an object of type Employee
	 */
	public void addEmployee(String id, Employee employee){
		int pos = searchCapsule(id);
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
	public  int searchStages(String nameStage){
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

	
	/**
	 * publicationCapsule: It is the publication of an approved capsule
	 * @param nameStage It will be the name of the stage
	 * @param id It will be the id of the capsule
	 * @return A positive or negative message
	 */
	public String publicationCapsule(String nameStage, String id){
		int pos = searchCapsule(id);
		String msg = "The capsule could not be published";

		if (pos != -1){
			if(stageProjects[pos] != null){
				msg= stageProjects[pos].publicationCapsule(id);
			}
		}

		return msg;
	}
	
	/**
	 * culminateStage: Completion of a project stage 
	 * @param nameStages It will be the name of the stage
	 */
	public void culminateStage(String nameStages){
		int pos = searchStages(nameStages);
		if(pos != -1){
			if(stageProjects[pos] != null){
				if(stageProjects[pos].getStatusStage() != "Desactivate"){
					stageProjects[pos].setStatusStage("Desactivate");
					stageProjects[pos+1].setStatusStage("Active");
				}
				
			}
			
		}

	}
	/**
	 * showCapsules: It is the consultation of the capsules at a specific stage
	 * @param nameStage It will be the name of the stage
	 * @return A message containing all the capsules
	 */
	public String showCapsules(String nameStage){
		int pos = searchStages(nameStage);

		String msg = stageProjects[pos].showCapsules()+"\n";

		return msg; 
	}
	

	/**
	 * getFirstValidPositionManager: search in array if exist one valid position
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
	 * getFirstValidPositionStage: search in array if exist one valid position
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
	/**
	 * searchCapsule: Search for a capsule
	 * @param id It will be the id of the capsule
	 * @return the position where the capsule was located
	 */
	public  int searchCapsule(String id){
		int pos = -1;
		for(int i = 0; i<SIZE_STAGES; i++){
			pos = stageProjects[i].searchCapsules(id);	
		}
		return pos;
	}
	/**
	 * approvalCapsule: It will change the status of the approval attribute 
	 * @param nameStage It will be the name of the stage
	 * @param id It will be the id of the capsule
	 */
	public void approvalCapsule(String nameStage, String id){
		int pos = searchStages(nameStage);

		if(pos != -1){
			if(stageProjects[pos] != null){
				stageProjects[pos].approvalCapsule(id);
			}
		}
		
	}	
	/**
	 * thisRegistredCapsule: thisRegistredCapsule: Is the query if an employee has registered a capsule in a project.
	 * @param nameStage It will be the name of the stage
	 * @param id It will be the id of the capsule
	 * @param name It will be the name of the employee
	 * @return if the employee has created a capsule
	 */
	public String thisRegistredCapsule(String nameStage, String id, String name){
		int pos = searchStages(nameStage);
		String msg = "";

		if(pos != -1){
			int posCapsule = stageProjects[pos].searchCapsules(id);
			if(pos != -1){
				int posEmployee = stageProjects[posCapsule].searchEmployee(name);
				if(pos != -1){
					msg = stageProjects[posEmployee].getThisRegistred();
				}
			}
		}

		return msg;
	}

	public  int searchCapsulesWithDescription(String description){
		int pos = -1;
		for(int i = 0; i<SIZE_STAGES; i++){
			pos = stageProjects[i].searchCapsulesWithDescription(description);	
		}
		return pos;
	}

	public String consultCapsulePublished(String description){
		String msg = "";
		int pos = searchCapsulesWithDescription(description);

		if(pos != -1){
			msg = stageProjects[pos].consultCapsulesPublicated(description);
		}

		return msg;
	}
	
	public String toString(){
		return "The name project is: " +getName() + "\n" + "The client name is: " +getClientName() + "\n" +"The initial date is: "+getInitialDateFormated()+ "\n"+"the final date is: " +getFinalDateFormated()+"\n"+ "The budget project is: "+getBudget();
	}
	
}


