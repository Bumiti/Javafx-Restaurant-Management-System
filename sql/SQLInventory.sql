use Project
go

--"D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Beef.png"

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Beef',10,'Kg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Beef.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Butter',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Butter.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Cabbage',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Cabbage.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Chicken',10,'Kg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Chicken.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Chocolate',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Chocolate.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Egg',10,'Egg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Egg.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Fish',10,'Kg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Fish.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Flour',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Flour.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Lemon',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Lemon.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Lime Juice',10,'ml',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\LimeJuice.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Lobster',10,'Pound',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Lobster.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Onion',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Onion.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Peach',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Peach.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Pork',10,'Kg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Pork.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Salmon',10,'Kg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Salmon.png', SINGLE_BLOB) image;
	go


INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Shrimps',10,'Kg',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Shrimps.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Strawberry',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Strawberry.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Tomato',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Tomato.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Wine',10,'Bottle',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Wine.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Salad',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Cabbage.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Orange',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Orange.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Soda',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Soda.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Pineapple',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Pineapple.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Apple',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Apple.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Water',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Water.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Flowers',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Flower.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Pate',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\Pate.png', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'TAGLIATELLE',10,'g',20,'Ingredient', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Icon\TAGLIATELLE.png', SINGLE_BLOB) image;
	go
	-- Tool
INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Plate',10,'Plate',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Plate.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Knife',10,'Knives',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Knife.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Bowl',10,'Bowls',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Bowl.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Glass',10,'Glasses',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Glass.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Ladle',10,'Ladles',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Ladle.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Napkin',10,'Napkins',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Napkin.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Spoon',10,'Spoons',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Spoon.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Table Cloth',10,'Tablecloths',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Table Cloth.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Tongs',10,'Tongs',20,'Tool', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Tongs.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Inventory] (brandID,productName,productQOH,productUnit,productPrice,productCatalogies,productImage)
SELECT 1,'Fork',10,'Forks',20,'Tool',
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Tool\Fork.jpg', SINGLE_BLOB) image;
	go

select * from Inventory
go

