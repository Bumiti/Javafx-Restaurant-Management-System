/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class PaymentDB {
    private int chiID;
    private String chiDate;
    private String chiCatalog;
    private int chiPrice;
    private String chiNote;

    public PaymentDB(int chiID, String chiDate, String chiCatalog, int chiPrice, String chiNote) {
        this.chiID = chiID;
        this.chiDate = chiDate;
        this.chiCatalog = chiCatalog;
        this.chiPrice = chiPrice;
        this.chiNote = chiNote;
    }

    public int getChiID() {
        return chiID;
    }

    public String getChiDate() {
        return chiDate;
    }

    public String getChiCatalog() {
        return chiCatalog;
    }

    public int getChiPrice() {
        return chiPrice;
    }

    public String getChiNote() {
        return chiNote;
    }
    
    
}
