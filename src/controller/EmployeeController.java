package controller;

import java.util.List;
import java.util.Scanner;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.JobDAO;
import dto.EmployeeDTO;
import exception.SearchNotFoundException;
import model.Departement;
import model.Employee;
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

    private boolean checkInputIsNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException exception){
            throw new NumberFormatException("Input Must Be Number!");
        }
    }

    public void checkEmployeeById(Integer id){
        Employee employee = dao.searchEmployeeById(id);
        if(employee.getId() == null){
            throw new SearchNotFoundException("employee with ID " + id + " not found");
        } 
    }


    public void searchById(){
        System.out.println("---------------------------------------------");
        System.out.print("Masukan ID Employee : ");
        String id = scanner.nextLine();
        try{
            checkInputIsNumber(id);
            checkEmployeeById(new Integer(id));
            System.out.println("---------------------------------------------");
            viewEmployee.searchById(dao.searchEmployeeById(new Integer(id)));
        }catch (NumberFormatException |
                SearchNotFoundException exception){
           System.out.println(exception.getMessage());
        }
        
    }


    private boolean checkEmployeeByNameIsFound(String name){
        List<Employee> list = null;
        list = dao.searchEmployeesByName(name);
        if (list == null) {
            throw new SearchNotFoundException("employee with name " + name + " not found");
        }

        return true;
    }

    public void searchByName(){
        System.out.println("---------------------------------------------");
        System.out.print("Masukkan Name Employee : ");
        String name = scanner.nextLine();
        try{
            checkEmployeeByNameIsFound(name);
            viewEmployee.viewSearchByName(dao.searchEmployeesByName(name));
        }catch (SearchNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void getAll(){
        viewEmployee.viewGetAll(dao.getAll());
    }

    public void deleteById(){
        try{
            String input = viewEmployee.deleteById();
            checkInputIsNumber(input);
            checkEmployeeById(Integer.valueOf(input));
            dao.deleteById(Integer.valueOf(input));
        }catch(NumberFormatException |
                SearchNotFoundException
                exception){
            System.out.println(exception.getMessage());
        }
    }

    private void menu(){
        System.out.println("Menu Employee");
        System.out.println("1. Lihat Semua Employee");
        System.out.println("2. Tambah Employee");
        System.out.println("3. Lihat Employee Berdasarkan ID");
        System.out.println("4. Cari Employee Berdasarkan Nama");
        System.out.println("5. Hapus Employee");
        System.out.println("6. Keluar");
    }


    public void viewAllEmployee(){        
        
        int pilihan = 0;
        String pilih;
        while (pilihan != 6){
            System.out.println('\f');
            menu();
            System.out.print("Pilihan : ");
            pilih = scanner.nextLine();
            System.out.print("\033[H\033[2J");  
            
            try{
                checkInputIsNumber(pilih);
                pilihan = Integer.parseInt(pilih);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            switch (pilihan){
                case 1:
                    getAll();
                    break;
                case 2:
                    createNewEmployee();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    deleteById();
                    break;
                case 6:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia!");
            }
        }

    }
}
