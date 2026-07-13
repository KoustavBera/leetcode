# Write your MySQL query statement below
with FirstOrder as
(
    select *, ROW_NUMBER() over
    (
        partition by customer_id
        order by order_date
    )
    as rn
    from Delivery
)

select
round(avg(order_date = customer_pref_delivery_date) * 100, 2) as immediate_percentage
from FirstOrder
where rn=1