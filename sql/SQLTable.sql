create database Project
go

use Project
go

create table Restaurant(
  brandID int primary key,
  brandAddress nvarchar(255)
);
go

insert into Restaurant values(1,'590, Cach Mang Thang Tam');

create table Inventory(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  productID int identity(1,1) primary key,
  productName varchar(255)  ,
  productQOH int,
  productUnit varchar(255) not null,
  productPrice int ,
  productCatalogies varchar(10),
  productImage image,
);
go

create table Staff(
  brandID int  FOREIGN KEY REFERENCES Restaurant(brandID),
  staffID int primary key identity(1,1),
  staffName nvarchar(255) NOT NULL UNIQUE,
  staffDOB date,
  staffAddress nvarchar(255),
  staffPossition varchar(10) not null,
  staffPhone varchar(12),
  staffMail varchar(255),
  staffSalary int,
  staffUserName varchar(255),
  staffImage image
);
go

create table Menu(
  brandID int  FOREIGN KEY REFERENCES Restaurant(brandID),
  dishID int primary key identity(1,1),
  dishName varchar(255),
  dishPrice int,
  dishIngredient varchar(255),
  dishConsume int,
  dishCatalogies varchar(30),
  dishStatus varchar(11),
  dishDescription varchar(255),
  dishImage image
);
go

create table Thu(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  thuID int primary key identity(1,1),
  thuDate date,
  thuCatalog varchar(50),
  thuPrice int,
  thuNote nvarchar(255),
);
go

create table Chi(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  chiID int primary key identity(1,1),
  chiDate date,
  chiCatalog varchar(50),
  chiPrice int,
  chiNote nvarchar(255)
);
go

create table EOD(
	brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
	eodID int identity(1,1) primary key,
	eodTime date,
	eodThu int,
	eodChi int
);
go

create table EODDetailThu(
	brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
	eodDetailThuID int,
	eodDetailThuTime date,
	eodDetailThuCatalog varchar (30),
	eodDetailThuPrice int,
	eodDetailThuNote nvarchar(255)
);
go

create table EODDetailChi(
	brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
	eodDetailChiID int,
	eodDetailChiTime date,
	eodDetailChiCatalog varchar (30),
	eodDetailChiPrice int,
	eodDetailChiNote nvarchar(255)
);
go

create table Account(
  accountID int identity(1,1) primary key,
  accountUserName varchar(255),
  accountPassWord varchar(255),
  accountRole varchar(10)
);
go

create table Customer(
  customerID int primary key identity(1,1),
  customerName nvarchar(255),
  customerDOB date,
  customerAddress nvarchar(255),
  customerPhone varchar(12),
  customerMail varchar(255),
  customerGender varchar(6),
  customerUserName varchar(255),
  customerImage image
);
go

create table Book(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  bookID int,
  bookDate date,
  bookTime varchar(10) ,
  bookCustomerName nvarchar(255),
  bookCatalogies varchar(50),
  bookNote nvarchar(255),
  bookDishName varchar(255),
  bookDishQuantity int,
  bookDishPrice int 
);
go

create table Logger
(
	id int identity(1,1) primary key,
	[datetime] datetime,
	method_name varchar(255),
	[level] varchar(10),
	[message] varchar(500)
);
go

create table codeDiscount(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  codeID int primary key identity(1,1),
  codeValue varchar(255),
  codeQuantity int,
  discountPercent int
);
go

create table [Order](
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  orderID int,
  orderTime datetime,
  dishName varchar(255),
  dishPrice int,
  dishQuantity int,
  dishCatalogies varchar(30),
  orderNote varchar(225)
);
go

create table [OrderMini](
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  dishName varchar(255),
  dishPrice int,
  dishQuantity int
);
go

create table [CusOrderMini](
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  dishName varchar(255),
  dishPrice int,
  dishQuantity int
);
go


