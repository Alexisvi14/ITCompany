package com.solvd.staff;

import com.solvd.interfaces.Iclean;

public class CleaningStaff extends Employee implements Iclean {

    public CleaningStaff(String firstName, String lastName, int id) {
        super(firstName, lastName, id);
    }

    @Override
    public String ToString() {
        return null;
    }

    @Override
    public void clean() {
    }
}
