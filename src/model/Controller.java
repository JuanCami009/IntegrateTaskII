package model;

import java.util.Calendar;

/**
 * Controller this class represents the controller class of the system
 */
public class Controller {

	/**
	 * Represents the array of projects 
	 */
	private Project[] projects;
	/**
	 * Represents the array of Stage Projects 
	 */
	private StageProject[] stages;
	/**
	 * Represents the array of Capsules 
	 */
	private Capsule[] capsules;	
	/**
	 * SIZE the total project, managers and employees
	 */
	private static final int SIZE = 10;
	/**
	 * SIZE_CAPSULE the total capsules by employees
	 */
	private static final int SIZE_CAPSULE = 50;




	public Controller() {

		projects = new Project[SIZE];
		stages = new StageProject[SIZE_CAPSULE];
		capsules = new Capsule[SIZE];

	}
	/**
	 * registerProject: Add one project type project in the array of savings 
	 * @param name It will be the name of the project
	 * @param clientName It will be the customer's name	
	 * @param initialDate It will be the initial date of the project
	 * @param finalDate It will be the final date of the project
	 * @param budget It will be the total budget of the project
	 */
	public void registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {
		Project project = new Project(name, clientName, initialDate, finalDate, budget);
		int pos = getFirstValidPosition();

		if(pos != -1){
			projects[pos]= project;
		}

	}
	/**
	 * addManager: add one object type manager in the array of the projects
	 * @param name It will be the name of the manager
	 * @param phone It will be the manager's phone
	 * @return msg will be a message that will say if a project is not added, if it will create the manager in the project
	 */
	public String addManager(String name, String phone){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Manager manager = new Manager(name, phone);
			msg = projects[0].addManager(manager);
		}
		return msg;
	}

	/**
	 * addStage: add one object of type StageProject and creates the stages of the project
	 * @param initialDate It will be the initial date of the project
	 * @param finalDate It will be the final date of the project
	 * @return msg will be a message that will say if a project is not added, if it will create the stages in the project
	 */
	public String addStage(Calendar initialDate, Calendar finalDate){
		String msg = "No project registered";
		
		if(projects[0] != null){
			StageProject stageProject = new StageProject(initialDate, finalDate);
			msg = projects[0].addStage(stageProject);
		}
		return msg;
	} 

	/**
	 * culminateStage: Completion of a project stage 
	 * @param nameSatge It will be the name of the stage
	 * @return  msg will be a message that will say if a stage is not added, if it will culminate the stage in the project
	 */
	public String culminateStage(String nameSatge){
		String msg = "No Stage registered";

		if(projects[0] != null){
			msg = projects[0].culminateStage(nameSatge);
		}
		return msg;


	}

	/**
	 * addCapsule: Add one capsule to a project stage
	 * @param id It will be the capsule id
	 * @param description It will be the description of the capsule.
	 * @param typeCapusule It will be the type of capsule
	 * @param approval It will be the approval of the capsule.
	 * @return msg will be a message that will say if a stage is not added, if it will add the capsule in the stage
	 */
	public String addCapsule(String id, String description, String typeCapusule, boolean approval){
		String msg = "No stage registered";
		
		if(projects[0] != null){
			Capsule capsule = new Capsule(id, description, typeCapusule, approval);
			msg = stages[0].addCapsule(capsule);
		}
		return msg;
	}

	/**
	 * addEmployee: add one object type employee in the array of the capsules
	 * @param name It will be the name of the employee
	 * @param position It will be the position of the employee
	 * @return msg will be a message that will say if a project is not added, if it will add the employee in the capsule
	 */
	public String addEmployee(String name, String position){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Employee employee = new Employee(name, position);
			msg = capsules[0].addEmployee(employee);
		}
		return msg;
	}

	/**
	 * approvalCapsule: It will change the status of the approval attribute 
	 * @param id It will be the capsule id
	 * @return msg will be a message that will say if a capsule is not added, if it will change the approval in the capsule
	 */
	public String approvalCapsule(String id){
		String msg = "No capsule registered";
		
		if(projects[0] != null){
			msg = stages[0].approvalCapsule(id);
		}
		return msg;
	}

	/**
	 * publicationCapsule: generates a url when the capsule is approved and published
	 * @param id It will be the capsule id
	 * @return msg will be a message that will say if a stage is not added, if it will publication the capsule
	 */
	public String publicationCapsule(String id){
		String msg = "No stage registered";
		
		if(projects[0] != null){
			msg = stages[0].publicationCapsule(id);
		}
		return msg;
	}

	/**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
	 * */
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
