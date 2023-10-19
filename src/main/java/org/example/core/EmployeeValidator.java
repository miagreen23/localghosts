package org.example.core;

import org.example.cli.Employee;

public class EmployeeValidator {
    public String isValidEmployee(Employee employee){
        if(employee.getSalary() < 0){
            return "Salary cannot be less than zero";
        }

        if(employee.getBankAccountNumber().length() != 8){
            return "Bank account number length must be 8 provided " + employee.getBankAccountNumber().length();
        }

        String nationalInsuranceNumber = employee.getNiNumber();

        if(nationalInsuranceNumber.length() != 9){
            return "National insurance number length must be 9 provided: " + employee.getNiNumber().length();
        }

        return null;
    }
}
