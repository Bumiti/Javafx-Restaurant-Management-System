/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class OrderCusMini {
    private String orderCusName;
    private int orderCusPrice;
    private int orderCusQuantity;

    public OrderCusMini(String orderCusName, int orderCusPrice, int orderCusQuantity) {
        this.orderCusName = orderCusName;
        this.orderCusPrice = orderCusPrice;
        this.orderCusQuantity = orderCusQuantity;
    }

    public String getOrderCusName() {
        return orderCusName;
    }

    public int getOrderCusPrice() {
        return orderCusPrice;
    }

    public int getOrderCusQuantity() {
        return orderCusQuantity;
    }
    
    
}
