package views;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import dao.RegionDAO;
import model.Region;

public class ViewRegion {

    private Scanner scanner = new Scanner(System.in);

    private RegionDAO regionDAO = new RegionDAO();

    public void viewGetAll(List<Region> listRegions){
        System.out.println("List Of Regions");
        for (Region region : listRegions){
            System.out.println("--------------------");
            System.out.println(region.getId() + " | " + region.getName());
        }
    }

    public Region viewCreateNewRegion(){
        Region region = new Region();
        System.out.print("Masukan Nama Region Baru : ");
        region.setName(scanner.nextLine());
        return region;
    }

    private boolean checkInputIsNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException exception){
            throw new NumberFormatException("Input Must Be Number!");
        }
    }

    public void viewGetById(String id){
        if(checkInputIsNumber(id)){
            int number = Integer.parseInt(id);
            Region region = regionDAO.getById(number);
            System.out.println("ID \t| Nama Region");
            System.out.println("--------------------");
            System.out.println(region.getId() + " \t| " + region.getName());
        }
    }
}
