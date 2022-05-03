package com.solvd.staff.administrative;

import com.solvd.ItCompany;
import com.solvd.exceptions.InsufficientFundsException;
import com.solvd.interfaces.Ipay;
import com.solvd.staff.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Accountant extends Employee implements Ipay {
    private static final Logger LOGGER = LogManager.getLogger(Accountant.class);

    public Accountant(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    @Override
    public String ToString() {
        return null;
    }

    public void payEmployee(ItCompany itComp, Employee employee) {
        if (itComp.getAccount().withdraw(employee.getSalary())) {
            employee.getAccount().deposit(employee.getSalary());
            LOGGER.info("Payment done successfully");
        } else throw new InsufficientFundsException("");
    }


    @Override
    public void pay(Employee employee, int cost) {
    }
}
