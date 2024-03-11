package test;

import java.time.LocalDate;
import java.sql.Date;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import dto.EmployeeDTO;
import model.Departement;
import model.Job;

public class TestEmployee {

    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static JobDAO jobDAO = new JobDAO();
    private static DepartmentDAO dao = new DepartmentDAO();


    private static void testInsert(){

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(207);
        dto.setFirstName("Ahmad");
        dto.setLastName("Rendi");
        dto.setEmail("ahmadrendi");
        dto.setPhoneNumber("0822");

        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        dto.setHireDate(date);
        dto.setSalary(3500);
        dto.setCommission(0.359);
        dto.setManager(101);

        Job job = jobDAO.getJobById("AC_ACCOUNT");
        Departement departement = dao.getDepartmentById(90);

        dto.setJob(job);
        dto.setDepartement(departement);

        employeeDAO.createNewEmployee(dto);




    }

    public static void main(String[] args) {
        testInsert();
    }

}
