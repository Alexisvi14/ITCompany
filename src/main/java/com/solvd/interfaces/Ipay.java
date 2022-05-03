package com.solvd.interfaces;

import com.solvd.ItCompany;
import com.solvd.staff.Employee;
@FunctionalInterface
public interface Ipay{
    public void pay(Employee employee, int cost);
}
