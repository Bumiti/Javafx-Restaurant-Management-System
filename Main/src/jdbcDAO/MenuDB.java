/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class MenuDB {
    private int dishID;
    private String dishName;
    private int dishPrice;
    private String dishIngredient;
    private int dishConsume;
    private String dishCatalogies;
    private String dishStatus;
    private String dishDescription;

    public MenuDB(int dishID, String dishName, int dishPrice, String dishIngredient, int dishConsume, String dishCatalogies, String dishStatus, String dishDescription) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishIngredient = dishIngredient;
        this.dishConsume = dishConsume;
        this.dishCatalogies = dishCatalogies;
        this.dishStatus = dishStatus;
        this.dishDescription = dishDescription;
    }

    public int getDishID() {
        return dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public String getDishIngredient() {
        return dishIngredient;
    }

    public int getDishConsume() {
        return dishConsume;
    }

    public String getDishCatalogies() {
        return dishCatalogies;
    }

    public String getDishStatus() {
        return dishStatus;
    }

    public String getDishDescription() {
        return dishDescription;
    }
    
    

    
    
}
