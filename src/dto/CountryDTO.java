package dto;

public class CountryDTO {
    private String id;
    private String name;
    private Integer idRegion;

    public CountryDTO(){
        
    }


    public CountryDTO(String id, String name, Integer idRegions){
        this.id = id;
        this.name = name;
        this.idRegion = idRegions;
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

    public void setIdRegion(Integer idRegion){
        this.idRegion = idRegion;
    }

    public Integer getIdRegion(){
        return this.idRegion;
    }
}
