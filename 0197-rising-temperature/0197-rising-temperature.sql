-- # Write your MySQL query statement below
-- select id from (select id, temperature - lag(temperature) over (order by recordDate) as dif from Weather) temp where dif > 0

select t1.id
from Weather t1
join Weather t2
on DATEDIFF(t1.recordDate, t2.recordDate) = 1
where t1.temperature > t2.temperature