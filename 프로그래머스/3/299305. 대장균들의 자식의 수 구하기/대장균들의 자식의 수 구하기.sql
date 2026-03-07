-- 코드를 작성해주세요
select parent.id as ID, count(child.id) as CHILD_COUNT
from ECOLI_DATA parent
left join ECOLI_DATA child on child.parent_id = parent.id
group by parent.id
order by parent.id asc;