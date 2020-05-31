-- Write a sql query to find nth largest salary along with employee name?
select e.EmpName, s.Salary from Salary s
join Employee e
ON s.EmpID = e.EmpID
   ORDER   BY salary DESC
   LIMIT 1 OFFSET N-1;         -- where N is used to find Nth largest
  

-- Write a query to update salary of employees to 5000 whose age is 30+
UPDATE Salary
SET Salary = Salary + 5000
WHERE EXISTS (
	select s.salary from Salary s
	join Employee e
	on e.EmpID = s.EmpID
	where (
			CAST(
			STRFTIME('%Y-%m-%d', 'NOW') - STRFTIME('%Y-%m-%d', Date_of_birth) 
			AS INT)
	      ) > 30
	);
