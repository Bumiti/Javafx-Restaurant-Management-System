/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

import javafx.scene.control.cell.CheckBoxTableCell;


/**
 *
 * @author Admin
 */
public class OrderList {
    private int orderID;
    private String orderTime;
    private String orderName;
    private int orderPrice;
    private int orderQuantity;
    private String orderCatalogies;
    private String orderNote;

    public OrderList(int orderID, String orderTime, String orderName, int orderPrice, int orderQuantity, String orderCatalogies, String orderNote) {
        this.orderID = orderID;
        this.orderTime = orderTime;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
        this.orderCatalogies = orderCatalogies;
        this.orderNote = orderNote;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderCatalogies() {
        return orderCatalogies;
    }

    public String getOrderNote() {
        return orderNote;
    }

    
                        
}
