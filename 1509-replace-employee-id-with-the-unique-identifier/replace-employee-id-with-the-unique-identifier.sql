# Write your MySQL query statement below

select empId.unique_id, emp.name
from Employees as emp left join EmployeeUNI as empId
on emp.id = empId.id; 