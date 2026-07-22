# Write your MySQL query statement below
select categories.category as category, ifnull(counts.accounts_count, 0) as accounts_count
from
(SELECT 'Low Salary' AS category
UNION ALL
SELECT 'Average Salary'
UNION ALL
SELECT 'High Salary') categories
left join
(
select category, count(*) as accounts_count from
(select case when income < 20000 then "Low Salary"
            when income>=20000 and income<=50000 then "Average Salary"
            when income>50000 then "High Salary" 
        end as category,
        income
        from Accounts) t  group by category 
) counts
    on categories.category = counts.category 
