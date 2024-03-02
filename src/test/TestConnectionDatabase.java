package test;

import java.util.List;

import dao.RegionDAO;
import model.Region;
import tools.Connect;

public class TestConnectionDatabase {

    public static void main(String[] args) {
        RegionDAO regionDAO = new RegionDAO();
        // regionDAO.connect();

        for (Region region : regionDAO.getAll()){
            System.out.println(region.getId() + " " + region.getName());
        }
    }
}
