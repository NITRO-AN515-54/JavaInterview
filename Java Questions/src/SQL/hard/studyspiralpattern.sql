/*

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| student_name | varchar |
| major        | varchar |
+--------------+---------+
student_id is the unique identifier for this table.
Each row contains information about a student and their academic major.
Table: study_sessions

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| session_id    | int     |
| student_id    | int     |
| subject       | varchar |
| session_date  | date    |
| hours_studied | decimal |
+---------------+---------+
session_id is the unique identifier for this table.
Each row represents a study session by a student for a specific subject.
Write a solution to find students who follow the Study Spiral Pattern - students who consistently study multiple subjects in a rotating cycle.

A Study Spiral Pattern means a student studies at least 3 different subjects in a repeating sequence
The pattern must repeat for at least 2 complete cycles (minimum 6 study sessions)
Sessions must be consecutive dates with no gaps longer than 2 days between sessions
Calculate the cycle length (number of different subjects in the pattern)
Calculate the total study hours across all sessions in the pattern
Only include students with cycle length of at least 3 subjects
Return the result table ordered by cycle length in descending order, then by total study hours in descending order.

The result format is in the following example.

*/

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    major VARCHAR(100) NOT NULL
);

CREATE TABLE study_sessions (
    session_id INT PRIMARY KEY,
    student_id INT NOT NULL,
    subject VARCHAR(100) NOT NULL,
    session_date DATE NOT NULL,
    hours_studied DECIMAL(5,2) NOT NULL,

    CONSTRAINT FK_student
        FOREIGN KEY (student_id)
        REFERENCES students(student_id)
);

INSERT INTO students (student_id, student_name, major) VALUES
(1, 'Alice Chen', 'Computer Science'),
(2, 'Bob Johnson', 'Mathematics'),
(3, 'Carol Davis', 'Physics'),
(4, 'David Wilson', 'Chemistry'),
(5, 'Emma Brown', 'Biology');

INSERT INTO study_sessions (session_id, student_id, subject, session_date, hours_studied)
VALUES
(1, 1, 'Math', '2023-10-01', 2.5),
(2, 1, 'Physics', '2023-10-02', 3.0),
(3, 1, 'Chemistry', '2023-10-03', 2.0),
(4, 1, 'Math', '2023-10-04', 2.5),
(5, 1, 'Physics', '2023-10-05', 3.0),
(6, 1, 'Chemistry', '2023-10-06', 2.0),
(7, 2, 'Algebra', '2023-10-01', 4.0),
(8, 2, 'Calculus', '2023-10-02', 3.5),
(9, 2, 'Statistics', '2023-10-03', 2.5),
(10, 2, 'Geometry', '2023-10-04', 3.0),
(11, 2, 'Algebra', '2023-10-05', 4.0),
(12, 2, 'Calculus', '2023-10-06', 3.5),
(13, 2, 'Statistics', '2023-10-07', 2.5),
(14, 2, 'Geometry', '2023-10-08', 3.0),
(15, 3, 'Biology', '2023-10-01', 2.0),
(16, 3, 'Chemistry', '2023-10-02', 2.5),
(17, 3, 'Biology', '2023-10-03', 2.0),
(18, 3, 'Chemistry', '2023-10-04', 2.5),
(19, 4, 'Organic', '2023-10-01', 3.0),
(20, 4, 'Physical', '2023-10-05', 2.5);

WITH ordered AS (
    SELECT
        s.student_id,
        s.subject,
        s.session_date,
        s.hours_studied,
        ROW_NUMBER() OVER (PARTITION BY s.student_id ORDER BY s.session_date) AS rn,
        LAG(s.session_date) OVER (PARTITION BY s.student_id ORDER BY s.session_date) AS prev_date
    FROM study_sessions s
),

-- Keep only sessions where gap <= 2 days
valid_sessions AS (
    SELECT *
    FROM ordered
    WHERE prev_date IS NULL
       OR DATEDIFF(DAY, prev_date, session_date) <= 2
),

-- Generate possible cycle lengths (3 to 8, adjust if needed)
cycle_lengths AS (
    SELECT 3 AS cycle_length UNION ALL
    SELECT 4 UNION ALL
    SELECT 5 UNION ALL
    SELECT 6 UNION ALL
    SELECT 7 UNION ALL
    SELECT 8
),

-- Assign position in cycle
cycle_assign AS (
    SELECT
        v.student_id,
        v.subject,
        v.hours_studied,
        v.rn,
        c.cycle_length,
        (v.rn - 1) % c.cycle_length AS pos
    FROM valid_sessions v
    CROSS JOIN cycle_lengths c
),

-- Check if each position has consistent subject
pattern_check AS (
    SELECT
        student_id,
        cycle_length,
        pos,
        MIN(subject) AS min_sub,
        MAX(subject) AS max_sub
    FROM cycle_assign
    GROUP BY student_id, cycle_length, pos
),

-- Only keep valid patterns (same subject per position)
valid_patterns AS (
    SELECT
        student_id,
        cycle_length
    FROM pattern_check
    GROUP BY student_id, cycle_length
    HAVING COUNT(*) = SUM(CASE WHEN min_sub = max_sub THEN 1 ELSE 0 END)
),

-- Aggregate final results
final_calc AS (
    SELECT
        ca.student_id,
        ca.cycle_length,
        COUNT(*) AS total_sessions,
        COUNT(DISTINCT ca.subject) AS distinct_subjects,
        SUM(ca.hours_studied) AS total_hours
    FROM cycle_assign ca
    JOIN valid_patterns vp
        ON ca.student_id = vp.student_id
       AND ca.cycle_length = vp.cycle_length
    GROUP BY ca.student_id, ca.cycle_length
)

SELECT
    f.student_id,
    st.student_name,
    st.major,
    f.cycle_length,
    f.total_hours AS total_study_hours
FROM final_calc f
JOIN students st
    ON f.student_id = st.student_id
WHERE
    f.distinct_subjects = f.cycle_length
    AND f.total_sessions >= 2 * f.cycle_length
ORDER BY
    f.cycle_length DESC,
    total_study_hours DESC;
