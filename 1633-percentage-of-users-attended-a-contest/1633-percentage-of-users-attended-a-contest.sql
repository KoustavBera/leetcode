# Write your MySQL query statement below
select contest_id, ifnull(round(count(r.user_id)*100/(select count(user_id) from Users),2),0) as percentage 
from Register r group by r.contest_id order by percentage desc, contest_id