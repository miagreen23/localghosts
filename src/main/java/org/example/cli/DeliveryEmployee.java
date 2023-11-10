package org.example.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// DeliveryEmployee will extend/inherit from Employee class
public class DeliveryEmployee extends Employee {

    // Constructor for delivery employee, inherits all attributes from parent Employee class
    @JsonCreator
    public DeliveryEmployee( @JsonProperty("id") int id,
                             @JsonProperty("firstName") String firstName,
                             @JsonProperty("lastName") String lastName,
                             @JsonProperty("salary") double salary,
                             @JsonProperty("bankAccountNumber") String bankAccountNumber,
                             @JsonProperty("niNumber") String niNumber) {
        super(id, firstName, lastName, salary, bankAccountNumber, niNumber);
    }

    public String toString(){
        return super.toString();
    }
}
