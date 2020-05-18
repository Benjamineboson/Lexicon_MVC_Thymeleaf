package com.example.th_lexicon_2.model;

import java.util.Objects;

public class AppUser {

    private static int counter = 0;
    private int appUserId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public AppUser(String firstName, String lastName, String email, String address, String phoneNumber) {
        this.appUserId = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(address, appUser.address) &&
                Objects.equals(phoneNumber, appUser.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, firstName, lastName, email, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
