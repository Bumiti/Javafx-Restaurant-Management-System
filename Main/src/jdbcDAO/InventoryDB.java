/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class InventoryDB {
    private int productID;
    private String productName;
    private Integer productQOH;
    private String productUnit;
    private int productPrice;
    private String productCatalogies;

    public InventoryDB(int productID, String productName, Integer productQOH, String productUnit, int productPrice, String productCatalogies) {
        this.productID = productID;
        this.productName = productName;
        this.productQOH = productQOH;
        this.productUnit = productUnit;
        this.productPrice = productPrice;
        this.productCatalogies = productCatalogies;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductQOH() {
        return productQOH;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductCatalogies() {
        return productCatalogies;
    }

    
    
    
}
