package views;

import java.util.List;
import java.util.Scanner;

import dto.CountryDTO;
import model.Country;

public class ViewCountry {

    private Scanner scanner = new Scanner(System.in);
    
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

    public CountryDTO viewCreateNewCountry(){
        CountryDTO countryDTO = new CountryDTO(null, null, null);
        System.out.println("Masukan Data Country");
        System.out.println("\f");
        System.out.print("Masukan Id Country : ");
        String id = scanner.nextLine();
        countryDTO.setId(id);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Nama Country : ");
        String name = scanner.nextLine();
        countryDTO.setName(name);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan ID Region : ");
        Integer idRegion = scanner.nextInt();
        countryDTO.setIdRegion(idRegion);

        return countryDTO;
    }

}
