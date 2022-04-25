package com.solvd.customerRelated;

import com.solvd.enums.Necessity;

public class Attention {
    private boolean isEffective;
    private Customer customer;
    private String description;
    private Necessity necessity;

    public Attention(){}

    public Attention(Necessity necessity) {
        this.necessity = necessity;
        this.description = necessity.getAttention();
    }

    public boolean isEffective() {
        return isEffective;
    }

    public void setEffective(boolean effective) {
        isEffective = effective;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Necessity getNecessity() {
        return necessity;
    }

    public void setNecessity(Necessity necessity) {
        this.necessity = necessity;
    }
    @Override
    public String toString(){
        return "Attention: " + this.description;
    }
}
