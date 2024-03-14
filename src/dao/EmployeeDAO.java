package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EmployeeDTO;
import model.Departement;
import model.Employee;
import model.Job;
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

    public Employee searchEmployeeById(Integer id){
        String sql = "SELECT employee.id, first_name, last_name, email, phone_number," +
                        " hire_date, salary, commission_pct, employee.manager, job.id, department," +
                        " job.title, job.min_salary, job.max_salary," +
                        " departmen.id , departmen.name" +
                        " FROM employee" +
                        " JOIN job ON employee.job = job.id" +
                        " JOIN departmen ON  employee.department = departmen.id" +
                        "  WHERE employee.id = ?";


        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setInt(1, id);
            Employee employee = new Employee();
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setHireDate(resultSet.getDate("hire_date"));
                    employee.setSalary(resultSet.getInt("salary"));
                    employee.setCommission(resultSet.getDouble("commission_pct"));
                    employee.setManager(resultSet.getInt("manager"));
                    employee.setJob(new Job(resultSet.getString("job.id"), resultSet.getString("job.title"), resultSet.getInt("job.min_salary"),resultSet.getInt("job.max_salary")));
                    employee.setDepartement(new Departement(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("manager")));

                }
            }
            return employee;
        }catch(SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }

    public List<Employee> searchEmployeesByName(String name){
        String sql = "SELECT employee.id, first_name, last_name, email, phone_number," +
                    " hire_date, salary, commission_pct, employee.manager, job.id, department," +
                    " job.title, job.min_salary, job.max_salary," +
                    " departmen.id , departmen.name" +
                    " FROM employee" +
                    " JOIN job ON employee.job = job.id" +
                    " JOIN departmen ON  employee.department = departmen.id" +
                    "  WHERE employee.first_name LIKE ?";

            try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
                statement.setString(1, "%" + name + "%");
                List<Employee> list = new ArrayList<>();
               
                try(ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setId(resultSet.getInt("id"));
                        employee.setFirstName(resultSet.getString("first_name"));
                        employee.setLastName(resultSet.getString("last_name"));
                        employee.setEmail(resultSet.getString("email"));
                        employee.setPhoneNumber(resultSet.getString("phone_number"));
                        employee.setHireDate(resultSet.getDate("hire_date"));
                        employee.setSalary(resultSet.getInt("salary"));
                        employee.setCommission(resultSet.getDouble("commission_pct"));
                        employee.setManager(resultSet.getInt("manager"));
                        employee.setJob(new Job(resultSet.getString("job.id"), resultSet.getString("job.title"), resultSet.getInt("job.min_salary"),resultSet.getInt("job.max_salary")));
                        employee.setDepartement(new Departement(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("manager")));
                        list.add(employee);
                    }
                }

            return list;
            }catch(SQLException exception){
                throw new IllegalStateException(exception.getMessage());
            }
    }

    public List<Employee> getAll(){

        String sql = "SELECT employee.id, first_name, last_name, email, phone_number," +
                    " hire_date, salary, commission_pct, employee.manager, job.id, department," +
                    " job.title, job.min_salary, job.max_salary," +
                    " departmen.id , departmen.name" +
                    " FROM employee" +
                    " JOIN job ON employee.job = job.id" +
                    " JOIN departmen ON  employee.department = departmen.id";
        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

                List<Employee> list = new ArrayList<>();

                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setHireDate(resultSet.getDate("hire_date"));
                    employee.setSalary(resultSet.getInt("salary"));
                    employee.setCommission(resultSet.getDouble("commission_pct"));
                    employee.setManager(resultSet.getInt("manager"));
                    employee.setJob(new Job(resultSet.getString("job.id"), resultSet.getString("job.title"), resultSet.getInt("job.min_salary"),resultSet.getInt("job.max_salary")));
                    employee.setDepartement(new Departement(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("manager")));
                    list.add(employee);
                }
            return list;
        }catch(SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }

    public void deleteById(Integer id){
        String sql = "DELETE FROM employee WHERE id = ?";

        try(PreparedStatement statement = connect.getConnect().prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new IllegalStateException(exception.getMessage());
        }
    }

}
