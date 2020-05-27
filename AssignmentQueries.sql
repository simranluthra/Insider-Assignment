-- Write a sql query to find nth largest salary along with employee name?
SELECT e.EmpName, s.Salary FROM Salary s
JOIN Employee e
ON s.EmpID = e.EmpID
ORDER  BY salary DESC
OFFSET N-1 ROWS                    -- where N is used to find Nth largest
FETCH NEXT 1 ROWS ONLY;
   

-- Write a query to update salary of employees to 5000 whose age is 30+
UPDATE (
select s.salary from Salary s
join Employee e
on e.EmpID = s.EmpID
where trunc(months_between(sysdate,Date_of_birth)/12)>30
) t
set t.Salary = t.Salary+5000;