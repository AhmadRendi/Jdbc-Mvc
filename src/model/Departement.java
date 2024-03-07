package model;

public class Departement {
    
    private Integer id;
    private String name;
    private Integer manager;

    public Departement(Integer id, String name, Integer manager){
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setManager(Integer manager){
        this.manager = manager;
    }

    public Integer getManager(){
        return this.manager;
    }
}
