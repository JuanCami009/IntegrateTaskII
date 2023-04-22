  package ui;
import model.Controller;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Main is the ui class, which is the one that will be shown to the user and will execute the main methods
 */
public class Main{

private Scanner reader;
private Controller controller;
private DateFormat formatter;

public Main(){
    reader = new Scanner(System.in);
    controller = new Controller();
    formatter = new SimpleDateFormat("dd-MM-yyyy");
}
public static void main(String[] args) {

    Main m = new Main();

		int option = 0;
		do{
			m.menu();
			option = m.validateIntegerInput();
			m.executeOption(option);

		}while(option != 0);
		
		m.reader.close();
    
}

public void menu() {
    System.out.println("1. Register project");
    System.out.println("2. Culminate stage");
    System.out.println("3. Register capsule");
    System.out.println("4. Approval capsule ");
    System.out.println("5. Publication capsule");
    System.out.println("6. Consult the number of capsules for each type of capsule");
    System.out.println("7. Lessons learned");
    System.out.println("8. The project with the highest number of capsules");
    System.out.println("0. Exit");
}

public void executeOption(int option){
    switch(option){

        case 1:
        registerProject();
        addManager();
        addStage();
        break;

        case 2:
        culminateStage();
        break;

        case 3:
        addCapsule();
        addEmployee();
        break;
        
        case 4:
        approvalCapsule();
        break;

        case 5:
        publicationCapsule();
        break;

        case 6: 
        consultNumberTypeCapsule();
        break;

        case 7:
        consultCapsules();
        break;

        case 8:
        consultNumberCapsule();
        break;

        case -1:
        System.out.println("Opción invalida!!");
        break;

    }
}
public void registerProject() {
	String name;
	String clientName;
	Calendar initialDate;
	Calendar finalDate;
	int monthInitial;
    int monthFinal;
    int monthFinal2 = 0;
	double budget;
    

	System.out.println("Type the name of the project:");
	name = reader.next();

	System.out.println("Type customer name:");
	clientName = reader.next();

    System.out.println("After a few months, the project begins:");
    monthInitial = reader.nextInt();
    initialDate = Calendar.getInstance();
    initialDate.add(Calendar.MONTH, monthInitial);
    String timeStamp = formatter.format(initialDate.getTime());
	System.out.println("The start date is: "+timeStamp);

	System.out.println("Enter in months how long the project will last:");
	monthFinal = reader.nextInt();
    monthFinal2 = monthFinal+monthInitial;
	finalDate = Calendar.getInstance();
	finalDate.add(Calendar.MONTH, monthFinal2);
    String timeStamp2 = formatter.format(finalDate.getTime());
	System.out.println("The end date is: "+timeStamp2);

	System.out.println("Enter the budget for the project:");
	budget= reader.nextDouble();

   

	controller.registerProject(name, clientName, initialDate, finalDate, budget);
	}

public void addManager(){
        String nameProject;
        String name;
        String phone;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type the name project manager:");
        name = reader.next();
    
        System.out.println("Type the phone project manager:");
        phone =reader.next(); 
    
        controller.addManager(nameProject, name, phone);
}

    public void addStage(){
    String nameProject;
    Calendar initialDate;
    Calendar finalDate;
    int monthInitial;
    int monthFinal;
    int monthFinal2 = 0;

    System.out.println("Type the name project: ");
    nameProject = reader.next();
    
    System.out.println("After a few months, the stage begins:");
    monthInitial = reader.nextInt();
    initialDate = Calendar.getInstance();
    initialDate.add(Calendar.MONTH, monthInitial);
    String timeStamp = formatter.format(initialDate.getTime());
	System.out.println("The start date is: "+timeStamp);

	System.out.println("Enter in months how long the stage will last:");
	monthFinal = reader.nextInt();
    monthFinal2 = monthFinal+monthInitial;
	finalDate = Calendar.getInstance();
	finalDate.add(Calendar.MONTH, monthFinal2);
    String timeStamp2 = formatter.format(finalDate.getTime());
	System.out.println("The end date is: "+timeStamp2);

    controller.addStage(nameProject, initialDate, finalDate);

}

public void culminateStage(){
        String nameProject;
        String nameStage;
        Calendar finishStage;
        
        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type name stage:");
        nameStage = reader.next();

        finishStage = Calendar.getInstance();
	    String timeStamp = formatter.format(finishStage.getTime());
        System.out.println("The end date is: "+timeStamp);

        controller.culminateStage(nameProject, nameStage);

       addStage();
}
     public void addCapsule(){
        String nameProject;
        String nameStage;
        String id;
        String description;
        boolean approval = false;
        int option = 0;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type the name stage: ");
        nameStage = reader.next();

        System.out.println("Type id:");
        id = reader.next();

        System.out.println("Type description:");
        reader.next();
        description = reader.nextLine();

        System.out.println("Type capsule:");
        System.out.println("1. Technial");
        System.out.println("2. Management");
        System.out.println("3. Control");
        System.out.println("4. Experience");
        option = reader.nextInt();

        

        controller.addCapsule(nameProject, nameStage, id, description, option, approval);

     }   

     public void addEmployee(){
        String nameProject;
        String id;
        String name;
        String position;

        System.out.println("Type the name stage: ");
        nameProject = reader.next();

        System.out.println("Type the id capsule: ");
        id = reader.next();

        System.out.println("Type the name employee:");
        name = reader.next();
    
        System.out.println("Type the position employee:");
        position =reader.next(); 
    
        controller.addEmployee(nameProject, id, name, position);

     }
     
     public void approvalCapsule(){
        String nameProject;
        String nameStage;
        String id;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type the name stage: ");
        nameStage = reader.next();

        System.out.println("Type ID the capsule:");
        id = reader.next();

        controller.approvalCapsule(nameProject, nameStage, id);
     }

     public void publicationCapsule(){
        String nameProject;
        String nameStage;
        String id;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type the name stage: ");
        nameStage = reader.next();

        System.out.println("Type ID the capsule:");
        id = reader.next();

        String msg = controller.publicationCapsule(nameProject, nameStage, id);
        System.out.println(msg);
     }

     public void consultNumberTypeCapsule(){
        String nameProject;
        String nameStage;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type the name stage: ");
        nameStage = reader.next();

        String msg = controller.consultNumberTypeCapsule(nameProject, nameStage);
        System.out.println(msg);
     }

     public void consultCapsules(){
        String nameProject;
        String nameStage;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        System.out.println("Type the name stage: ");
        nameStage = reader.next();

        String msg = controller.consultCapsules(nameProject, nameStage);
        System.out.println(msg);
     }

     public void consultNumberCapsule(){
        String nameProject;

        System.out.println("Type the name project: ");
        nameProject = reader.next();

        String msg = controller.consultNumberCapsule(nameProject);
        System.out.println(msg);
     }


public int validateIntegerInput(){
    int option = 0; 
    if(reader.hasNextInt()){
        option = reader.nextInt(); 
    }
    else{
        reader.next();
        option = -1; 
        System.out.println("Type a option valid!!"); 
    }
    return option; 
}


}