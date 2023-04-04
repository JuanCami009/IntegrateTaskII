package model;

public class Capsule {
    private String id;
    private String description;
    private String typeCapsule;
    private boolean approval;

    public Capsule(String id, String description, String typeCapsule, boolean approval){
        this.id = id;
        this.description = description;
        this.typeCapsule = typeCapsule;
        this.approval = approval;
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
}
