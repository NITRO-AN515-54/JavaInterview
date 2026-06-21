/*

Write SQL query to identify

CREATE TABLE entries (
    name VARCHAR(20),
    address VARCHAR(20),
    email VARCHAR(20),
    floor INT,
    resources VARCHAR(10)
);

insert into entries
values ('A','Bangalore','A@gmail.com',1,'CPU'),
       ('A','Bangalore','A1@gmail.com',1,'CPU'),
       ('A','Bangalore','A2@gmail.com',2,'DESKTOP'),
       ('B','Bangalore','B@gmail.com',2,'DESKTOP'),
       ('B','Bangalore','B1@gmail.com',2,'DESKTOP'),
       ('B','Bangalore','B2@gmail.com',1,'MONITOR')

 Input

 name	 address	   email	  floor	   resources
  A	    Bangalore	A@gmail.com	    1	     CPU
  A	    Bangalore	A1@gmail.com	1	     CPU
  A	    Bangalore	A2@gmail.com	2	   DESKTOP
  B	    Bangalore	B@gmail.com	    2	   DESKTOP
  B	    Bangalore	B1@gmail.com	2	   DESKTOP
  B	    Bangalore	B2@gmail.com	1	   MONITOR

Output

 name    total_visit  most_visited_floor resources_used
  A          3               1           CPU, DESKTOP
  B          3               2           DESKTOP, MONITOR

*/

WITH CTE1 AS
(
SELECT name,[floor] FROM
(SELECT name,
       [floor],
       COUNT(1) AS total_entries,
       RANK() OVER (PARTITION BY name order by COUNT(1) desc) as RN
       FROM entries AS TEMP
       GROUP BY name, [floor]) AS TEMP where RN = 1),
CTE2 AS (
SELECT name, SUM(total_entries) AS total_entry, STRING_AGG(resources, ',') AS resource FROM
(SELECT name,COUNT(1) AS total_entries,resources FROM entries GROUP BY name, resources) AS TEMP
GROUP BY name
)
SELECT a.name, b.total_entry, a.floor, b.resource
FROM CTE1 a
INNER JOIN CTE2 b ON a.name = b.name

