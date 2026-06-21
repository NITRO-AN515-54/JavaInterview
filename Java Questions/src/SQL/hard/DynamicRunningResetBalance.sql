/*

Write a SQL query to calculate the running balance for each account ordered by transaction date.

The running balance must reset and start from the current transaction whenever ANY of the following conditions occur:

The previous running balance becomes negative.
The gap between consecutive transactions exceeds 7 days.
The current transaction type is 'RESET'.

Additional Rules:

A reset starts a new running sequence.
The transaction causing the reset should be included as the first row of the new sequence.
Running balances must be calculated independently for each account_id.
Output should be ordered by account_id, txn_date, and txn_id.

-- Create Table
CREATE TABLE Transactions (
    txn_id INT PRIMARY KEY,
    account_id INT NOT NULL,
    txn_date DATE NOT NULL,
    txn_type VARCHAR(20) NOT NULL,
    amount DECIMAL(10,2) NOT NULL
);

-- Insert Sample Data
INSERT INTO Transactions (
    txn_id,
    account_id,
    txn_date,
    txn_type,
    amount
)
VALUES
(1, 101, '2025-01-01', 'CREDIT',  500.00),
(2, 101, '2025-01-02', 'DEBIT',  -100.00),
(3, 101, '2025-01-03', 'DEBIT',  -600.00),
(4, 101, '2025-01-04', 'CREDIT',  200.00),
(5, 101, '2025-01-20', 'CREDIT',  300.00),
(6, 101, '2025-01-21', 'RESET',     0.00),
(7, 101, '2025-01-22', 'CREDIT',  400.00);

Input

txn_id | account_id | txn_date   | txn_type | amount
------------------------------------------------------
1      | 101        | 2025-01-01 | CREDIT   | 500
2      | 101        | 2025-01-02 | DEBIT    | -100
3      | 101        | 2025-01-03 | DEBIT    | -600
4      | 101        | 2025-01-04 | CREDIT   | 200
5      | 101        | 2025-01-20 | CREDIT   | 300
6      | 101        | 2025-01-21 | RESET    | 0
7      | 101        | 2025-01-22 | CREDIT   | 400

Output

txn_id | account_id | txn_date   | txn_type | amount | running_balance
----------------------------------------------------------------------------
1      | 101        | 2025-01-01 | CREDIT   | 500    | 500
2      | 101        | 2025-01-02 | DEBIT    | -100   | 400
3      | 101        | 2025-01-03 | DEBIT    | -600   | -200
4      | 101        | 2025-01-04 | CREDIT   | 200    | 200
5      | 101        | 2025-01-20 | CREDIT   | 300    | 300
6      | 101        | 2025-01-21 | RESET    | 0      | 0
7      | 101        | 2025-01-22 | CREDIT   | 400    | 400

logic

txn_id | running_balance | Explanation
---------------------------------------------------------
1      | 500             | First transaction
2      | 400             | 500 - 100
3      | -200            | 400 - 600
4      | 200             | Reset due to negative balance
5      | 300             | Reset due to 16-day gap
6      | 0               | Explicit RESET transaction
7      | 400             | New sequence after RESET

*/


