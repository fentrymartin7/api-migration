### Practicals

Given the following table 'employees'...

| id | firstName | lastName | salary | dept |
| --- | -------- | -------- | ------ | ---- |
| 1  | Michael   | Scott    | 65     | Sales|
| 2  | Dwight    | Schrute  | 75     | Sales|
| 3  | Toby      | Flenderson| 80    | HR  |
| 4  | Jim       | Halpert  | 90     | Sales|
| 5  | Oscar     | Martinez | 90     | Accounting |
| 6  | Angela    | Martin   | 75     | Accounting |
| 7  | Kevin     | Malone   | 70     | Accounting |
| 8  | Holly     | Flax     | 60     | HR |
| 9  | Creed     | Branton  | 70     | Quality Assurance |

1. Write a query to find all data in the table
- select * from employees;

2. Write a query to find employees with a salary over 75
- select * from employees where salary > 75;

3. Write a query to find employees whose first name contains an 'e' or whose last name begins with 'S'\
- select * from employees where firsName like '%e%' or lastName like 'S%';

4. Write a query to find the first name of all employees who do not work in accounting
- select firstName from employees where dept != 'Accounting';

5. Write a query to find the average salary of all employees whose last names begin with 'M'
- select avg(salary) from employees where lastName like 'M%';

6. Write a query to find the highest paid salesperson
- select max(salary) from employees where dept = 'Sales';

7. Write a query to combine the resultsets of any two previous queries
- select avg(salary) from employees where lastName like 'M%'
  union select max(salary) from employees where dept = 'Sales';
  
8. Remove all members of accounting from the database
- delete * from employees where dept = 'Accounting';

* Given removing the dept column from the employees table and creating a table 'department' and linking the two via a foreign key relationship

| dept_id | name |
| ------- | ---  |
| 1       | Sales |
| 2       | HR   |
| 3       | Accounting |
| 4       | Customer Service |

9. Write a query to find the salary of the lowest paid salesperson (HINT: use a join)
- select min(salary) from employees join department on (employees.id=department.employee_id);

10. Write a query to find the average salary of each department
- select avg(salary) from employees order by dept;

11. Write a query to find all possible combinations of employees and departments. How many records do you expect?
- select * from employees join department;

12. Change the name of department 4 to 'Quality Assurance'
- update department set name = 'Quality Assurance' where dept_id = 4;

13. Remove both tables
- drop table employees,department;
