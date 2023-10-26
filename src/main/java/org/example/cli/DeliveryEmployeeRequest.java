package org.example.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {

    // Variable declaration for vars which can be updated
    private String firstName;
    private String lastName;
    private double salary;
    private String bankAccountNumber;
    private String niNumber;

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public String getBankAccountNumber() { return bankAccountNumber; }

    public void setBankAccountNumber(String bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }

    public String getNiNumber() { return niNumber; }

    public void setNiNumber(String niNumber) { this.niNumber = niNumber; }

    // JSON constructor
    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("salary") double salary,
            @JsonProperty("bankAccountNumber") String bankAccountNumber,
            @JsonProperty("niNumber") String niNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.niNumber = niNumber;
    }
}
