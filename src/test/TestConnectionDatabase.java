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

    public static void main(String[] args) {
        testGetAll();
    }
}
