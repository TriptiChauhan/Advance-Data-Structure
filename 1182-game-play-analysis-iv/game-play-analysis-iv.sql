# Write your MySQL query statement below

-- using subqueries
-- select round (count(distinct player_id)/(select count(distinct player_id) from Activity) 
-- ,2) as fraction
-- from Activity
-- where (player_id,date_sub(event_date,Interval 1 day))IN(
-- select player_id,min(event_date)
-- from Activity group by player_id);

-- using CTE
WITH first_login AS (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
),
next_day_login AS (
    SELECT DISTINCT a.player_id
    FROM Activity a
    JOIN first_login f
      ON a.player_id = f.player_id
     AND a.event_date = DATE_ADD(f.first_date, INTERVAL 1 DAY)
)
SELECT 
    ROUND(
        COUNT(*) / (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2) AS fraction
FROM next_day_login;
