SELECT member_id, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE 
where GENDER = 'W' and month(DATE_OF_BIRTH) = 3 and  TLNO is not null
order by member_id