package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StageProject {

    private static final int SIZE = 50;
    private static final int SIZE_EMPLOYEE = 10;
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;
    private Capsule[] capsules;
    private Employee[] employees;

    public StageProject(Calendar initialDate, Calendar finalDate){

        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        capsules = new Capsule[SIZE];
        employees = new Employee[SIZE_EMPLOYEE];

    }

    public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}	
    
    public String addCapsule(Capsule capsule){
		String msg = "Capsule have not been created";
		int pos = getFirstValidPositionCapsules(); 
		if(pos != -1){
			capsules[pos] = capsule; 
			msg = "Capsule added"; 
		}

		return msg;
	}

    public String addEmployee(Employee employee){
		String msg = "Employee could not be added ";
		int pos = getFirstValidPositionEmployee(); 
		if(pos != -1){
			employees[pos] = employee; 
			msg = "Employee added"; 
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
		String msg = "Capsule have not been approval";
		int pos = searhStages(id);
		if(pos != -1){
			capsules[pos].setApproval(true);
			msg= "The capsule has approval";
		}

		return msg;
	}

    public String publicationCapsule(String id){
        String msg = "Capsule have not been publication";
        int pos = searhStages(id);
        
        if(pos != -1){
         boolean approval = capsules[pos].getApproval();

         if (approval == true){
            System.out.println("www."+capsules[pos].getId()+".com");
            msg = "The capsule has publication";
         }
        }
       

        return msg;
    }
    

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

    public int getFirstValidPositionEmployee(){
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
