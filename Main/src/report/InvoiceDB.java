/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

/**
 *
 * @author Admin
 */
public class InvoiceDB {
    private String dishName;
    private String dishhQuantity;
    private String dishPrice;
    private String dishAmount;

    public InvoiceDB(String dishName, String dishhQuantity, String dishPrice, String dishAmount) {
        this.dishName = dishName;
        this.dishhQuantity = dishhQuantity;
        this.dishPrice = dishPrice;
        this.dishAmount = dishAmount;
    }

    /**
     * @return the dishName
     */
    public String getDishName() {
        return dishName;
    }

    /**
     * @param dishName the dishName to set
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * @return the dishhQuantity
     */
    public String getDishhQuantity() {
        return dishhQuantity;
    }

    /**
     * @param dishhQuantity the dishhQuantity to set
     */
    public void setDishhQuantity(String dishhQuantity) {
        this.dishhQuantity = dishhQuantity;
    }

    /**
     * @return the dishPrice
     */
    public String getDishPrice() {
        return dishPrice;
    }

    /**
     * @param dishPrice the dishPrice to set
     */
    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    /**
     * @return the dishAmount
     */
    public String getDishAmount() {
        return dishAmount;
    }

    /**
     * @param dishAmount the dishAmount to set
     */
    public void setDishAmount(String dishAmount) {
        this.dishAmount = dishAmount;
    }

   

 

    
    
}
