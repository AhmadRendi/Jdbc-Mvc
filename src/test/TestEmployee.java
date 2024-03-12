package test;

import java.time.LocalDate;
import java.util.Scanner;

import controller.EmployeeController;

import java.sql.Date;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import dto.EmployeeDTO;
import model.Departement;
import model.Employee;
import model.Job;
import views.ViewEmployee;

public class TestEmployee {

    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static JobDAO jobDAO = new JobDAO();
    private static DepartmentDAO dao = new DepartmentDAO();
    private static ViewEmployee employee = new ViewEmployee();
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeController controller = new EmployeeController();


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

    public static void testInsertPartTwo(){
        EmployeeDTO mDto = employee.viewCreateNewEmployee();
        System.out.println("---------------------------------------------");
        System.out.print("Masukan ID job : ");
        String idJob = scanner.nextLine();

        Job job = jobDAO.getJobById(idJob);

        mDto.setJob(job);

        System.out.println(mDto.getEmail());
        System.out.println(mDto.getDepartement());
        System.out.println(mDto.getJob().getTitle());
        System.out.println(mDto.getCommission());
    }


    public static void searchById(){
        Employee employee = employeeDAO.searchEmployeeById(100);

        System.out.println("Berhasil");
        System.out.println(employee.getFirstName());
        System.out.println(employee.getJob().getId());
        System.out.println(employee.getJob().getTitle());
        System.out.println(employee.getDepartement().getName());
    }

    public static void main(String[] args) {
        // testInsert();
        // testInsertPartTwo();
        // insert();
        // searchById();
        testSearchById();
    }   


    public static void insert(){
        controller.createNewEmployee();
    }

    public static void testSearchById(){
        controller.searchById();
    }

}
