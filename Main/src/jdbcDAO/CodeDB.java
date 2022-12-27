/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class CodeDB {
    private final int codeID;
    private final String codeValue;
    private final int codeQuantity;
    private final int discountPercent;

    public CodeDB(int codeID, String codeValue, int codeQuantity, int discountPercent) {
        this.codeID = codeID;
        this.codeValue = codeValue;
        this.codeQuantity = codeQuantity;
        this.discountPercent = discountPercent;
    }

    public int getCodeID() {
        return codeID;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public int getCodeQuantity() {
        return codeQuantity;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
    
    

    
}
