# Write your MySQL query statement below
select t.student_id, t.student_name, t.subject_name,
count(e.subject_name) as attended_exams
from 
(select * from Students s cross join Subjects s2)
as t left join Examinations e on  t.student_id = e.student_id and t.subject_name = e.subject_name group by t.student_id,t.student_name, t.subject_name order by t.student_id, t.subject_name 