USE Deneme;

-- UNION
SELECT City FROM Orders
UNION
SELECT ProductType FROM Suppliers;

-- UNION ALL
SELECT City FROM Orders
UNION ALL
SELECT ProductType FROM Suppliers;

-- GROUP
SELECT City, OrderId, State
FROM Orders
GROUP BY State;

-- HAVING
SELECT City, OrderID, State
FROM Orders
GROUP BY City
HAVING City LIKE 's%';

-- EXISTS
SELECT City FROM Orders
WHERE EXISTS (
	SELECT ProductType
    FROM Orders
    WHERE ProductType = 'Boofdsg'
);

-- ANY
SELECT OrderID, ProductType, City, Amount
FROM Orders
WHERE Amount > ANY (
    SELECT Amount 
    FROM Orders 
    WHERE State = 'TX'
);

-- ALL
SELECT OrderID, ProductType, Amount
FROM Orders
WHERE Amount > ALL (
    SELECT Amount 
    FROM Orders 
    WHERE ProductType = 'Clothing'
);

-- CASE
SELECT OrderID, Amount,
CASE
	WHEN Amount < 500 THEN 'AZ'
    WHEN Amount > 500 THEN 'ÇOK'
    ELSE 'BELİRSİZ'
END AS Segment
FROM Orders;

-- NULL
SELECT 
    OrderID, 
    IFNULL(Amount, 0.00) AS TemizlenmisMiktar
FROM Orders;