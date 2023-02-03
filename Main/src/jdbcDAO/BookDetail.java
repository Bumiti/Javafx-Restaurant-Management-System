/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class BookDetail {
    private String bookDishName;
    private int bookDishQuantity;
    private int bookDishPrice;

    public BookDetail(String bookDishName, int bookDishQuantity, int bookDishPrice) {
        this.bookDishName = bookDishName;
        this.bookDishQuantity = bookDishQuantity;
        this.bookDishPrice = bookDishPrice;
    }

    public String getBookDishName() {
        return bookDishName;
    }

    public int getBookDishQuantity() {
        return bookDishQuantity;
    }

    public int getBookDishPrice() {
        return bookDishPrice;
    }
    
    
}
