USE Deneme;

SET SQL_SAFE_UPDATES = 0;
-- DELETE
DELETE FROM Orders 
WHERE OrderID = 21;
SELECT * FROM Orders;
SET SQL_SAFE_UPDATES = 1;

-- SELECT
SELECT ProductType, City FROM Orders;

-- SELECT DİSTİNCT
SELECT DISTINCT State FROM Orders;

-- WHERE
SELECT * FROM Orders
WHERE ProductType = 'Books';

-- ORDER
SELECT * FROM Orders
ORDER BY Amount;

-- AND
SELECT *
FROM Orders
WHERE ProductType = 'Electronics' AND OrderDate LIKE '2023%';

-- OR
SELECT *
FROM Orders
WHERE State = 'CA' OR State = 'TX';

-- NOT
SELECT *
FROM Orders
WHERE NOT OrderDate LIKE '2026%';

-- İNSERT
INSERT INTO Orders (OrderID, ProductType, City, State, Amount, OrderDate)
VALUES (21, 'Clothing', 'Chicago', 'IL', 344.50, '2024-01-30');

-- NULL
SELECT City
FROM Orders
WHERE OrderDate IS NULL;

-- UPDATE
UPDATE Orders
SET City = 'Kahramanmaraş'
WHERE OrderID = 8;
SELECT * FROM Orders
WHERE City = 'Kahramanmaraş';


SET SQL_SAFE_UPDATES = 0;
-- DELETE
DELETE FROM Orders 
WHERE City = 'Kahramanmaraş';
SELECT * FROM Orders
WHERE OrderID = 1;
SET SQL_SAFE_UPDATES = 1;

-- TOP
SELECT * FROM Orders LIMIT 4;

-- MIN
SELECT MIN(Amount)
FROM Orders;

-- MAX
SELECT MAX(Amount)
FROM Orders;

-- COUNT
SELECT COUNT(*)
FROM Orders;

SELECT COUNT(City)
FROM Orders;

SELECT COUNT(DISTINCT State)
FROM Orders;

-- SUM
SELECT SUM(OrderID)
FROM Orders;

-- AVG
SELECT AVG(Amount)
FROM Orders;

-- LİKE ve WİLDCARD
SELECT * FROM Orders
WHERE City LIKE 's%';

-- İN
SELECT * FROM Orders
WHERE State IN ('CA', 'TX', 'PA');

-- BETWEEN
SELECT * FROM Orders
WHERE OrderID BETWEEN 10 AND 15;

-- ALIASES
SELECT OrderID as ID
FROM Orders;

-- INNER JOIN
SELECT O.OrderID, O.ProductType, S.SupplierName
FROM Orders O
INNER JOIN Suppliers S ON O.ProductType = S.ProductType;

-- LEFT JOIN
SELECT O.OrderID, O.ProductType, S.SupplierName
FROM Orders O
LEFT JOIN Suppliers S ON O.ProductType = S.ProductType;

-- RIGHT JOIN
SELECT O.OrderID, S.ProductType, S.SupplierName
FROM Orders O
RIGHT JOIN Suppliers S ON O.ProductType = S.ProductType;

-- FULL JOIN
SELECT O.OrderID, O.ProductType AS Order_Product, S.ProductType AS Supplier_Product, S.SupplierName
FROM Orders O
LEFT JOIN Suppliers S ON O.ProductType = S.ProductType
UNION
SELECT O.OrderID, O.ProductType AS Order_Product, S.ProductType AS Supplier_Product, S.SupplierName
FROM Orders O
RIGHT JOIN Suppliers S ON O.ProductType = S.ProductType;

-- SELF JOIN
SELECT 
    A.OrderID AS Order_1, 
    B.OrderID AS Order_2, 
    A.City
FROM Orders A
INNER JOIN Orders B ON A.City = B.City
WHERE A.OrderID < B.OrderID;