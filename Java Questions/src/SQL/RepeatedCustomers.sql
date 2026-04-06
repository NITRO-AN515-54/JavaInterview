/*
Write a query that will provide the customers are repeated in nature, from first day till last day how many time it gets repeated

CREATE TABLE customer_orders (
    order_id INT,
    customer_id INT,
    order_date DATE,
    order_amount INT
);

insert into customer_orders values(1,100,cast('2022-01-01' as date),2000),
                                  (2,200,cast('2022-01-01' as date),2500),
                                  (3,300,cast('2022-01-01' as date),2100),
                                  (4,100,cast('2022-01-02' as date),2000),
                                  (5,400,cast('2022-01-02' as date),2200),
                                  (6,500,cast('2022-01-02' as date),2700),
                                  (7,100,cast('2022-01-03' as date),3000),
                                  (8,400,cast('2022-01-03' as date),1000),
                                  (9,600,cast('2022-01-03' as date),3000)

Input

order_id	customer_id	order_date	order_amount
1	           100	    2022-01-01	   2000
2 	           200	    2022-01-01	   2500
3	           300	    2022-01-01	   2100
4	           100	    2022-01-02	   2000
5	           400	    2022-01-02	   2200
6	           500	    2022-01-02	   2700
7	           100	    2022-01-03	   3000
8	           400	    2022-01-03	   1000
9	           600	    2022-01-03	   3000

Expected output

order_date	new_customer	old_customer
2022-01-01	     3	             0
2022-01-02	     2	             1
2022-01-03	     1	             2
*/

SELECT order_date,
       SUM (CASE WHEN RN = 1 THEN 1 ELSE 0 END) AS new_customer,
       SUM (CASE WHEN RN > 1 THEN 1 ELSE 0 END) AS old_customer
FROM
(SELECT order_date,
       customer_id,
       ROW_NUMBER() OVER (partition by customer_id order by order_date asc) AS RN
FROM customer_orders) AS Temp
GROUP BY order_date