package model;

/**
 * Capsule is the class that represents the capsules that are created in the stages
 */
public class Capsule {
    /**
	 * SIZE the total employee
	 */
    private static final int SIZE =10;
    /**
	 * Attribute declaration
	 */
    private String id;
    private String description;
    private TypeCapsule typeCapsule;
    private boolean approval;
    private String isPublicated = "false";
    /**
	 * Represents the array of Employee
	 */
    private Employee[] employees;

    public Capsule(String id, String description, TypeCapsule typeCapsule, boolean approval){
        this.id = id;
        this.description = description;
        this.typeCapsule = typeCapsule;
        this.approval = approval;

        employees = new Employee[SIZE];
    }

    public String getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public TypeCapsule getTypeCapsule(){
        return typeCapsule;
    }
    public boolean getApproval(){
        return approval;
    }
    public String getIsPublicated() {
        return isPublicated;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setTypeCapsule(TypeCapsule typeCapsule){
        this.typeCapsule = typeCapsule;
    }
    public void setApproval(boolean approval){
        this.approval = approval;
    }
    public void setIsPublicated(String isPublicated) {
        this.isPublicated = isPublicated;
    }

    /**
     * addEmployee: add one employee to the capsule 
     * @param employee It will be an object of type employee
     * @return msg will be a message that will say if a employee is not added, if it will create the employee in the capsule
     */
    public String addEmployee(Employee employee){
		String msg = "Employee could not be added ";
		int pos = getFirstValidPosition(); 
		if(pos != -1){
			employees[pos] = employee; 
			msg = "Employee added"; 
		}

		return msg;
	}
    /**
	 * searchEmployee: Search for a employee
	 * @param name It will be the name of the employee
	 * @return the position where the employee was located
	 */
    public  int searchEmployee(String name){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(employees[i].getName().equalsIgnoreCase(name)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}

    /**
	 * getFirstValidPosition: search in array if exist one valid position
	 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
	 * */
    public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(employees[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
    
    public String toString(){
        return "The id capsule is: " +getId() +"\n"+"Decription: "+getDescription() +"\n" + "The type capsule is: "+getTypeCapsule()+"\n"+ "This apporval: "+ getApproval() + "\n";
    }
}
