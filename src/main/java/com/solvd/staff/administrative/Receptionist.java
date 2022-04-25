package com.solvd.staff.administrative;

import com.solvd.ItCompany;
import com.solvd.customerRelated.Appointment;
import com.solvd.customerRelated.Customer;
import com.solvd.exceptions.AppointmentNotFoundException;
import com.solvd.staff.Developer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;

public class Receptionist extends Administrative {
    private static Logger LOGGER = LogManager.getLogger(Receptionist.class);


    public Receptionist(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    public void addAppointment(ItCompany itComp, LocalDate date, LocalTime time, Developer developer,
                               Customer customer, double cost) {

        Appointment app = new Appointment(date, time, developer, customer, cost);
        itComp.getAppoints().add(app);
        customer.getAppoints().add(app);
        developer.getAppoints().add(app);
        LOGGER.info("Appointment registered successfully");
    }

    public void removeAppointment(ItCompany itComp, Appointment appoints){
        if (itComp.getAppoints().add(appoints)){
            itComp.getAppoints().remove(appoints);
            LOGGER.info("Appointment removed succesfully");
        } else {
            throw new AppointmentNotFoundException("The appointment you want to remove does not exist");
        }
    }
    @Override
    public String ToString() {
        return null;
    }

    @Override
    public void printable() {

    }
}

