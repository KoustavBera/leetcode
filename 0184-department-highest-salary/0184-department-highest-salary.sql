# Write your MySQL query statement below
 with Db as (
    select d.name as Department, e.name as Employee, e.salary as Salary from Employee e join Department d on e.departmentId = d.id 
 )

 select Department, Employee, Salary
 from 
 (
    select Department, Employee, Salary, dense_rank() over (
        partition by Department
        order by Salary desc
    ) as rnk
    from Db
 ) t where rnk = 1