use Project
go
--"D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\CusImage\Dan.jpg"
INSERT INTO [dbo].[Customer] (customerName,customerDOB,customerAddress,customerPhone,customerMail,customerGender,customerUserName,customerImage)
SELECT 'Dan','2000-02-28','BT',123456780,'dan@gmail.com','Female','dan' 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\CusImage\Dan.jfif', SINGLE_BLOB) image;
go


select * from [Customer]
go