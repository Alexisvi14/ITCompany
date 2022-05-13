package com.solvd.staff;

import com.solvd.enums.Speciality;
import com.solvd.generalPurpose.Address;
import com.solvd.generalPurpose.BankAccount;
import com.solvd.generalPurpose.Person;
import com.solvd.interfaces.AddEmployee;
import com.solvd.interfaces.Iwork;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Employee extends Person implements AddEmployee, Iwork {
    public static final Logger LOGGER = LogManager.getLogger(Employee.class);
    private int id;
    private double salary;
    private Address address;
    private Speciality speciality;
    private BankAccount account;


    public Employee(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
        this.account = new BankAccount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Employee(String firstName, String lastName, Address address) {
        super(firstName, lastName);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String ToString() {
        return null;
    }

    @Override
    public void addEmployee(int id, String name) {

    }

    @Override
    public void updateEmployee(int id, String name) {
    }

    @Override
    public void removeEmployee(int id) {

    }

    @Override
    public void work() {
        LOGGER.info("This employee is ACTIVE");
    }

    @Override
    public void printable(){
        LOGGER.info("Employee information: " + toString());
    }
}
