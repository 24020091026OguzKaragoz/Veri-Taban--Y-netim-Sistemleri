USE Deneme;

-- SELECT INTO Bu kodun MYSQL karsiligi asagidaki gibidir
-- CREATE TABLE Orders_Backup AS 
-- SELECT * FROM Orders;

SELECT * FROM Orders_Backup;

INSERT INTO Archive_Orders SELECT OrderID, Category, Price FROM Orders WHERE OrderDate < '2025-01-01';