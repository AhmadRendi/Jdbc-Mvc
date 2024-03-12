package views;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import dto.EmployeeDTO;

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


}
