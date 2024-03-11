package model;

public class Job {
    private String id;
    private String title;
    private Integer minSalary;
    private Integer maxSalary;

    public Job(){
        
    }


    public Job(String id, String title, Integer minSalary, Integer maxSalary){
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setMinSalary(Integer minSalary){
        this.minSalary = minSalary;
    }

    public Integer getMinSalary(){
        return this.minSalary;
    }

    public void setMaxSalary(Integer maxSalary){
        this.maxSalary = maxSalary;
    }

    public Integer getMaxSalary(){
        return this.maxSalary;
    }
}
