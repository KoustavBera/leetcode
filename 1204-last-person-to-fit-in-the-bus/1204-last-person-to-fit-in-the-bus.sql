# Write your MySQL query statement below
select  person_name from (
select turn, person_id, person_name,  sum(weight)
over (order by turn) as Total_Weight from Queue ) t where Total_Weight <= 1000 order by turn desc limit 1 