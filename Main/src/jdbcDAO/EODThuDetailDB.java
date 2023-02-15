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
public class EODThuDetailDB {
    private int eodThuDetailID;
    private LocalDate eodThuDetailDate;
    private String eodThuDetailCatalog;
    private int eodThuDetailPrice;
    private String eodThuDetailNote;

    public EODThuDetailDB(int eodThuDetailID, LocalDate eodThuDetailDate, String eodThuDetailCatalog, int eodThuDetailPrice, String eodThuDetailNote) {
        this.eodThuDetailID = eodThuDetailID;
        this.eodThuDetailDate = eodThuDetailDate;
        this.eodThuDetailCatalog = eodThuDetailCatalog;
        this.eodThuDetailPrice = eodThuDetailPrice;
        this.eodThuDetailNote = eodThuDetailNote;
    }

    public int getEodThuDetailID() {
        return eodThuDetailID;
    }

    public LocalDate getEodThuDetailDate() {
        return eodThuDetailDate;
    }

    public String getEodThuDetailCatalog() {
        return eodThuDetailCatalog;
    }

    public int getEodThuDetailPrice() {
        return eodThuDetailPrice;
    }

    public String getEodThuDetailNote() {
        return eodThuDetailNote;
    }

    

    public void setEodThuDetailID(int eodThuDetailID) {
        this.eodThuDetailID = eodThuDetailID;
    }

    public void setEodThuDetailDate(LocalDate eodThuDetailDate) {
        this.eodThuDetailDate = eodThuDetailDate;
    }

    public void setEodThuDetailCatalog(String eodThuDetailCatalog) {
        this.eodThuDetailCatalog = eodThuDetailCatalog;
    }

    public void setEodThuDetailPrice(int eodThuDetailPrice) {
        this.eodThuDetailPrice = eodThuDetailPrice;
    }

    public void setEodThuDetailNote(String eodThuDetailNote) {
        this.eodThuDetailNote = eodThuDetailNote;
    }

    
    
    
    
}
