package views;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dto.EmployeeDTO;
import model.Employee;

public class ViewEmployee {


    private Scanner scanner = new Scanner(System.in);


    public EmployeeDTO viewCreateNewEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Nama Depan : ");
        String fisrtName = scanner.nextLine();
        employeeDTO.setFirstName(fisrtName);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Nama Belakang : ");
        String lastName = scanner.nextLine();
        employeeDTO.setLastName(lastName);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Email Anda : ");
        String email = scanner.nextLine();
        employeeDTO.setEmail(email);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Nomor Telepon Anda : ");
        String phoneNume = scanner.nextLine();
        employeeDTO.setPhoneNumber(phoneNume); 
        LocalDate localDate  = LocalDate.now();
        Date date = Date.valueOf(localDate);
        employeeDTO.setHireDate(date);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Jumlah Gaji : ");
        Integer gaji = scanner.nextInt();
        employeeDTO.setSalary(gaji);
        System.out.println("---------------------------------------------");
        System.out.print("Masukan Jumlah komisi : ");
        Float komisi = scanner.nextFloat();
        employeeDTO.setCommission(Double.valueOf(komisi.toString()));
        return employeeDTO;

    }


    public void searchById(Employee employee){
        System.out.println("id |      name     |      email       |      telepon      |          salary       |           job         |           departmen");
        System.out.println(employee.getId() + " | " +
        employee.getFirstName() + " " + employee.getLastName() +
        " \t| " + employee.getEmail() + " \t| " + employee.getPhoneNumber() + 
        " \t| " + employee.getSalary() + " \t\t| " + employee.getJob().getTitle() +
        " \t\t| " + employee.getDepartement().getName());
    }


    public void viewSearchByName(List<Employee> list){
        System.out.println("id |      name     |      email       |      telepon      |          salary       |           job         |           departmen");
        for(Employee employee : list){
            System.out.println(employee.getId() + " | " +
            employee.getFirstName() + " " + employee.getLastName() +
            " \t| " + employee.getEmail() + " \t| " + employee.getPhoneNumber() + 
            " \t| " + employee.getSalary() + " \t\t| " + employee.getJob().getTitle() +
            " \t\t| " + employee.getDepartement().getName());
            System.out.println("---------------------------------------------");
        }
    }

    public void viewGetAll(List<Employee> list){
        System.out.println("id |      name     |      email       |      telepon      |          salary       |           job         |           departmen");
        for(Employee employee : list){
            System.out.println(employee.getId() + " | " +
            employee.getFirstName() + " " + employee.getLastName() +
            " \t| " + employee.getEmail() + " \t| " + employee.getPhoneNumber() + 
            " \t| " + employee.getSalary() + " \t\t| " + employee.getJob().getTitle() +
            " \t\t| " + employee.getDepartement().getName());
            System.out.println("---------------------------------------------");
        }
    }

    public String deleteById(){
        System.out.println("---------------------------------------------");
        System.out.print("Masukan ID employee : ");
        String id = scanner.nextLine();
        return id;
    }

}
