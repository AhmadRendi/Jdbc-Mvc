package views;

import java.util.List;

import model.Country;

public class ViewCountry {
    
    public void viewGetAll(List<Country> countries){
        System.out.println("\f");
        System.out.println("List of Countries");
        System.out.println("ID | Name \t\t\t|Region");
        for (Country country : countries){
            System.out.println("---------------------------------------------");
            System.out.println(country.getId() + " | " + country.getName() + " \t\t\t| " + country.getRegions().getName());
        }
    }

    public void viewGetById(Country country){
        System.out.println("ID | Name \t\t\t|Region");
        System.out.println("---------------------------------------------");
        System.out.println(country.getId() + " | " + country.getName() + " \t\t\t| " + country.getRegions().getName());
    }

    public void viewSearchByName(List<Country> countries){
        System.out.println("ID | Name \t\t\t|Region");
        for (Country country : countries){
            System.out.println("---------------------------------------------");
            System.out.println(country.getId() + " | " + country.getName() + " \t\t\t| " + country.getRegions().getName());
        }
    }

}
