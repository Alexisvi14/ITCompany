package com.solvd.staff;

import com.solvd.customerRelated.Appointment;
import com.solvd.customerRelated.Customer;
import com.solvd.enums.Necessity;
import com.solvd.enums.Speciality;
import com.solvd.exceptions.AppointmentNotFoundException;
import com.solvd.interfaces.Idev;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee implements Idev {
    private static final Logger LOGGER = LogManager.getLogger(Developer.class);

    private long npi;
    private Speciality speciality;
    private List<Appointment> appoints = new ArrayList<>();

    public Developer(String firstName, String lastName, int id, Speciality speciality) {
        super(firstName, lastName, id);
        this.speciality = speciality;
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

    public List<Appointment> getAppoints() {
        return appoints;
    }

    public void setAppoints(List<Appointment> appoints) {
        this.appoints = appoints;
    }

    public void attendAppointment(Appointment appoint, Customer customer) throws AppointmentNotFoundException, AccountNotFoundException {
        if (appoints != null && this.getAppoints().contains(appoint) && customer.getAppoints().contains(appoint)) {
                customer.payAppointment(appoint);
        }else{
            throw new AppointmentNotFoundException("Can´t find appointment");
        }
            if (customer.hasNecessity()) {
            LOGGER.info("Customer need attention");
            Necessity tmpNecessity = Necessity.getRandomNecessity();
            this.serveCustomer(customer, tmpNecessity);
            } else {
            LOGGER.info("Customer does not need attention");
        }
    }
    public void serveCustomer(Customer customer, Necessity necessity){
        LOGGER.info("Attention for: " + necessity.getNecessityLabel() + " has been given to the customer");
    }


    @Override
    public void dev(Developer developer) {

    }
}
