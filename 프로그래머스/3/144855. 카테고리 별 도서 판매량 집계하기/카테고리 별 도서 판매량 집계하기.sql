-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) as TOTAL_SALES
from book_sales as a
join book as b on a.book_id = b.book_id
where year(a.sales_date) = 2022 and month(a.sales_date) = 1
group by category
order by category asc