--I made the department/employee a multi-to-multi just in case an employee were to have 2 departments. 


INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_name)
VALUES ('writer', 'Green', 'Joe', 'M', '01/08/1974', '01/01/2020', 'writing'), 
('editer', 'Jones', 'Mike', 'M', '02/07/1984', '01/01/2020', 'editing'),
('publisher', 'Zappa', 'Frank', 'M', '03/06/1995', '01/01/2020', 'publishing'),
('writer', 'Zimmermen', 'Ashley', 'F', '04/05/1983', '01/01/2020', 'writing'),
('writer', 'Powers', 'Kayla', 'F', '05/04/1991', '01/01/2020', 'writing'),
('writer', 'Stevenson', 'Leslie', 'F', '06/03/1972', '01/01/2020', 'writing'),
('editer', 'Green', 'Jeb', 'M', '07/02/1992', '01/01/2020', 'editing'),
('publisher', 'Higgins', 'Mike', 'M', '08/01/2001', '01/01/2020', 'publishing');

INSERT INTO project (name, start_date)
VALUES ('Project Red', '10/20/2020'),
('Project Blue', '11/25/2020'),
('Project Green', '12/10/2020'),
('Project Yellow', '11/05/2020');

INSERT INTO department (name)
VALUES ('writing'), ('editing'), ('publishing');

INSERT INTO department_category (employee_number, department_number)
VALUES (1, 1), (2, 2), (3, 3), (4, 1), (5, 1), (6, 1), (7, 2), (8, 3);

INSERT INTO project_category (employee_number, project_number)
VALUES (1, 1), (2, 1), (3, 1), (4, 2), (5, 2), (6, 2), (2, 2), (3, 2), (7, 3), (8, 3), (1, 3), (4, 4), (2, 4), (8, 4); 
