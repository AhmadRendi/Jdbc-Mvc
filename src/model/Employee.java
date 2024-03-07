package model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private Integer salary;
    private List<Integer> manager;
    private Job job;
    private Departement departement;


    public Employee(){

    }

    public Employee(Integer id, String firstName, String lastName,
                    String email, String phoneNumber, LocalDate hireDate,
                    Integer salary, List<Integer> manager, Job job, Departement departement){
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.manager = manager;
        this.job = job;
        this.departement = departement;
        }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setHireDate(LocalDate hireDate){
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate(){
        return this.hireDate;
    }

    public void setSalary(Integer salary){
        this.salary = salary;
    }

    public Integer getSalary(){
        return this.salary;
    }

    public void manager(List<Integer> manager){
        this.manager = manager;
    }

    public List<Integer> manager(){
        return this.manager;
    }

    public void setJob(Job job){
        this.job = job;
    }

    public Job getJob(){
        return this.job;
    }

    public void setDepartement(Departement departement){
        this.departement = departement;
    }

    public Departement getDepartement(){
        return this.departement;
    }
}
