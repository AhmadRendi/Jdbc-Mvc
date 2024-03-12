package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Job;
import tools.Connect;

public class JobDAO {

    private Connect connect = new Connect();


    public Job getJobById(String job){
        String sql = "SELECT id, title, min_salary, max_salary FROM job" +
                        " WHERE id = ?";

        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setString(1, job);

            Job job2 = new Job();

            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    
                    job2.setId(resultSet.getString("id"));
                    job2.setTitle(resultSet.getString("title"));
                    job2.setMinSalary(resultSet.getInt("min_salary"));
                    job2.setMaxSalary(resultSet.getInt("max_salary"));
                   
                }
            }
            return job2;
        }catch(SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }
    
}
