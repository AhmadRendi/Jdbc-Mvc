package controller;

import java.util.List;
import java.util.Scanner;

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
    private Scanner scanner = new Scanner(System.in);

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


    public void deleteCountryById(){
        String id = viewCountry.viewDeleteCountry();

        try{
            checkInputIsEmpty(id);
            checkCountryByIdIsNotReady(id);

            countryDAO.deleteCountry(id);
        }catch (NullPointerException |
                SearchNotFoundException
                exception){
            System.out.println(exception.getMessage());
        }
    }


    public void menu(){
        System.out.println("Menu Country");
        System.out.println("1. Lihat Semua Country");
        System.out.println("2. Tambah Country");
        System.out.println("3. Lihat Country Berdasarkan ID");
        System.out.println("4. Cari Country Berdasarkan Nama");
        System.out.println("5. Update Country");
        System.out.println("6. Hapus Country");
        System.out.println("7. Keluar");
    }

    private boolean checkInputIsNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException exception){
            throw new NumberFormatException("Input Must Be Number!");
        }
    }



    public void viewAllCountry(){        
        
        int pilihan = 0;
        String pilih;
        while (pilihan != 7){
            System.out.println('\f');
            menu();
            System.out.print("Pilihan : ");
            pilih = scanner.nextLine();
            System.out.print("\033[H\033[2J");  
            
            try{
                checkInputIsNumber(pilih);
                pilihan = Integer.parseInt(pilih);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            switch (pilihan){
                case 1:
                    getAll();
                    break;
                case 2:
                    createNewCountry();
                    break;
                case 3:
                    System.out.print("Masukan ID Region : ");
                    String id = scanner.nextLine();
                    getById(id);
                    break;
                case 4:
                    System.out.print("Masukan Nama Region : ");
                    String name = scanner.nextLine();
                    searchByName(name);
                    break;
                case 5:
                    updateCoutry();
                    break;
                case 6:
                    deleteCountryById();
                    break;
                case 7:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia!");
            }
        }

    }
}
