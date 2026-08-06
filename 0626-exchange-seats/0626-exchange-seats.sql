# Write your MySQL query statement below
select 
case when id % 2 = 0 then id-1
     when (id = (select max(id) from Seat) ) then id
     when id %2 != 0 then id+1
end 
as id, student
from seat
order by id