package model;

public class Country {
    private String id;
    private String name;
    private Region region;

    public Country(){

    }

    public Country(String id, String name){
        this.id = id;
        this.name = name;
    }


    public Country(String id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }


    public void setId(String id){
        this.id = id;
    }


    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setRegion(Region regions){
        this.region= regions;
    }

    public Region getRegions(){
        return this.region;
    }
}

