# Write your MySQL query statement below
select e.employee_id
from Employees e
where e.salary<30000 and not exists
(
    select 1 from Employees m
    where  e.manager_id = m.employee_id
)
except
select e.employee_id from Employees e where e.salary<30000 and e.manager_id is null order by employee_id