/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcDAO;

/**
 *
 * @author Admin
 */
public class LogDB {

    private int loggerID;
    private String loggerDateTime;
    private String loggerMethod;
    private String loggerLevel;
    private String loggerMessage;

    public LogDB(int loggerID, String loggerDateTime, String loggerMethod, String loggerLevel, String loggerMessage) {
        this.loggerID = loggerID;
        this.loggerDateTime = loggerDateTime;
        this.loggerMethod = loggerMethod;
        this.loggerLevel = loggerLevel;
        this.loggerMessage = loggerMessage;
    }

    public int getLoggerID() {
        return loggerID;
    }

    public String getLoggerDateTime() {
        return loggerDateTime;
    }

    public String getLoggerMethod() {
        return loggerMethod;
    }

    public String getLoggerLevel() {
        return loggerLevel;
    }

    public String getLoggerMessage() {
        return loggerMessage;
    }
    
    
}
