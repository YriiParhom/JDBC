select product_name
from ORDERS
         join CUSTOMERS c on ORDERS.customer_id = c.id
where name = lower(:name);