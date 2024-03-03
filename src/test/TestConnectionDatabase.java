package test;


import dao.RegionDAO;
import model.Region;
import views.ViewRegion;

public class TestConnectionDatabase {

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

    public static void testGetById(){
        RegionDAO regionDAO = new RegionDAO();
        // Region region = regionDAO.getById(1);

        // System.out.println(region.getId() + " | " + region.getName());
        ViewRegion viewRegion = new ViewRegion();
        viewRegion.viewGetById("0.1");
    }

    public static void testSearchByName(){
        RegionDAO regionDAO = new RegionDAO();
        Region region = regionDAO.searchByName("");
        System.out.println(region.getId() + " | " + region.getName());
    }


    public static void main(String[] args) {
        testSearchByName();
    }
}
