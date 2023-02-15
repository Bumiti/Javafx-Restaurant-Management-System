/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import oracle.sql.TIMESTAMP;

/**
 *
 * @author Admin
 */
public class StaffDB {

    private int staffID;
    private String staffName;
    private LocalDate  staffDOB;
    private String staffAddress;
    private String staffPossition;
    private String staffPhone;
    private String staffMail;
    private int staffSalary;
    private String staffUserName;

    public StaffDB(int staffID, String staffName, LocalDate staffDOB, String staffAddress, String staffPossition, String staffPhone, String staffMail, int staffSalary, String staffUserName) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffDOB = staffDOB;
        this.staffAddress = staffAddress;
        this.staffPossition = staffPossition;
        this.staffPhone = staffPhone;
        this.staffMail = staffMail;
        this.staffSalary = staffSalary;
        this.staffUserName = staffUserName;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public LocalDate getStaffDOB() {
        return staffDOB;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public String getStaffPossition() {
        return staffPossition;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public String getStaffMail() {
        return staffMail;
    }

    public int getStaffSalary() {
        return staffSalary;
    }

    public String getStaffUserName() {
        return staffUserName;
    }
    
    

    

    
    

}
