# Write your MySQL query statement below
select q.query_name, round(avg(q.rating / q.position),2) as quality,
round((SUM(q.rating < 3)) / count(q.query_name) * 100, 2 )as poor_query_percentage from Queries q group by q.query_name