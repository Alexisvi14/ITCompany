package com.solvd.staff;

import com.solvd.customerRelated.Customer;
import com.solvd.enums.Necessity;
import com.solvd.enums.Speciality;

public class TestAutomationEngineer extends Employee{
    private long npi;
    private Speciality speciality;

    public TestAutomationEngineer(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    public long getNpi() {
        return npi;
    }

    public void setNpi(long npi) {
        this.npi = npi;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void serveCustomer(Customer customer, Necessity necessity){
        LOGGER.info("Attention for: " + necessity.getNecessityLabel() + "has been given to the customer");
    }

    @Override
    public String toString(){
        return "Test automation engineer information: \n" + "First name: " + super.getFirstName() + "\nLast name: "
        + super.getLastName() + "\nNPI: " + npi + "\nSpeciality" + speciality;
    }
}
