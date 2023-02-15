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
public class EODChiDetailDB {
    private int eodChiDetailID;
    private LocalDate eodChiDetailDate;
    private String eodChiDetailCatalog;
    private int eodChiDetailPrice;
    private String eodChiDetailNote;

    public EODChiDetailDB(int eodChiDetailID, LocalDate eodChiDetailDate, String eodChiDetailCatalog, int eodChiDetailPrice, String eodChiDetailNote) {
        this.eodChiDetailID = eodChiDetailID;
        this.eodChiDetailDate = eodChiDetailDate;
        this.eodChiDetailCatalog = eodChiDetailCatalog;
        this.eodChiDetailPrice = eodChiDetailPrice;
        this.eodChiDetailNote = eodChiDetailNote;
    }

    public int getEodChiDetailID() {
        return eodChiDetailID;
    }

    public LocalDate getEodChiDetailDate() {
        return eodChiDetailDate;
    }

    public String getEodChiDetailCatalog() {
        return eodChiDetailCatalog;
    }

    public int getEodChiDetailPrice() {
        return eodChiDetailPrice;
    }

    public String getEodChiDetailNote() {
        return eodChiDetailNote;
    }

   
    }

    
    
    

