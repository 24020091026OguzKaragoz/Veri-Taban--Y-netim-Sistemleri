--Checks if database is already craeted on system. 
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'Deneme')
BEGIN
	CREATE DATABASE Deneme;
END
GO

--makes sure using Deneme databse
USE Deneme;

--creates table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Ogrenciler]') AND type in (N'U'))
BEGIN
	CREATE TABLE Ogrenciler (
		ID INT PRIMARY KEY,
		Isim NVARCHAR(50),
		Notu FLOAT
	);
END
GO

TRUNCATE TABLE Ogrenciler;

--inserts values to the Ogrenciler table
INSERT INTO Ogrenciler (ID, Isim, Notu) VALUES
	(1, 'Oğuz', 100),
	(2,'Ece', 95),
	(3, 'Halime', 24),
	(4, 'Yavuz', 98);
GO
--brings all entries from Ogrenciler table.
SELECT * FROM Ogrenciler;