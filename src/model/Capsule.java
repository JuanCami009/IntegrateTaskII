package model;

public class Capsule {
    private static final int SIZE =10;
    private String id;
    private String description;
    private String typeCapsule;
    private boolean approval;
    private Employee[] employees;

    public Capsule(String id, String description, String typeCapsule, boolean approval){
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
    public String getTypeCapsule(){
        return typeCapsule;
    }
    public boolean getApproval(){
        return approval;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setTypeCapsule(String typeCapsule){
        this.typeCapsule = typeCapsule;
    }
    public void setApproval(boolean approval){
        this.approval = approval;
    }

    public String addEmployee(Employee employee){
		String msg = "Employee could not be added ";
		int pos = getFirstValidPosition(); 
		if(pos != -1){
			employees[pos] = employee; 
			msg = "Employee added"; 
		}

		return msg;
	}

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
}
