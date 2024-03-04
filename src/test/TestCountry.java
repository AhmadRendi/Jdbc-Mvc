package test;

import dao.CountryDAO;
import model.Country;

public class TestCountry {

    private static CountryDAO countryDAO = new CountryDAO();
    
    public static void getAll(){
        System.out.println("List of Countries");
        System.out.println("ID | Name \t\t\t|Region");
        for(Country country : countryDAO.getAll()){
            System.out.println(country.getId() + " | " + country.getName() + " \t\t\t|" + country.getRegions().getName());
            // System.out.println(country.getRegions().getName());
        }
    }


    public static void main(String[] args) {
        getAll();
    }
}
