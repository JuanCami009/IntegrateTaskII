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
		int pos = getFirstValidPositionSatage(); 
		if(pos != -1){
			capsules[pos] = capsule; 
			msg = "Capsule added"; 
		}

		return msg;
	}

    public int getFirstValidPositionSatage(){
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
