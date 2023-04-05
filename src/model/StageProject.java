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
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;
	/**
	 * Represents the array of capsule
	 */
    private Capsule[] capsules;

    public StageProject(Calendar initialDate, Calendar finalDate){

        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        capsules = new Capsule[SIZE];

    }

    public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}	
    
	/**
	 * addCapsule: add one capsule to a stage
	 * @param capsule It is an object of type capsule
	 * @return msg will be a message that will say if a capsule is not added, if it will create the capsule in the stage
	 */
    public String addCapsule(Capsule capsule){
		String msg = "Capsule have not been created";
		int pos = getFirstValidPositionCapsules(); 
		if(pos != -1){
			capsules[pos] = capsule; 
			msg = "Capsule added"; 
		}

		return msg;
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

	/**
	 * approvalCapsule: It will change the status of the approval attribute 
	 * @param id It will be the capsule id
	 * @return msg will be a message that will say if a capsule is not approval, if it will change the approval in the capsule
	 */
    public String approvalCapsule(String id){
		String msg = "Capsule have not been approval";
		int pos = searhCapsules(id);
		if(pos != -1){
			capsules[pos].setApproval(true);
			msg= "The capsule has approval";
		}

		return msg;
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
    

	/**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 59] if exist a valid position
	 * */
    public int getFirstValidPositionCapsules(){
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
