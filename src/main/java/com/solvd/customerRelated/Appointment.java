package com.solvd.customerRelated;

import com.solvd.staff.Developer;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private LocalDate date;
    private LocalTime time;
    private Developer developer;
    private Customer customer;
    private double cost;

    public Appointment() {
    }

    public Appointment(LocalDate date, LocalTime time, Developer developer, Customer customer, double cost) {
        this.date = date;
        this.time = time;
        this.developer = developer;
        this.customer = customer;
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
