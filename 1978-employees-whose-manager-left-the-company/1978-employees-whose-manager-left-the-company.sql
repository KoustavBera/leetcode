# Write your MySQL query statement below
-- My approch
-- select e.employee_id
-- from Employees e
-- where e.salary<30000 and not exists
-- (
--     select 1 from Employees m
--     where  e.manager_id = m.employee_id
-- )
-- except
-- select e.employee_id from Employees e where e.salary<30000 and e.manager_id is null order by employee_id

select e.employee_id
from Employees e
where e.salary<30000 and e.manager_id is not null and not exists
(
    select 1 from Employees m
    where  e.manager_id = m.employee_id
) order by e.employee_id
