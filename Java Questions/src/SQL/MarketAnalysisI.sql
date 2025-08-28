/*

Table: Users

+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| user_id        | int     |
| join_date      | date    |
| favorite_brand | varchar |
+----------------+---------+
user_id is the primary key (column with unique values) of this table.
This table has the info of the users of an online shopping website where users can sell and buy items.


Table: Orders

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| order_id      | int     |
| order_date    | date    |
| item_id       | int     |
| buyer_id      | int     |
| seller_id     | int     |
+---------------+---------+
order_id is the primary key (column with unique values) of this table.
item_id is a foreign key (reference column) to the Items table.
buyer_id and seller_id are foreign keys to the Users table.


Table: Items

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| item_id       | int     |
| item_brand    | varchar |
+---------------+---------+
item_id is the primary key (column with unique values) of this table.


Write a solution to find for each user, the join date and the number of orders they made as a buyer in 2019.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Users table:
+---------+------------+----------------+
| user_id | join_date  | favorite_brand |
+---------+------------+----------------+
| 1       | 2018-01-01 | Lenovo         |
| 2       | 2018-02-09 | Samsung        |
| 3       | 2018-01-19 | LG             |
| 4       | 2018-05-21 | HP             |
+---------+------------+----------------+
Orders table:
+----------+------------+---------+----------+-----------+
| order_id | order_date | item_id | buyer_id | seller_id |
+----------+------------+---------+----------+-----------+
| 1        | 2019-08-01 | 4       | 1        | 2         |
| 2        | 2018-08-02 | 2       | 1        | 3         |
| 3        | 2019-08-03 | 3       | 2        | 3         |
| 4        | 2018-08-04 | 1       | 4        | 2         |
| 5        | 2018-08-04 | 1       | 3        | 4         |
| 6        | 2019-08-05 | 2       | 2        | 4         |
+----------+------------+---------+----------+-----------+
Items table:
+---------+------------+
| item_id | item_brand |
+---------+------------+
| 1       | Samsung    |
| 2       | Lenovo     |
| 3       | LG         |
| 4       | HP         |
+---------+------------+
Output:
+-----------+------------+----------------+
| buyer_id  | join_date  | orders_in_2019 |
+-----------+------------+----------------+
| 1         | 2018-01-01 | 1              |
| 2         | 2018-02-09 | 2              |
| 3         | 2018-01-19 | 0              |
| 4         | 2018-05-21 | 0              |
+-----------+------------+----------------+

*/

-- Users table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    join_date DATE NOT NULL,
    favorite_brand VARCHAR(50)
);

-- Items table
CREATE TABLE Items (
    item_id INT PRIMARY KEY,
    item_brand VARCHAR(50)
);

-- Orders table
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    order_date DATE NOT NULL,
    item_id INT,
    buyer_id INT,
    seller_id INT,
    FOREIGN KEY (item_id) REFERENCES Items(item_id),
    FOREIGN KEY (buyer_id) REFERENCES Users(user_id),
    FOREIGN KEY (seller_id) REFERENCES Users(user_id)
);


-- Users data
INSERT INTO Users (user_id, join_date, favorite_brand) VALUES
(1, '2018-01-01', 'Lenovo'),
(2, '2018-02-09', 'Samsung'),
(3, '2018-01-19', 'LG'),
(4, '2018-05-21', 'HP');

-- Items data
INSERT INTO Items (item_id, item_brand) VALUES
(1, 'Samsung'),
(2, 'Lenovo'),
(3, 'LG'),
(4, 'HP');

-- Orders data
INSERT INTO Orders (order_id, order_date, item_id, buyer_id, seller_id) VALUES
(1, '2019-08-01', 4, 1, 2),
(2, '2018-08-02', 2, 1, 3),
(3, '2019-08-03', 3, 2, 3),
(4, '2018-08-04', 1, 4, 2),
(5, '2018-08-04', 1, 3, 4),
(6, '2019-08-05', 2, 2, 4);

SELECT
    u.user_id AS buyer_id,
    u.join_date,
    SUM(CASE
            WHEN o.order_date BETWEEN '2019-01-01' AND '2019-12-31'
            THEN 1
            ELSE 0
        END) AS orders_in_2019
FROM Users u
LEFT JOIN Orders o
    ON u.user_id = o.buyer_id
LEFT JOIN Items i
    ON i.item_id = o.item_id
GROUP BY u.user_id, u.join_date
ORDER BY buyer_id;

