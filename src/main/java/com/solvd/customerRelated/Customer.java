package com.solvd.customerRelated;

import com.solvd.enums.Necessity;
import com.solvd.generalPurpose.BankAccount;
import com.solvd.generalPurpose.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Customer.class);

    private BankAccount account;
    private List<Appointment> appoints = new ArrayList<Appointment>();
    private int customerNumber;
    private String eMail;
    private Necessity necessity;
    private boolean hasNecessity;

    public Customer(String firstName, String lastName, int customerNumber, String eMail) {
        super(firstName, lastName);
        this.customerNumber = customerNumber;
        this.eMail = eMail;
        Random rd = new Random();
        this.hasNecessity = rd.nextBoolean();
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public List<Appointment> getAppoints() {
        return appoints;
    }

    public void setAppoints(List<Appointment> appoints) {
        this.appoints = appoints;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Necessity getNecessity() {
        return necessity;
    }

    public void setNecessity(Necessity necessity) {
        this.necessity = necessity;
    }

    public boolean hasNecessity() {
        return hasNecessity;
    }

    public void setHasNecessity(boolean hasNecessity) {
        this.hasNecessity = hasNecessity;
    }

    public void receiveAttention (Attention attention) {
        Random rd = new Random();
        this.setHasNecessity(rd.nextBoolean());
        if (this.hasNecessity() == false) {
            attention.setEffective(true);
            LOGGER.info("The customer has received solution for " + attention.getNecessity().getNecessityLabel());
        } else {
            attention.setEffective(false);
            LOGGER.info("The customer has not received solution for " + attention.getNecessity().getNecessityLabel());
        }
    }
    public void payAppointment(Appointment app) throws AccountNotFoundException {
        if (this.getAccount() == null) {
            throw new AccountNotFoundException("Customer does not own a bank account");
        } else {
            this.getAccount().withdraw(app.getCost());
        }
    }


    @Override
    public String ToString(){
        return "Customer information: \n" + "First name: " + getFirstName() + "\nLast name: " + getLastName() +
                "\nEmail :" + geteMail() + "\nNecessity: " + getNecessity();
    }

    @Override
    public void printable() {

    }
}
