-- 코드를 작성해주세요

select ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
from item_tree it
join item_info ii on it.item_id = ii.item_id
join item_info pii on it.parent_item_id = pii.item_id
where pii.rarity = 'RARE' 
order by ii.ITEM_ID desc