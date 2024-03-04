package views;

import java.util.List;

import model.Country;

public class ViewCountry {
    
    public void viewGetAll(List<Country> countries){
        System.out.println("List of Countries");
        System.out.println("ID | Name \t\t\t|Region");
        for (Country country : countries){
            System.out.println(country.getId() + " | " + country.getName() + " | " + country.getRegions().getName());
        }
    }

}
