USE Deneme;

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    ProductType VARCHAR(50),
    City VARCHAR(50),
    State CHAR(2),
    Amount DECIMAL(10, 2),
    OrderDate DATE
);


INSERT INTO Orders (OrderID, ProductType, City, State, Amount, OrderDate) VALUES
(1, 'Electronics', 'New York', 'NY', 1200.50, '2026-01-05'),
(2, 'Clothing', 'Los Angeles', 'CA', 85.00, '2026-01-06'),
(3, 'Home Decor', 'Chicago', 'IL', 210.30, '2025-01-07'),
(4, 'Electronics', 'Houston', 'TX', 550.00, '2023-01-08'),
(5, 'Books', 'Phoenix', 'AZ', 45.90, '2026-01-09'),
(6, 'Clothing', 'Philadelphia', 'PA', 120.00, '2024-01-10'),
(7, 'Sports', 'San Antonio', 'TX', 300.00, '2026-01-11'),
(8, 'Home Decor', 'San Diego', 'CA', 150.75, '2024-01-12'),
(9, 'Electronics', 'Dallas', 'TX', 890.00, '2026-01-13'),
(10, 'Books', 'San Jose', 'CA', 25.00, '2024-01-14'),
(11, 'Clothing', 'Austin', 'TX', 65.40, '2023-01-15'),
(12, 'Sports', 'Jacksonville', 'FL', 420.00, '2026-01-16'),
(13, 'Home Decor', 'Fort Worth', 'TX', 95.00, '2025-01-17'),
(14, 'Electronics', 'Columbus', 'OH', 1100.00, '2023-01-18'),
(15, 'Books', 'Charlotte', 'NC', 35.20, '2026-01-19'),
(16, 'Clothing', 'San Francisco', 'CA', 210.00, '2024-01-20'),
(17, 'Sports', 'Indianapolis', 'IN', 180.50, '2026-01-21'),
(18, 'Home Decor', 'Seattle', 'WA', 320.00, '2023-01-22'),
(19, 'Electronics', 'Denver', 'CO', 750.00, '2026-01-23'),
(20, 'Books', 'Washington', 'DC', 15.00, '2025-01-24');