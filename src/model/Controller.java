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
	private static final int SIZE = 10;
	
	int countTechnical = 0;
	int countManagment = 0;
	int countDomain = 0;
	int countExperiences = 0;

	public Controller() {

		projects = new Project[SIZE];
		
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
	 */
	public void addManager(String name, String phone){
		
		if(projects[0] != null){
			Manager manager = new Manager(name, phone);
			projects[0].addManager(manager);
		}
	}

	/**
	 * addStage: add one object of type StageProject and creates the stages of the project
	 * @param initialDate It will be the initial date of the project
	 * @param finalDate It will be the final date of the project
	 */
	public void addStage(String nameProject, Calendar initialDate, Calendar finalDate){
		
		int pos = searhProject(nameProject);
		if(pos != -1){
			if(projects[0] != null){
			StageProject start = new StageProject("Start", "Active", initialDate, finalDate);
			StageProject analysis = new StageProject("Analysis", "Desactivate", initialDate, finalDate);
			StageProject design = new StageProject("Design", "Desactivate", initialDate, finalDate);
			StageProject execution= new StageProject("Execution", "Desactivate", initialDate, finalDate);
			StageProject closureMonitoring= new StageProject("Closure and Monitoring", "Desactivate", initialDate, finalDate);
			StageProject control = new StageProject("Control", "Desactivate", initialDate, finalDate);
			projects[0].addStage(start);
			projects[0].addStage(analysis);
			projects[0].addStage(design);
			projects[0].addStage(execution);
			projects[0].addStage(closureMonitoring);
			projects[0].addStage(control);
			}
		}
		
	} 
	public  int searhProject(String nameProject){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(projects[i].getName().equalsIgnoreCase(nameProject)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}   
	
	/**
	 * culminateStage: Completion of a project stage 
	 * @param nameSatge It will be the name of the stage
	 */
	public void culminateStage(String nameProject, String nameSatge){

		int pos = searhProject(nameProject);
		if(pos != -1){
			if(projects[0] != null){
				projects[0].culminateStage(nameSatge);
			   }
		}
		

	}

	

	/**
	 * addCapsule: Add one capsule to a project stage
	 * @param id It will be the capsule id
	 * @param description It will be the description of the capsule.
	 * @param typeCapusule It will be the type of capsule
	 * @param approval It will be the approval of the capsule.
	 */
	public void addCapsule(String nameStage, String id, String description, int option, boolean approval){

		
			TypeCapsule categoryCapsule;
			if(option == 1){
				categoryCapsule = TypeCapsule.TECHNICAL;
				countTechnical++;
			}
			else if (option == 2){
				categoryCapsule = TypeCapsule.MANAGEMENT;
				countManagment++;
			}
			else if (option == 3){
				categoryCapsule = TypeCapsule.DOMAIN;
				countDomain++;
			}
			else{
				categoryCapsule = TypeCapsule.EXPERIENCES;
				countExperiences++;
			}
			if(projects[0] != null){
				Capsule capsule = new Capsule(id, description, categoryCapsule, approval);
				projects[0].addCapsule(nameStage,capsule);
			}
		
		
	}

	/**
	 * addEmployee: add one object type employee in the array of the capsules
	 * @param name It will be the name of the employee
	 * @param position It will be the position of the employee
	 */
	public void addEmployee(String nameProject, String id, String name, String position){
		int pos = searhProject(nameProject);
		if(pos != -1){
			if(projects[pos] != null){
				Employee employee = new Employee(name, position);
				projects[pos].addEmployee(id,employee);
			}
		}
		
	}

	/**
	 * approvalCapsule: It will change the status of the approval attribute 
	 * @param id It will be the capsule id
	 */
	public void approvalCapsule(String nameProject, String nameStage, String id){
		int pos = searhProject(nameProject);

		if(pos != -1){
			projects[pos].approvalCapsule(nameStage, id);
		}
	}

	/**
	 * publicationCapsule: generates a url when the capsule is approved and published
	 * @param id It will be the capsule id
	 * @return msg will be a message that will say if a stage is not added, if it will publication the capsule
	 */
	public String publicationCapsule(String nameProject, String nameStage, String id){
		int pos = searhProject(nameProject);
		String msg = "No stage registered";
		
		if(projects[pos] != null){
			msg = projects[pos].publicationCapsule(nameStage,id);
		}
		return msg;
	}

	public String consultNumberTypeCapsule(String nameProject, String nameStage){
		String msgTechnical="";
		String msgManagment = "";
		String msgDomain = "";
		String msgExperiences = "";
		int pos = searhProject(nameProject);

		if(pos != -1){
			msgTechnical = "The number of technical capsules are "+countTechnical;
			msgManagment ="The number of Management capsules are "+countManagment;
			msgDomain = "The number of Domain capsules are "+countDomain;
			msgExperiences = "The number of Experiences capsules are "+countExperiences;

		}

		return msgTechnical + "\n" + msgManagment + "\n" + msgDomain + "\n" + msgExperiences;
	}

	public String consultCapsules(String nameProject, String nameStage){
		int pos  = searhProject(nameProject);
		String msg = "";

		if (pos != -1){
			for(int i = 0; i< SIZE; i++){
				if(projects[i] != null ){
					msg += projects[pos].showCapsules(nameStage)+"\n"; 
				}
			}
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
