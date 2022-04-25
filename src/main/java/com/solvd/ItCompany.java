package com.solvd;

import com.solvd.customerRelated.Appointment;
import com.solvd.exceptions.EmployeeNotFoundException;
import com.solvd.generalPurpose.Address;
import com.solvd.generalPurpose.BankAccount;
import com.solvd.staff.Developer;
import com.solvd.staff.administrative.Accountant;
import com.solvd.staff.administrative.Receptionist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ItCompany {
    private static final Logger LOGGER = LogManager.getLogger(ItCompany.class);

    private String name;
    private Address address;
    private String telNumber;
    private BankAccount account;
    private List<Accountant> accountant = new ArrayList<>();
    private List<Developer> devs = new ArrayList<>();
    private List<Receptionist> recs = new ArrayList<>();
    private List<Appointment> appoints = new ArrayList<>();

    public ItCompany(){}

    public ItCompany(String name) {
        this.name = name;
    }

    public ItCompany(String name, double balance) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public List<Accountant> getAccountant() {
        return accountant;
    }

    public void setAccountant(List<Accountant>accountant) {
        this.accountant = accountant;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public List<Developer> getDevs() {
        return devs;
    }

    public void setDev(List<Developer> devs) {
        this.devs = devs;
    }

    public List<Receptionist> getRecs() {
        return recs;
    }

    public void setRecs(List<Receptionist> recs) {
        this.recs = recs;
    }

    public List<Appointment> getAppoints() {
        return appoints;
    }

    public void setAppoints(List<Appointment> appoints) {
        this.appoints = appoints;
    }

    public void addRecepcionist(Receptionist recs) {
        this.getRecs().add(recs);
        LOGGER.info("Recepcionist added succesfully");
    }

    public void removeRecepcionist(Receptionist recs) {
        if (this.getRecs().contains(recs)) {
            getRecs().remove(recs);
            LOGGER.info("Receptionist removed succesfully");
        }
    }

    public void addAccountant(Accountant accountant) {
        this.getAccountant().add(accountant);
        LOGGER.info("Accountant added succesfully");
    }

    public void addDeveloper(Developer developer) {
        this.getDevs().add(developer);
        LOGGER.info("Developer added succesfully");
    }

    public void removeDeveloper(Developer developer) {
        if (this.getDevs().contains(developer)) {
            getDevs().remove(developer);
            LOGGER.info("Developer removed succesfully");
        } else {
            throw new EmployeeNotFoundException
                    ("The developer you' re trying to remove does not work for this company");
        }
    }
}
