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
public class EOD {
    private final int eodID;
    private final LocalDate eodTime;
    private final int eodThu;
    private final int eodChi;

    public EOD(int eodID, LocalDate eodTime, int eodThu, int eodChi) {
        this.eodID = eodID;
        this.eodTime = eodTime;
        this.eodThu = eodThu;
        this.eodChi = eodChi;
    }

    public int getEodID() {
        return eodID;
    }

    public LocalDate getEodTime() {
        return eodTime;
    }

    public int getEodThu() {
        return eodThu;
    }

    public int getEodChi() {
        return eodChi;
    }
    
}
