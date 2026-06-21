/*

create table source(id int, name varchar(5))

create table target(id int, name varchar(5))

insert into source values(1,'A'),(2,'B'),(3,'C'),(4,'D')

insert into target values(1,'A'),(2,'B'),(4,'X'),(5,'F');

id	name
1	A
2	B
3	C
4	D

id	name
1	A
2	B
4	X
5	F

id	Comment
3	exsiting in source
4	mismatch
5	exsiting in target

*/

SELECT id, Comment FROM
(SELECT COALESCE(id1,id2) AS id,CASE WHEN name1 <> name2 THEN 'mismatch'
            WHEN id2 IS NULL THEN 'exsiting in source'
            WHEN id1 IS NULL THEN 'exsiting in target' END AS Comment FROM
(SELECT s.id as id1,s.name as name1,t.id as id2,t.name as name2 FROM source s
FULL JOIN target t
ON s.id = t.id) AS TEMP) AS TEMP2 WHERE Comment IS NOT NULL
