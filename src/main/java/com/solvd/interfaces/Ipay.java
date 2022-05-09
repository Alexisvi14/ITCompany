package com.solvd.interfaces;

import com.solvd.staff.Employee;

@FunctionalInterface
public interface Ipay{
    void pay(Employee employee, int cost);
}
