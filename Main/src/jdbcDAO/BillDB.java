/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class BillDB {
    private String billDishName;
    private int billDishPrice;
    private int billDishQuantity;

    public BillDB(String billDishName, int billDishPrice, int billDishQuantity) {
        this.billDishName = billDishName;
        this.billDishPrice = billDishPrice;
        this.billDishQuantity = billDishQuantity;
    }

    public String getBillDishName() {
        return billDishName;
    }

    public int getBillDishPrice() {
        return billDishPrice;
    }

    public int getBillDishQuantity() {
        return billDishQuantity;
    }
    
    
}
