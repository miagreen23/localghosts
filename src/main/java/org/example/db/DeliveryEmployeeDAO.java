package org.example.db;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDAO {
    public List<Integer> getDeliveryEmployeesIds() {
        try {
            Connection conn = DatabaseConnector.getConnection();
            String SQL = "SELECT employee_id, first_name, last_name, salary, bank_account_number, national_insurance_number FROM employee JOIN delivery_employee USING(employee_id)";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(SQL);

            List<Integer> employeeIds = new ArrayList<>();
            while(rs.next()){
                System.out.println(rs.getInt("employee_id"));
                employeeIds.add(rs.getInt("employee_id"));
            }

            return employeeIds;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
