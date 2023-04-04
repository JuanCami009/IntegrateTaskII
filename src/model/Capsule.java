package model;

public class Capsule {
    private String id;
    private String description;
    private String typeCapsule;

    public Capsule(String id, String description, String typeCapsule){
        this.id = id;
        this.description = description;
        this.typeCapsule = typeCapsule;
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

    public void setId(String id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setTypeCapsule(String typeCapsule){
        this.typeCapsule = typeCapsule;
    }
}
