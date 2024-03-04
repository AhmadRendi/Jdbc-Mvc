package test;


import java.util.List;

import dao.RegionDAO;
import model.Region;
import tools.Connect;
import views.ViewRegion;

public class TestConnectionDatabase {

    public static void testConnection(){
        Connect connect = new Connect();
        System.out.println(connect.getConnect());
    }

    public static void testCreatenewRegion(){
        RegionDAO regionDAO = new RegionDAO();
        Region region = new Region();
        // region.setName("Jawa Barat..");
        try {
            region.setName("Jawa Barat");
            regionDAO.checkNameRegion(region.getName());
            regionDAO.isEmpty(region.getName());
            regionDAO.createNewRegion(region);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testGetAll(){
        RegionDAO regionDAO = new RegionDAO();
        ViewRegion viewRegion = new ViewRegion();
        viewRegion.viewGetAll(regionDAO.getAll());
    }

    public static void testSearchByName(){
        RegionDAO regionDAO = new RegionDAO();
        List<Region> region = regionDAO.searchByName("A");
        for(Region region2 : region){
            System.out.println(region2.getId() + " | " + region2.getName());
        
        }
    }


    public static void main(String[] args) {
        testConnection();
    }
}
