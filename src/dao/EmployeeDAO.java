package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.EmployeeDTO;
import tools.Connect;

public class EmployeeDAO {
    

    private Connect connect = new Connect();


    public void createNewEmployee(EmployeeDTO employeeDTO){
        String sql = "INSERT INTO employee (id, first_name, last_name, email," +
                    " phone_number, hire_date, salary, commission_pct, manager, job," +
                    " department) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql) ){
            statement.setInt(1, employeeDTO.getId());
            statement.setString(2, employeeDTO.getFirstName());
            statement.setString(3, employeeDTO.getLastName());
            statement.setString(4, employeeDTO.getEmail());
            statement.setString(5, employeeDTO.getPhoneNumber());
            statement.setDate(6, employeeDTO.getHireDate());
            statement.setInt(7, employeeDTO.getSalary());
            statement.setDouble(8, employeeDTO.getCommission());
            statement.setInt(9, employeeDTO.getManager());
            statement.setString(10, employeeDTO.getJob().getId());
            statement.setInt(11, employeeDTO.getDepartement().getId());


            statement.executeUpdate();

        }catch (SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }

}
