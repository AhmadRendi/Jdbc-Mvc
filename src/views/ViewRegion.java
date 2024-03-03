package views;

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
}
