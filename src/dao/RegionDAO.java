package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;


import exception.SearchNotFoundException;
import model.Region;
import tools.Connect;

public class RegionDAO {

    private Connect connect = new Connect();
    private Logger logger = Logger.getLogger(RegionDAO.class.getName());
    
    public List<Region> getAll(){
        String sql = "SELECT * FROM regions";
        List<Region> regions = new ArrayList<>();
        try(PreparedStatement preparedStatement = connect.getConnect().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
                regions.add(region);
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }

        return regions;
    }

    public boolean checkNameRegion(String name){
        boolean checkNumber = Pattern.matches(".*\\d.*", name);
        boolean cehckSymbol = Pattern.compile("[\\p{Punct}]").matcher(name).find();
        if(!checkNumber && !cehckSymbol){
            return true;
        }
        throw new InputMismatchException("Name Is Not Valid!");
    }

    public boolean isEmpty(String name){
        if(name.isEmpty()){
            throw new NullPointerException("Name is Empty!");
        }
        return true;
    }

    private boolean isNull(String name){
        if(name == null){
            throw new NullPointerException("Name is empty!");
        }
        return true;
    }

    public void createNewRegion(Region region){
        String sql = "INSERT INTO regions (name) VALUE(?)";
        try(PreparedStatement preparedStatement = connect.getConnect().prepareStatement(sql)){
            if(isEmpty(region.getName()) && checkNameRegion(region.getName()) && isNull(region.getName())){
                preparedStatement.setString(1, region.getName());
                preparedStatement.executeUpdate();
            }
        }catch (SQLException |
                InputMismatchException |
                NullPointerException
                exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public Region getById(int id){
        String sql = "SELECT * FROM regions WHERE id = ?";

        try(PreparedStatement preparedStatement = connect.getConnect().prepareStatement(sql)){
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if(resultSet.next()){
                        return new Region(resultSet.getInt("id"), resultSet.getString("name"));
                    }else {
                        throw new SearchNotFoundException("Region with id " + id + " not found!");
                    }
                } catch (SQLException exception) {
                    throw new RuntimeException(exception.getMessage());
                }

        } catch(SQLException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public List<Region> searchByName(String name){
        String sql = "SELECT * FROM regions WHERE name LIKE ?"; // + "'%" + "?" + "%'";

        try(PreparedStatement preparedStatement = connect.getConnect().prepareStatement(sql)){

            preparedStatement.setString(1,"%" + name + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    List<Region> regions = new ArrayList<>();
                    Region region = new Region(resultSet.getInt("id"), resultSet.getString("name"));
                    regions.add(region);
                    return regions;
                }else {
                    throw new SearchNotFoundException("Region with name " + name + " not found!");
                }
            } catch (SQLException exception) {
                throw new RuntimeException(exception.getMessage());
            }

        } catch(SQLException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }


    public void updateRegion(String name, int id){
        String sql = "UPDATE regions SET name = ? WHERE id = ?";

        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public void deleteRegion(int id){
        String sql = "DELETE FROM regions WHERE id = ?";

        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeQuery();
        }catch (SQLException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
