package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * StageProject represents the class in which the project stages are to be created
 */
public class StageProject {
	/**
	 * SIZE the total capsules
	 */
    private static final int SIZE = 50;
	/**
	 * Attribute declaration
	 */
	private String nameStage; 
	private String statusStage;
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;
	/**
	 * Represents the array of capsule
	 */
    private Capsule[] capsules;

    public StageProject(String nameStage, String statusStage,Calendar initialDate, Calendar finalDate){

		this.nameStage = nameStage;
		this.statusStage = statusStage;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        capsules = new Capsule[SIZE];

    }

    public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}	
	public String getNameStage() {
		return nameStage;
	}
	public String getStatusStage() {
		return statusStage;
	}
	public void setStatusStage(String statusStage) {
		this.statusStage = statusStage;
	}
	public void setNameStage(String nameStage) {
		this.nameStage = nameStage;
	}

    
	/**
	 * addCapsule: add one capsule to a stage
	 * @param capsule It is an object of type capsule
	 * @return msg will be a message that will say if a capsule is not added, if it will create the capsule in the stage
	 */
    public void addCapsule(Capsule capsule){
		int pos = getFirstValidPosition(); 
		if(pos != -1){
			capsules[pos] = capsule; 
		}
	}

	public void addEmployee(String id, Employee employee){
		int pos = searhCapsules(id);
		if(pos != -1){
			capsules[pos].addEmployee(employee);
		}
		
	}
	
	

    
	/**
	 * searchStages: Search for a capsule
	 * @param nameStages It will be the id of the capusle
	 * @return the position where the cpsule was located
	 */
    public  int searhCapsules(String id){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(capsules[i].getId().equalsIgnoreCase(id)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}

	public  int searhEmployee(String name){
		
		int pos = -1;
		for(int i = 0; i<SIZE; i++){
			pos = capsules[i].searhEmployee(name);
		}
		return pos;
	}

	/**
	 * approvalCapsule: It will change the status of the approval attribute 
	 * @param id It will be the capsule id
	 * @return msg will be a message that will say if a capsule is not approval, if it will change the approval in the capsule
	 */
    public void approvalCapsule(String id){
		int pos = searhCapsules(id);
		if(pos != -1){
			capsules[pos].setApproval(true);
		}

	}

	/**
	 * publicationCapsule: generates a url when the capsule is approved and published
	 * @param id It will be the capsule id
	 * @return msg will be a message that will say if a stage is not publicated, if it will publication the capsule
	 */
    public String publicationCapsule(String id){
        String msg = "Capsule have not been publication";
        int pos = searhCapsules(id);
        
        if(pos != -1){
         boolean approval = capsules[pos].getApproval();

         if (approval == true){
            System.out.println("www."+capsules[pos].getId()+".com");
            msg = "The capsule has publication";
         }
        }
       

        return msg;
    }

	public String showCapsules(){
		String msg = "";
		for(int i = 0; i < SIZE; i++){
			if(capsules[i] != null){
				msg += capsules[i].toString();

			}
		}
		return msg;
	}
    

	/**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 59] if exist a valid position
	 * */
    public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(capsules[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

    
        
}
