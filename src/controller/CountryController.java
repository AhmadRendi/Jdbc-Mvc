package controller;

import java.util.List;

import dao.CountryDAO;
import dao.RegionDAO;
import dto.CountryDTO;
import exception.ItemIsAlreadyException;
import exception.SearchNotFoundException;
import model.Country;
import views.ViewCountry;

public class CountryController {
    
    private CountryDAO countryDAO = new CountryDAO();
    private ViewCountry viewCountry = new ViewCountry();
    private RegionDAO regionDAO = new RegionDAO();

    private boolean checkListIsEmpty(List<Country> countries){
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

    private boolean checkInputIsEmpty(String input){
        if(input.isEmpty()){
            throw new NullPointerException("Input Can't Blank");
        }

        return true;
    }

    private String toUpperCase(String input){
        return input.toUpperCase();
    }

    public void getById(String id){
        try {
            checkInputIsEmpty(id);
            id = toUpperCase(id);
            checkCountryByIdIsNotReady(id);
            Country country = countryDAO.getById(id);
            viewCountry.viewGetById(country);
        } catch (NullPointerException |
                SearchNotFoundException
                exception) {
            System.out.println(exception.getMessage());
        }
    }

    private boolean checkCountryByIdIsNotReady(String id){

        Country country = countryDAO.getById(id);
        if(country.getId() != null){
            return true;
        }
        throw new SearchNotFoundException("country with id " + id + " not found");
    }

    private void checkSearch(String name){
        if(countryDAO.searchByName(name).isEmpty()){
            throw new SearchNotFoundException("Country by Name " + name + " Not Found");
        }
    } 


    public void searchByName(String name){
        try{
            checkInputIsEmpty(name);
            checkSearch(name);

            viewCountry.viewSearchByName(countryDAO.searchByName(name));

        }catch (NullPointerException |
                SearchNotFoundException
                exception
        ){
            System.out.println(exception.getMessage());
        }
    }

    private boolean checkIdRegion(Integer idRegion){
        try{
            regionDAO.getById(idRegion);
            return true;
        }catch (SearchNotFoundException exception){
            throw new SearchNotFoundException(exception.getMessage());
        }
    }

    private boolean checkIdCountryIsAlReady(String idCountry){
        Country country = countryDAO.getById(idCountry);
        if(country.getId() != null){
            throw new ItemIsAlreadyException("Country with id " + idCountry + " is already");
        }

        return true;

    }

    public void createNewCountry(){
        try{

            CountryDTO countryDTO = viewCountry.viewCreateNewCountry();
            countryDTO.getId().toUpperCase();
            checkInputIsEmpty(countryDTO.getName());
            checkInputIsEmpty(countryDTO.getId());
            checkIdRegion(countryDTO.getIdRegion());
            checkIdCountryIsAlReady(countryDTO.getId());

            countryDAO.createNewCountry(countryDTO);

        }catch (NullPointerException |
                SearchNotFoundException |
                ItemIsAlreadyException
                exception){
            System.out.println(exception.getMessage());
        }
    }


    public void updateCoutry(){
        try{
            CountryDTO countryDTO = viewCountry.viewUpdateCountry();

            getById(countryDTO.getId());
            checkInputIsEmpty(countryDTO.getName());
            checkIdRegion(countryDTO.getIdRegion());

            countryDAO.updateCoutry(countryDTO);
        }catch (NullPointerException |
                SearchNotFoundException |
                IllegalStateException
                exception){
            System.out.println(exception.getMessage());
        }
    }
}
