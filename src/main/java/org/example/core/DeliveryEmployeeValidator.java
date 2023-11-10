package org.example.core;

import org.example.cli.DeliveryEmployee;
import org.example.cli.DeliveryEmployeeRequest;

public class DeliveryEmployeeValidator {
    public String isValidDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee){
        System.out.println(deliveryEmployee.getSalary());
        if(deliveryEmployee.getSalary() <= 0){
            return "Salary cannot be less than zero";
        }

        if(deliveryEmployee.getBankAccountNumber().length() != 8){
            return "Bank account number length must be 8 provided " + deliveryEmployee.getBankAccountNumber().length();
        }

        String nationalInsuranceNumber = deliveryEmployee.getNiNumber();

        if(nationalInsuranceNumber.length() == 9){
            return "National insurance number length must be 9 provided: " + deliveryEmployee.getNiNumber().length();
        }

        return null;
    }
}
