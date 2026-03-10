USE Deneme;

CREATE TABLE Suppliers (
    SupplierID INT PRIMARY KEY,
    SupplierName VARCHAR(100),
    ProductType VARCHAR(50),
    ContactCity VARCHAR(50)
);

INSERT INTO Suppliers (SupplierID, SupplierName, ProductType, ContactCity) VALUES
(101, 'Global Tech Inc.', 'Electronics', 'San Francisco'),
(102, 'Fashion Hub', 'Clothing', 'New York'),
(103, 'Home & Comfort', 'Home Decor', 'Chicago'),
(104, 'Elite Sports', 'Sports', 'Miami'),
(105, 'Mega Toy Corp', 'Toys', 'Dallas'),
(106, 'Wood Works', 'Furniture', 'Seattle');