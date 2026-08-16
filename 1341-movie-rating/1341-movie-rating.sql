-- # Write your MySQL query statement below
-- select user_id 
-- from (
--     select user_id, count(movie_id) as cnt from MovieRating group by user_id
-- ) t having t.cnt = max(t.cnt)
(select u.name as results from 
Users u 
join MovieRating m on u.user_id = m.user_id
group by u.user_id, u.name
order by count(*) desc, u.name asc limit 1
)

union all
(
select m.title as results from 
Movies m join MovieRating mr on 
m.movie_id  = mr.movie_id
where mr.created_at >= '2020-02-1' and mr.created_at < '2020-03-01'
group by m.movie_id, m.title
order by avg(mr.rating) desc, m.title asc limit 1
)