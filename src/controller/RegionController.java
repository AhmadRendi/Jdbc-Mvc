package controller;

import dao.RegionDAO;
import views.ViewRegion;

public class RegionController {
    private RegionDAO regionDAO = new RegionDAO();
    private ViewRegion viewRegion = new ViewRegion();

    public void getAll(){
        viewRegion.viewGetAll(regionDAO.getAll());
    }
}
