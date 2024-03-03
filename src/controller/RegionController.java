package controller;

import dao.RegionDAO;
import views.ViewRegion;

public class RegionController {
    private RegionDAO regionDAO = new RegionDAO();
    private ViewRegion viewRegion = new ViewRegion();

    public void getAll(){
        viewRegion.viewGetAll(regionDAO.getAll());
    }

    public void createNewRegion(){
        try {
            regionDAO.createNewRegion(viewRegion.viewCreateNewRegion());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
