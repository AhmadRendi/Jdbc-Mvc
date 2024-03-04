package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Country;
import model.Region;
import tools.Connect;
public class CountryDAO {
    

    private Connect connect = new Connect();


    public List<Country> getAll(){
        String sql = "SELECT countries.id, countries.name, regions.name, regions.id FROM countries JOIN regions ON countries.region = regions.id";
        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
                List<Country> list = new ArrayList<>();
                while (resultSet.next()) {
                    Region region = new Region(resultSet.getInt("regions.id"), resultSet.getString("regions.name"));
                    Country country = new Country(resultSet.getString("id"), resultSet.getString("name"), region);
                    list.add(country);
                }
                return list;
        }catch(SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }



}
