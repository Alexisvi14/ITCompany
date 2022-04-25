package com.solvd.generalPurpose;

public class Address <T, V>{
    private T country;
    private T state;
    private T city;
    private T street;
    private V streetNumber;
    private V zipCode;


    public Address() {}

    public Address (T street, V streetNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public Address (T country, T state, T city, T street, V streetNumber) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public T getCountry() {
        return country;
    }

    public void setCountry(T country) {
        this.country = country;
    }

    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public T getCity() {
        return city;
    }

    public void setCity(T city) {
        this.city = city;
    }

    public T getStreet() {
        return street;
    }

    public void setStreet(T street) {
        this.street = street;
    }

    public V getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(V streetNumber) {
        this.streetNumber = streetNumber;
    }

    public V getZipCode() {
        return zipCode;
    }

    public void setZipCode(V zipCode) {
        this.zipCode = zipCode;
    }
}
