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
public class CustomerDB {
    private int customerID;
    private String customerName;
    private LocalDate customerDOB;
    private String customerAddress;
    private String customerPhone;
    private String customerMail;
    private String customerGender;
    private String customerUserName;

    public CustomerDB(int customerID, String customerName, LocalDate customerDOB, String customerAddress, String customerPhone, String customerMail, String customerGender, String customerUserName) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerDOB = customerDOB;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerMail = customerMail;
        this.customerGender = customerGender;
        this.customerUserName = customerUserName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCustomerDOB() {
        return customerDOB;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }
    
    

    

    
    
    
}
