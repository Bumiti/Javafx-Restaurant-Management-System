use Project
go

--"D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Sunday Roast.jpg"
--"Hors d'oeuvres", x"Soup", x"Fish Dish", x"Meat Dish", x"Main Course", x"Salad", x"Dessert", x"Drink", "Other"
INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Sunday Roast',500,'Beef',1,'Meat Dish','Available','Beef roast is served with yourkshire pudding sauce and baked potatoes.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Sunday Roast.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Picanha',450,'Beef',1,'Meat Dish','Available','Picanha is a fresh cut of beef that is especially popular and highly prized in Brazil.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Picanha.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Steak au poivre',400,'Beef',1,'Meat Dish','Available','Steak au poivre is a French dish consisting of a beef steak that is coated in crushed peppercorns and fried.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Steak au poivre.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Barbecue',350,'Beef',1,'Meat Dish','Available','Modern American barbecue stems directly from barbacoa,'+ CHAR(13)+CHAR(10) +' the tradition of smoke-cooking meat which Caribbean natives'+ CHAR(13)+CHAR(10) +' were doing long before the colonists arrived.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Barbecue.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Greek Salad',700,'Salad',1,'Salad','Available','Greek salad, also known as village salad or horiatiki is the national dish of Greece,'+ CHAR(13)+CHAR(10) +' consisting of quartered tomatoes,'+ CHAR(13)+CHAR(10) +' sliced red onions, and chunky slices of cucumber.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Greek Salad.jpg', SINGLE_BLOB) image;
	go
	
INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Caprese Salad',650,'Salad',1,'Salad','Available','Caprese was originally made with the Re Umberto or Fiascone tomatoes,'+ CHAR(13)+CHAR(10) +' traditionally grown along the beautiful Amalfi coast,'+ CHAR(13)+CHAR(10) +' and treccia di Sorrento, a type of braided mozzarella cheese.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Caprese Salad.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Ratatouille',600,'Salad',1,'Salad','Available','This colorful Provençal vegetable ragout is traditionally made with simple,'+ CHAR(13)+CHAR(10) +' easily accessible ingredients: courgettes, eggplants,'+ CHAR(13)+CHAR(10) +'green and red peppers, tomatoes, onions, garlic, and parsley.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Ratatouille.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Coleslaw',550,'Salad',1,'Salad','Available','Originating from the Dutch term koolsla,'+ CHAR(13)+CHAR(10) +' meaning cabbage salad, coleslaw is nowadays a true American staple'+ CHAR(13)+CHAR(10) +' and a side dish that is often served with barbecued meat or fried chicken.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Coleshaw.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Gazpacho',800,'Tomato',1,'Soup','Available','A perfect remedy for a hot summer day called gazpacho is a cold soup consisting of crushed tomatoes,'+ CHAR(13)+CHAR(10) +' finely chopped cucumbers, onions, peppers, croutons, vinegar, and olive oil.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Gazpacho.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Bisque',750,'Shrimp',1,'Soup','Available','This thick, creamy, and rich puréed soup traditionally includes ingredients'+ CHAR(13)+CHAR(10) +' such as cream, seafood, cognac or wine, and a combination of spices.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Bisque 1.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Rosół',700,'Onion',1,'Soup','Available','It is typically lightly seasoned with salt,'+ CHAR(13)+CHAR(10) +' pepper, and bay leaves. When the dish is cooked, chopped parsley and thin noodles are added to the dish.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Rosół.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Soupe à l’oignon',650,'Onion',1,'Soup','Available','The broth is simple, made merely with caramelized onions and meat stock.'+ CHAR(13)+CHAR(10) +' However, the soup is distinguished by croûtes–pieces of crispy baked bread that are placed '+ CHAR(13)+CHAR(10) +'on top of the soup and are then generously covered with cheese.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Soupe à l’oignon.jpg', SINGLE_BLOB) image;
	go
	
INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Meunière',800,'Fish',1,'Fish Dish','Available','Meunière dishes are made with white flesh fish and are commonly finished off with the addition of lemon juice and parsley', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Meunière.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Brudet',750,'Fish',1,'Fish Dish','Available','The fish is primarily fried with olive oil, onions, and garlic,'+ CHAR(13)+CHAR(10) +' and later braised in a flavorful broth which usually employs '+ CHAR(13)+CHAR(10) +'a combination of seafood stock, tomato sauce, and white or red wine.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Brudet.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Cedar-Plank Salmon',700,'Fish',1,'Fish Dish','Available','Salmon is typically marinated in oil,'+ CHAR(13)+CHAR(10) +' seasonings, and fresh aromatic herbs such as rosemary, thyme, dill, oregano, parsley, juniper berries, or even fir needles.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Cedar-Plank Salmon.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Hal Paprikás',650,'Fish',1,'Fish Dish','Available','Fiš paprikaš (or hal paprikas in Hungary, with the addition of sour cream)'+ CHAR(13)+CHAR(10) +' is a traditional stew cooked in a big cauldron over an open fire.'+ CHAR(13)+CHAR(10) +' This spicy fish stew is traditionally made with a variety of freshwater fish ', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Hal Paprikás.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Soufflé',100,'Flour',1,'Dessert','Available','This delicate cake consists of two elements:'+ CHAR(13)+CHAR(10) +' a pudding or cream base, and a meringue made of egg whites.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Soufflé.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Tiramisù',100,'Flour',1,'Dessert','Available','Its name stems from the phrase tiramisù,'+ CHAR(13)+CHAR(10) +' an Italian expression which literally means pick me up,'+ CHAR(13)+CHAR(10) +' a reference to the uplifting effects of sugar, liquor, and coffee.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Tiramisù.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Schwarzwälder Kirschtorte',100,'Flour',1,'Dessert','Available','Black Forest cherry cake is a popular German dessert consisting of chocolate sponges'+ CHAR(13)+CHAR(10) +' that are coated in whipped cream and dotted with kirschwasser-infused cherries.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Schwarzwälder Kirschtorte.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Sachertorte',100,'Flour',1,'Dessert','Available','The original Sachertorte is the most famous Austrian cake.'+ CHAR(13)+CHAR(10) +' It is a classic, layered chocolate sponge cake that is thinly coated with high-quality apricot jam'+ CHAR(13)+CHAR(10) +' and topped with chocolate icing.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Sachertorte.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Panna cotta',100,'Stawberry',1,'Dessert','Available','Today it is considered a traditional Piedmontese dessert,'+ CHAR(13)+CHAR(10) +' and the original recipe calls for only whole cream, sugar, vanilla, and gelatin.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Panna cotta.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Mousse au chocolate',100,'Chocolate',1,'Dessert','Available','This classic French dessert is made with dark chocolate,'+ CHAR(13)+CHAR(10) +' eggs, butter, sugar, and salt. It is characterized by its foamy,'+ CHAR(13)+CHAR(10) +' bubbly texture and rich chocolate flavor.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Mousse au chocolat.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Crème brûlée',100,'Bake',1,'Dessert','Available','This traditional egg custard dessert consists of egg yolks, cream, sugar, and vanilla, with a hard, burnt, toffee crust', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Crème brûlée.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Champagne',100,'Wine',1,'Drink','Available','Made in France', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Champagne.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Bordeaux',100,'Wine',1,'Drink','Available','Made in France', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Bordeaux.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Rioja',100,'Wine',1,'Drink','Available','Made in Spain', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Rioja.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Vermouth',100,'Wine',1,'Drink','Available','Made in Italy', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Vermouth.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Malbec Argentina',100,'Wine',1,'Drink','Available','Made in Argentina', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Malbec Argentina.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Shiraz (Australia)',100,'Wine',1,'Drink','Available','Made in Autralia', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Shiraz (Australia).jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Margarita',100,'Wine',1,'Drink','Available','Margarita is made with a combination of Cointreau, lime juice, and tequila.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Margarita.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Sangria',100,'Strawberry',1,'Drink','Available','Sangria is a fruity Spanish cocktail made with red wine and chopped fruits such as pears,'+ CHAR(13)+CHAR(10) +' peaches, berries, apples, nectarines, or pineapple.'+ CHAR(13)+CHAR(10) +' The beverage is often combined with sugar, orange juice, sparkling water, and even brandy.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Sangria.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Mimosa',100,'Orange',1,'Drink','Available','Mimosa is a classic breakfast cocktail that transforms a simple morning meal into a decadent event.'+ CHAR(13)+CHAR(10) +' The cocktail is made with freshly squeezed orange juice and Champagne or any dry sparkling wine.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Mimosa.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Bloody Mary',100,'Wine',1,'Drink','Available','Bloody Mary is made with a combination of vodka, tomato juice,'+ CHAR(13)+CHAR(10) +' lemon juice, Worcestershire sauce, tabasco, celery salt, and pepper.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Bloody Mary.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Tequila Sunrise',100,'Orange',1,'Drink','Available','Tequila Sunrise is a classic cocktail that evokes a summer sunrise in a glass.'+ CHAR(13)+CHAR(10) +' It is made with three basic ingredients: tequila, orange juice, and grenadine syrup.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Tequila Sunrise.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Old-Fashioned',100,'Soda',1,'Drink','Available','Old-Fashioned is a very old cocktail made with bourbon or whiskey,'+ CHAR(13)+CHAR(10) +' fine sugar or a sugar cube, Angostura bitters, Maraschino cherries,'+ CHAR(13)+CHAR(10) +' orange slices, and a splash of club soda or water.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Old-Fashioned.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Bellini',100,'Peach',1,'Drink','Available','Bellini is a classic Italian cocktail made with a combination of Prosecco and white peach nectar or white peach purée.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Bellini.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Champús',100,'Pineapple',1,'Drink','Available','Champús is a traditional Colombian cold beverage that is also popular in Peru and Ecuador.'+ CHAR(13)+CHAR(10) +' It is made with dried maize, pineapple, mashed lulo (also known as naranjilla),'+ CHAR(13)+CHAR(10) +' panela, cloves, quince or guanábana, cinnamon, and orange tree leaves.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Champús.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Ponche de Maca',100,'Apple',1,'Drink','Available','Apart from maca roots, ponche de maca is prepared with a mixture of apple, maracuya, and carrot juice.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Ponche de Maca.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Qamar al-Din',100,'Water',1,'Drink','Available','Qamar al-din is a popular Syrian beverage made from dried apricot paste', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Qamar al-Din.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Jus de Bissap',100,'Flowers',1,'Drink','Available','It is made from dried flowers of Hibiscus sabdariffa '+ CHAR(13)+CHAR(10) +'that are combined with hot water and flavorings', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Jus de Bissap.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Bel sherbet',100,'Water',1,'Drink','Available','To make the juice, the pulp is first removed and then mashed and strained.'+ CHAR(13)+CHAR(10) +' The mixture is mixed with water, and it can be sweetened with sugar or jaggery.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Bel sherbet.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Boiled Maine Lobster',100,'Lobster',1,'Main Course','Available','Live lobsters are plopped into a large pot of boiling water seasoned'+ CHAR(13)+CHAR(10) +' with sea salt and cooked depending on the size of the lobster — the bigger the lobster, the longer the cooking time.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Boiled Maine Lobster.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Thanksgiving Dinner',100,'Chicken',1,'Main Course','Available','The Thanksgiving dinner usually includes seasonal dishes such as stuffed roasted turkey and side dishes such as mashed potatoes,'+ CHAR(13)+CHAR(10) +' a rich cranberry sauce, and pumpkin pie, among others.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Thanksgiving Dinner.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Fish and Chips',100,'Fish',1,'Hors d''oeuvres','Available','The fillets get dipped in a batter made from eggs, milk, '+ CHAR(13)+CHAR(10) +' and flour, and are then fried in oil, lard, or beef drippings along with the potatoes.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Fish and Chips.jpg', SINGLE_BLOB) image;
	go

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Morteruelo',100,'Pate',1,'Hors d''oeuvres','Available','Morteruelo is a Spanish pâté originating from Cuenca. '+ CHAR(13)+CHAR(10) +' Although there are numerous varieties of this pâté, in its basic form it typically consists of pork liver, '+ CHAR(13)+CHAR(10) +' various spices, and meats such as quail, partridge, and hare.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Morteruelo.jpg', SINGLE_BLOB) image;
	go	

INSERT INTO [dbo].[Menu] (brandID,dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription,dishImage)
SELECT 1,'Tagliatelle',100,'TAGLIATELLE',1,'Other','Available','Tagliatelle al ragù alla Bolognese is a traditional '+ CHAR(13)+CHAR(10) +' Italian dish originating from Bologna, consisting of tagliatelle pasta '+ CHAR(13)+CHAR(10) +' and a rich ragù made with beef (and sometimes pork) and tomatoes as key ingredients.', 
	BulkColumn FROM OPENROWSET(BULK N'D:\Aptech\HK2\3. JP-2\3. JP-2\ProjectII\GithubPro\Javafx-Restaurant-Management-System\Main\src\image\Menu\Tagliatelle al ragù alla Bolognese.jpg', SINGLE_BLOB) image;
	go	

select * from Menu
go

