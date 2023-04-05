package model;
/**
 * Employee is the class that represents the employees who create capsules
 */
public class Employee {
    private String name;
    private String position;

    public Employee(String name, String position){
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPosition(String position){
        this.position = position;
    }
}
