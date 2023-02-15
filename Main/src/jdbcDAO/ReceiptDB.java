/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class ReceiptDB {
    private int thuID;
    private LocalDate thuDate;
    private String thuCatalog;
    private int thuPrice;
    private String thuNote;

    public ReceiptDB(int thuID, LocalDate thuDate, String thuCatalog, int thuPrice, String thuNote) {
        this.thuID = thuID;
        this.thuDate = thuDate;
        this.thuCatalog = thuCatalog;
        this.thuPrice = thuPrice;
        this.thuNote = thuNote;
    }

    public int getThuID() {
        return thuID;
    }

    public LocalDate getThuDate() {
        return thuDate;
    }

    public String getThuCatalog() {
        return thuCatalog;
    }

    public int getThuPrice() {
        return thuPrice;
    }

    public String getThuNote() {
        return thuNote;
    }

    
    
    
}
