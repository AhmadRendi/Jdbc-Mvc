package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Integer salary;
    private List<Employee> employeeManager;
    private Integer manager;
    // private Employee manager;
    private Job job;
    private Departement departement;
    private Double commission;


    public Employee(){

    }

    public Employee(Integer id, String firstName, String lastName,
                    String email, String phoneNumber, Date hireDate,
                    Integer salary, Integer manager, Job job, Departement departement,
                    Double commission){
        
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
        this.commission = commission;
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

    public void setHireDate(Date hireDate){
        this.hireDate = hireDate;
    }

    public Date getHireDate(){
        return this.hireDate;
    }

    public void setSalary(Integer salary){
        this.salary = salary;
    }

    public Integer getSalary(){
        return this.salary;
    }



    public void setManager(Integer manager){
        this.manager = manager;
    }

    public Integer getManager(){
        return this.manager;
    }

    // public void setManager(List<Integer> manager){
    //     this.manager = manager;
    // }

    // public List<Integer> getManager(){
    //     return this.manager;
    // }

    // public void manager(List<Integer> manager){
    //     this.manager = manager;
    // }

    // public String manager(){
    //     return this.manager;
    // }

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

    public void setCommission(Double commission){
        this.commission = commission;
    }

    public Double getCommission(){
        return this.commission;
    }
}
