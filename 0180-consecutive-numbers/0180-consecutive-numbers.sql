# Write your MySQL query statement below
select distinct num as ConsecutiveNums from
(select id, num, lead(num, 1) over(order by id) as lead_1,lead(num, 2) over(order by id) as lead_2  from Logs  ) t where t.num = t.lead_1 and t.lead_1 = t.lead_2