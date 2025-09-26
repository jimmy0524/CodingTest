-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(a.total_order) as TOTAL_ORDER
FROM FIRST_HALF as a
join ICECREAM_INFO as b on a.flavor = b.flavor
group by INGREDIENT_TYPE