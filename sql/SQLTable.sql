create database Project
go

use Project
go

create table Restaurant(
  brandID int primary key
);
go

insert into Restaurant values(1);

create table Brand(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  brandAddress varchar(60)
);
go

create table Inventory(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  productID int identity(1,1) primary key,
  productName varchar(50)  ,
  productQOH int,
  productUnit varchar(20) not null,
  productPrice int ,
  productCatalogies varchar(10),
  productImage image,
);
go

create table Staff(
  brandID int  FOREIGN KEY REFERENCES Restaurant(brandID),
  staffID int primary key identity(1,1),
  staffName varchar(30) NOT NULL UNIQUE,
  staffDOB date,
  staffAddress varchar(60),
  staffPossition varchar(10) not null,
  staffPhone int,
  staffMail varchar(30),
  staffSalary int,
  staffImage image
);
go

create table Menu(
  brandID int  FOREIGN KEY REFERENCES Restaurant(brandID),
  dishID int primary key identity(1,1),
  dishName varchar(50),
  dishPrice int,
  dishIngredient varchar(50),
  dishConsume int,
  dishCatalogies varchar(30),
  dishStatus varchar(20),
  dishDescription varchar(255),
  dishImage image
);
go

create table Thu(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  thuID int primary key identity(1,1),
  thuDate varchar(30),
  thuCatalog varchar(50),
  thuPrice int,
  thuNote varchar(255),
);
go

create table Chi(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  chiID int primary key identity(1,1),
  chiDate varchar(30),
  chiCatalog varchar(50),
  chiPrice int,
  chiNote varchar(255)
);
go

create table Account(
  accountID int identity(1,1) primary key,
  accountUserName varchar(60),
  accountPassWord varchar(60),
  accountRole varchar(10),
  accountFullname varchar(60)
);
go

create table Customer(
  customerID int primary key identity(1,1),
  customerName varchar(60),
  customerDOB date,
  customerAddress varchar(60),
  customerPhone int,
  customerMail varchar(50),
  customerGender varchar(6),
  customerImage image
);
go

create table Book(
  brandID int FOREIGN KEY REFERENCES Restaurant(brandID),
  bookID int,
  bookDate date,
  bookTime varchar(10) ,
  bookCustomerName varchar(50),
  bookCatalogies varchar(50),
  bookNote nvarchar(255),
  bookDishName varchar(60),
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
  codeValue varchar(10),
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