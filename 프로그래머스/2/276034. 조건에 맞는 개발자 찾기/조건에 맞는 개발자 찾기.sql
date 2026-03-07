-- 코드를 작성해주세요
select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS 
join skillcodes on code & skill_code != 0
where name = 'Python' or name = 'C#'
order by id asc;