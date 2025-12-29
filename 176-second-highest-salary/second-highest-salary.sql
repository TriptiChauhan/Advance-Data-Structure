-- using joins
-- select MAX(e1.salary ) AS SecondHighestSalary
-- from employee e1 inner join employee e2
-- where e1.salary<e2.salary;


-- using subqueries
-- select Max(salary) as SecondHighestSalary
-- from employee where salary < (select MAX(salary) from employee );

-- using order by
select(select distinct salary from employee order by salary desc limit 1 offset 1) AS SecondHighestSalary;
