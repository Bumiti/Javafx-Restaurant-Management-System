/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mondrian.olap.DriverManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Admin
 */
public class PrintReport extends JFrame {

    public static Connection getConnect() {
        Connection cn = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433;database=Project";
        String uid = "sa";
        String pwd = "123";
        try {
            //1. dang ky driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2 tao ket noi den co so du lieu
            cn = java.sql.DriverManager.getConnection(url, uid, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection con = getConnect();

    public PrintReport() throws HeadlessException {
    }

    public void showInvoice() {
        //D:\\Aptech\\HK2\\3. JP-2\\3. JP-2\\ProjectII\\GithubPro\\Javafx-Restaurant-Management-System\\Main\\src\\report\\Invoice3.jrxml
        try {
            JasperDesign jasperDesign = JRXmlLoader.load("D:\\Aptech\\HK2\\3. JP-2\\3. JP-2\\ProjectII\\GithubPro\\Javafx-Restaurant-Management-System\\Main\\src\\report\\Invoice3.jrxml");
            String query = "select dishName,dishPrice,dishQuantity, dishPrice*dishQuantity  as dishAmount from [Order]";
            JRDesignQuery jrquery = new JRDesignQuery();
            jrquery.setText(query);
            jasperDesign.setQuery(jrquery);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint JasperPrint = JasperFillManager.fillReport( jasperReport, null, con);
            JRViewer viewer = new JRViewer(JasperPrint);

            /*JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\RAM ALAPURE\\Documents\\NetBeansProjects\\User Info App\\src\\org\\ramalapure\\userinfoapp\\newReport.jrxml");
             JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
             JRViewer viewer = new JRViewer(JasperPrint);*/
            viewer.setOpaque(true);
            viewer.setVisible(true);

            this.add(viewer);
            this.setSize(900, 500); // JFrame size
            this.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

}
