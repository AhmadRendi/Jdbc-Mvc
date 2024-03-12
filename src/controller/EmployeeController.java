package controller;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import dto.EmployeeDTO;
import exception.SearchNotFoundException;
import model.Departement;
import model.Job;
import views.ViewEmployee;

public class EmployeeController {
    

    private ViewEmployee viewEmployee = new ViewEmployee();
    private EmployeeDAO dao = new EmployeeDAO();
    private JobDAO jDao = new JobDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private Scanner scanner = new Scanner(System.in);

    private void jobIsFound(String idJob){
        Job job = jDao.getJobById(idJob);
        if(job.getTitle() == null){
            throw new SearchNotFoundException("Job with ID " + idJob + " Not Found");
        }
    }

    private void departementIsFound(Integer idDepertment){
        Departement departement = departmentDAO.getDepartmentById(idDepertment);
        if(departement.getName() == null){
            throw new SearchNotFoundException("Department with ID " + idDepertment + " Not Found");
        }
    }


    public void createNewEmployee(){

        try{
            EmployeeDTO employeeDTO = viewEmployee.viewCreateNewEmployee();
            System.out.println("---------------------------------------------");
            System.out.print("Masukan ID job : ");
            String idJob = scanner.nextLine();
            jobIsFound(idJob);
            Job job = jDao.getJobById(idJob);
            employeeDTO.setJob(job);
            System.out.println("---------------------------------------------");
            System.out.println("Masukan ID Manager : ");
            Integer manager = scanner.nextInt();
            employeeDTO.setManager(manager);
            System.out.println("---------------------------------------------");
            System.out.println("Masukan ID Departement : ");
            Integer idDepartement = scanner.nextInt();
            departementIsFound(idDepartement);
            Departement departement = departmentDAO.getDepartmentById(idDepartement);
            employeeDTO.setDepartement(departement);

            dao.createNewEmployee(employeeDTO);

        }catch(SearchNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }


}
