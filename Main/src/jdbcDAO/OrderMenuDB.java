/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class OrderMenuDB {
    private String menuDishName;
    private int menuDishPrice;
    private int menuDishAvailabe;
    private String menuDishDescription;

    public OrderMenuDB(String menuDishName, int menuDishPrice, int menuDishAvailabe, String menuDishDescription) {
        this.menuDishName = menuDishName;
        this.menuDishPrice = menuDishPrice;
        this.menuDishAvailabe = menuDishAvailabe;
        this.menuDishDescription = menuDishDescription;
    }

    public String getMenuDishName() {
        return menuDishName;
    }

    public int getMenuDishPrice() {
        return menuDishPrice;
    }

    public int getMenuDishAvailabe() {
        return menuDishAvailabe;
    }

    public String getMenuDishDescription() {
        return menuDishDescription;
    }
    
    
}
