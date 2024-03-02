package views;

import java.util.List;

import model.Region;

public class ViewRegion {

    public void viewGetAll(List<Region> listRegions){
        System.out.println("List Of Regions");
        for (Region region : listRegions){
            System.out.println("--------------------");
            System.out.println(region.getId() + " | " + region.getName());
        }
    }
}
