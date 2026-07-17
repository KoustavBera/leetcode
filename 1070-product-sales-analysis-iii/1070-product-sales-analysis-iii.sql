# Write your MySQL query statement below
with years as
(
    select *, dense_rank() over(
        partition by product_id
        order by year
    ) as rn
    from Sales
)

select product_id, year as first_year, quantity, price
from years where rn=1