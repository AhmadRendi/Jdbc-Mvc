package controller;

import java.util.List;

import dao.CountryDAO;
import model.Country;
import views.ViewCountry;

public class CountryController {
    
    private CountryDAO countryDAO = new CountryDAO();
    private ViewCountry viewCountry = new ViewCountry();


    public boolean checkListIsEmpty(List<Country> countries){
        if(countries.isEmpty()){
            throw new NullPointerException("Country is empty");
        }
        return true;
    }

    public void getAll(){
        try{
            checkListIsEmpty(countryDAO.getAll());

            viewCountry.viewGetAll(countryDAO.getAll());
        }catch(NullPointerException exception){
            System.out.println(exception.getMessage());
        }
    }
}
