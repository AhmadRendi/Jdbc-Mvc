package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import model.Region;
import tools.Connect;

public class RegionDAO {

    private Connect connect = new Connect();
    
    public List<Region> getAll(){
        String sql = "SELECT * FROM regions";
        List<Region> regions = new ArrayList<>();
        try(PreparedStatement preparedStatement = connect.getConnect().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
                regions.add(region);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return regions;
    }

    public void connect(){
        String sql = "SELECT * FROM regions";
        try(PreparedStatement preparedStatement = connect.getConnect().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            
            System.out.println("Connected");
        }catch(SQLException exception){
            throw new RuntimeErrorException(new Error(exception.getMessage()));
        }
    }
}
