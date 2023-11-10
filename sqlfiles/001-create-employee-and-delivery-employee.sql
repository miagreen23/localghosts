USE JavaBeans_MeganM;

-- create employee table
CREATE table employee (
	employee_id smallint unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(70) NOT NULL,
    last_name varchar(70) NOT NULL,
    salary decimal(10,2) NOT NULL,
    bank_account_number varchar(8) NOT NULL,
    national_insurance_number varchar(9) NOT NULL,
    PRIMARY KEY (employee_id)
);

-- creating delivery_employee table
CREATE TABLE delivery_employee (
    employee_id smallint unsigned AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (employee_id)
	REFERENCES employee(employee_id)
);

-- add some data to employee table
INSERT INTO employee (first_name, last_name, salary, bank_account_number, national_insurance_number)
VALUES ('Jane', 'Doe', 27000, '38293847', 'HJ389493D');

INSERT INTO employee (first_name, last_name, salary, bank_account_number, national_insurance_number)
VALUES ('John', 'Smith', 21000, '38402888', 'FH394874R');

-- make the new employees delivery employees
INSERT INTO delivery_employee
(employee_id)
VALUES (1);

INSERT INTO delivery_employee
(employee_id)
VALUES (2);