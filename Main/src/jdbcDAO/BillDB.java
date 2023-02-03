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
    private int billDishAmount;

    public BillDB(String billDishName, int billDishPrice, int billDishQuantity, int billDishAmount) {
        this.billDishName = billDishName;
        this.billDishPrice = billDishPrice;
        this.billDishQuantity = billDishQuantity;
        this.billDishAmount = billDishAmount;
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

    public int getBillDishAmount() {
        return billDishAmount;
    }
            
    
    
    
}
