package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Region;

public class ViewRegion {

    private Scanner scanner = new Scanner(System.in);

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

    public void viewGetById(Region region){
            System.out.println("ID \t| Nama Region");
            System.out.println("--------------------");
            System.out.println(region.getId() + " \t| " + region.getName());
    }

    public void viewSearchByName(List<Region> region){
        System.out.println("ID \t| Nama Region");
        for(Region region2 : region){
            System.out.println("--------------------");
            System.out.println(region2.getId() + " \t| " + region2.getName());
        }
    }

    public List<String> viewUpdateRegion(){
        System.out.print("Masukan ID Region : ");
        String id = scanner.nextLine();
        System.out.print("Masukan Nama Region Baru : ");
        String name = scanner.nextLine();
        List<String> list = new ArrayList<>();
        list.add(id);
        list.add(name);
        return list;
    }
    
    public String viewDeleteRegion(){
        System.out.print("Masukan ID Region : ");
        String id = scanner.nextLine();
        return id;
    }
}
