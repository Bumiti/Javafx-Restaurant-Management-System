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
public class BookInfo {
    private int bookID;
    private LocalDate bookDate;
    private String bookTime;
    private String bookCustomerName;
    private String bookCatalogies;
    private String bookNote;

    public BookInfo(int bookID, LocalDate bookDate, String bookTime, String bookCustomerName, String bookCatalogies, String bookNote) {
        this.bookID = bookID;
        this.bookDate = bookDate;
        this.bookTime = bookTime;
        this.bookCustomerName = bookCustomerName;
        this.bookCatalogies = bookCatalogies;
        this.bookNote = bookNote;
    }

    public int getBookID() {
        return bookID;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public String getBookTime() {
        return bookTime;
    }

    public String getBookCustomerName() {
        return bookCustomerName;
    }

    public String getBookCatalogies() {
        return bookCatalogies;
    }

    public String getBookNote() {
        return bookNote;
    }
    
    
}
