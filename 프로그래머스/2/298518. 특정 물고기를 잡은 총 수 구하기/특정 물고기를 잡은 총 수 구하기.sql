-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO
join FISH_NAME_INFO on FISH_NAME_INFO.fish_type = FISH_INFO.fish_type
where FISH_NAME = "BASS" or FISH_NAME = "SNAPPER"