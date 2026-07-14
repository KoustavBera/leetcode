# Write your MySQL query statement below
with firstday as 
(
    select player_id, MIN(event_date)  as firstlogin
    from Activity
    group by player_id
)

select round(count(*)/(select count(*) from firstday), 2) as fraction from
Activity a join firstday f on a.player_id = f.player_id and 
a.event_date = date_add(f.firstlogin, interval 1 day )