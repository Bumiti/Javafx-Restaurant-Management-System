/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class OrderListMini {
    private String orderMiniName;
    private int orderMiniPrice;
    private int orderMiniQuantity;

    public OrderListMini(String orderMiniName, int orderMiniPrice, int orderMiniQuantity) {
        this.orderMiniName = orderMiniName;
        this.orderMiniPrice = orderMiniPrice;
        this.orderMiniQuantity = orderMiniQuantity;
    }

    public String getOrderMiniName() {
        return orderMiniName;
    }

    public int getOrderMiniPrice() {
        return orderMiniPrice;
    }

    public int getOrderMiniQuantity() {
        return orderMiniQuantity;
    }

   
   

   
    
    
}
