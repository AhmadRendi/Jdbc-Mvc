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


    public Country getById(String id){
        String sql = "SELECT countries.id, countries.name, regions.name, regions.id FROM countries JOIN regions ON countries.region = regions.id WHERE countries.id = ?";

        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setString(1, id);
            Country country = new Country();
            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    country = new Country(resultSet.getString("id"), resultSet.getString("name"), new Region(resultSet.getInt("regions.id"), resultSet.getString("regions.name")));
                }
            }
            return country;
        }catch (SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }

    public List<Country> searchByName(String name){
        String sql = "SELECT countries.name, countries.id, regions.name, regions.id FROM countries " +
            "JOIN regions ON countries.region = regions.id " +
            "WHERE countries.name LIKE ?";

            try (PreparedStatement statement = connect.getConnect().prepareStatement(sql)) {
                statement.setString(1, "%" + name + "%");

                List<Country> list = new ArrayList<>();

                try (ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Country country = new Country(resultSet.getString("id"), resultSet.getString("name"), new Region(resultSet.getInt("regions.id"), resultSet.getString("regions.name")));
                        list.add(country);
                    }
                }

                return list;
            } catch (SQLException exception) {
                // TODO: handle exception
                throw new IllegalStateException(exception.getMessage());
            }
    }

}
