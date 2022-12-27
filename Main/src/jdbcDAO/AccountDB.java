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
public class AccountDB {
    private int accountID;
    private String accountUserName;
    private String accountPassWord;
    private String accountRole;
    private String accountFullname;

    public AccountDB(int accountID, String accountUserName, String accountPassWord, String accountRole, String accountFullname) {
        this.accountID = accountID;
        this.accountUserName = accountUserName;
        this.accountPassWord = accountPassWord;
        this.accountRole = accountRole;
        this.accountFullname = accountFullname;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public String getAccountPassWord() {
        return accountPassWord;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public String getAccountFullname() {
        return accountFullname;
    }

    

    
    

    

    

    
   
    
}
