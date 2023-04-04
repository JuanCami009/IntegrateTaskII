package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StageProject {

    private static final int SIZE = 50;
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;
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
    
    public String addCapsule(Capsule capsule){
		String msg = "Capsule have not been created";
		int pos = getFirstValidPosition(); 
		if(pos != -1){
			capsules[pos] = capsule; 
			msg = "Capsule added"; 
		}

		return msg;
	}

    public  int searhStages(String id){
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

    public String approvalCapsule(String id){
		String msg = "Stages have not been approval";
		int pos = searhStages(id);
		if(pos != -1){
			capsules[pos].setApproval(true);
			msg= "The stages has approval";
		}

		return msg;
	}
    

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
