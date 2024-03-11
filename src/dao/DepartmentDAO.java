package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Departement;
import tools.Connect;

public class DepartmentDAO {
    
    private Connect connect = new Connect();


    public Departement getDepartmentById(Integer id){
        String sql = "SELECT id, name, manager FROM departmen" + 
                        " WHERE id = ?";

        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setInt(1, id);

            Departement departement = new Departement();

            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    departement.setId(resultSet.getInt("id"));
                    departement.setName(resultSet.getString("name"));
                    departement.setManager(resultSet.getInt("manager"));
                }
            }

            return departement;

        }catch(SQLException exception){
            throw new  IllegalStateException(exception.getMessage());
        }
    }

}
