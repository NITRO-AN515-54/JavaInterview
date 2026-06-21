/*

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| log_id      | int     |
| ip          | varchar |
| status_code | int     |
+-------------+---------+
log_id is the unique key for this table.
Each row contains server access log information including IP address and HTTP status code.
Write a solution to find invalid IP addresses. An IPv4 address is invalid if it meets any of these conditions:

Contains numbers greater than 255 in any octet
Has leading zeros in any octet (like 01.02.03.04)
Has less or more than 4 octets
Return the result table ordered by invalid_count, ip in descending order respectively.

The result format is in the following example.



Example:

Input:

logs table:

+--------+---------------+-------------+
| log_id | ip            | status_code |
+--------+---------------+-------------+
| 1      | 192.168.1.1   | 200         |
| 2      | 256.1.2.3     | 404         |
| 3      | 192.168.001.1 | 200         |
| 4      | 192.168.1.1   | 200         |
| 5      | 192.168.1     | 500         |
| 6      | 256.1.2.3     | 404         |
| 7      | 192.168.001.1 | 200         |
+--------+---------------+-------------+
Output:

+---------------+--------------+
| ip            | invalid_count|
+---------------+--------------+
| 256.1.2.3     | 2            |
| 192.168.001.1 | 2            |
| 192.168.1     | 1            |
+---------------+--------------+

*/

SELECT ip, COUNT(*) AS invalid_count
FROM logs
WHERE
    -- Must match basic pattern (only digits and dots)
    ip NOT LIKE '[0-9]%.[0-9]%.[0-9]%.[0-9]%'

    -- OR has leading zeros like 001
    OR ip LIKE '%.0[0-9]%'

    -- OR any segment > 255
    OR EXISTS (
        SELECT 1
        FROM STRING_SPLIT(ip, '.') s
        WHERE TRY_CAST(s.value AS INT) > 255
    )

    -- OR not exactly 4 parts
    OR (
        SELECT COUNT(*)
        FROM STRING_SPLIT(ip, '.')
    ) <> 4

GROUP BY ip order by invalid_count desc, ip desc;