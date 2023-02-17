/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import report.InvoiceDB;
import static FXMLFile.LoginController.getConnect;
import static FXMLFile.SignUpController.getConnect;
import com.gluonhq.charm.glisten.control.TextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Timestamp;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import jdbcDAO.*;
import main.Main;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.PropertyConfigurator;
import report.*;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class StaffSceneController implements Initializable {

    @FXML
    private Label lbUser;

    /**
     * Initializes the controller class.
     */
    @FXML
    public Tab tabLog;
    @FXML
    private TableView<LogDB> tvLogger;
    @FXML
    private TableColumn<LogDB, Integer> colLoggerID;
    @FXML
    private TableColumn<LogDB, String> colLoggerDateTime;
    @FXML
    private TableColumn<LogDB, String> colLoggerMethod;
    @FXML
    private TableColumn<LogDB, String> colLoggerLevel;
    @FXML
    private TableColumn<LogDB, String> colLoggerMessage;
    @FXML
    private BorderPane bpStaff;
    @FXML
    private BorderPane bpOrder;
    @FXML
    private ImageView imgStaffImage;
    @FXML
    private javafx.scene.control.TextField tfStaffName;
    @FXML
    private DatePicker tfStaffDOB;
    @FXML
    private javafx.scene.control.TextField tfStaffAddress;
    @FXML
    private ComboBox<String> cbStaffPossition;
    @FXML
    private javafx.scene.control.TextField tfStaffSalary;
    @FXML
    public Button btnStaffCreate;
    @FXML
    private TableView<StaffDB> tvStaff;
    @FXML
    private TableColumn<StaffDB, Integer> colStaffID;
    @FXML
    private TableColumn<StaffDB, String> colStaffName;
    @FXML
    private TableColumn<StaffDB, Date> colStaffDOB;
    @FXML
    private TableColumn<StaffDB, String> colStaffAddress;
    @FXML
    private TableColumn<StaffDB, String> colStaffPossition;
    @FXML
    private TableColumn<StaffDB, Integer> colStaffSalary;
    private Button btnBrowser;
    @FXML
    public Button btnStaffClear;
    private FileChooser fileChooser;
    private File file;
    private Stage stage;
    private final Desktop deskTop = Desktop.getDesktop();
    private Image image;
    private FileInputStream fis;
    private FileOutputStream fos;
    private Button btnUpdateStaff;
    private Label lbID;
    @FXML
    private TableView<AccountDB> tvAccount;
    @FXML
    private TableColumn<AccountDB, Integer> colAccountID;
    @FXML
    private TableColumn<AccountDB, String> colAccountUsername;
    @FXML
    private TableColumn<AccountDB, String> colAccountPassword;
    @FXML
    private TableColumn<AccountDB, String> colAccountRole;
    @FXML
    private Label lbAccountID;
    @FXML
    private javafx.scene.control.TextField tfAccountUsername;
    @FXML
    private javafx.scene.control.TextField tfAccountPassword;
    @FXML
    private ComboBox<String> cbAccountRole;
    @FXML
    private Label lbStaffID;
    @FXML
    public Button btnStaffUpdate;
    @FXML
    public Button btnStaffDelete;
    @FXML
    private TableView<CodeDB> tvCodeDiscount;
    @FXML
    private TableColumn<CodeDB, Integer> colCodeID;
    @FXML
    private TableColumn<CodeDB, String> colCodeValue;
    @FXML
    private TableColumn<CodeDB, Integer> colCodeQuantity;
    @FXML
    private Label lbCodeID;
    @FXML
    private javafx.scene.control.TextField tfCodeValue;
    @FXML
    private javafx.scene.control.TextField tfCodeQuantity;
    @FXML
    public Button btnCodeClear;
    @FXML
    public Button btnCodeCreate;
    @FXML
    public Button btnCodeUpdate;
    @FXML
    public Button btnCodeDelete;
    @FXML
    private TableView<InventoryDB> tvInventory;
    @FXML
    private TableColumn<InventoryDB, Integer> colInventoryID;
    @FXML
    private TableColumn<InventoryDB, String> colInventoryName;
    @FXML
    private TableColumn<InventoryDB, Integer> colInventoryQOH;
    @FXML
    private TableColumn<InventoryDB, String> colInventoryUnit;
    @FXML
    private TableColumn<InventoryDB, Integer> colInventoryPrice;
    @FXML
    private TableColumn<InventoryDB, String> colInventoryCatalogies;
    @FXML
    private Label lbInventoryID;
    @FXML
    private javafx.scene.control.TextField tfInventoryName;
    @FXML
    private ComboBox<String> cbInventoryCatalogies;
    @FXML
    public Button btnInventoryBrowser;
    @FXML
    public Button btnInventoryClear;
    @FXML
    public Button btnInventoryCreate;
    @FXML
    public Button btnInventoryUpdate;
    @FXML
    public Button btnInventoryDelete;
    @FXML
    public Button btnStaffBrowser;
    @FXML
    private ImageView imgInventory;
    @FXML
    private Button btnAccountCreate;
    @FXML
    private Button btnAccountUpdate;
    @FXML
    public Button btnAccountDelete;
    @FXML
    private Button btnAccountClear;
    @FXML
    private TableView<MenuDB> tvMenu;
    @FXML
    private TableColumn<MenuDB, Integer> colDishID;
    @FXML
    private TableColumn<MenuDB, String> colDishName;
    @FXML
    private TableColumn<MenuDB, Integer> colDishPrice;
    @FXML
    private TableColumn<MenuDB, String> colDishIngredient;
    @FXML
    private TableColumn<MenuDB, Integer> colDishConsume;
    @FXML
    private TableColumn<MenuDB, String> colDishCatalogies;
    @FXML
    private TableColumn<MenuDB, String> colDishStatus;
    @FXML
    private ImageView imgDish;
    @FXML
    private Label lbDishID;
    @FXML
    private javafx.scene.control.TextField tfDishName;
    @FXML
    private javafx.scene.control.TextField tfDishPrice;
    @FXML
    private ComboBox<String> cbDishIngredient;
    @FXML
    private javafx.scene.control.TextField tfDishConsume;
    @FXML
    private ComboBox<String> cbDishCatalogies;
    @FXML
    public Button btnDishBrowser;
    @FXML
    public Button btnDishClear;
    @FXML
    public Button btnDishCreate;
    @FXML
    public Button btnDishUpdate;
    @FXML
    public Button btnDishDelete;
    @FXML
    private ComboBox<String> cbDishStatus;
    @FXML
    private TableColumn<MenuDB, String> colDishDescription;
    @FXML
    private TextArea taDishDesciption;
    @FXML
    private TableColumn<StaffDB, Integer> colStaffPhone;
    @FXML
    private TableColumn<StaffDB, String> colStaffMail;
    @FXML
    private javafx.scene.control.TextField tfStaffPhone;
    @FXML
    private javafx.scene.control.TextField tfStaffMail;
    @FXML
    private TableView<CustomerDB> tvCustomer;
    @FXML
    private TableColumn<CustomerDB, Integer> colCustomerID;
    @FXML
    private TableColumn<CustomerDB, String> colCustomerName;
    @FXML
    private TableColumn<CustomerDB, LocalDate> colCustomerDOB;
    @FXML
    private TableColumn<CustomerDB, String> colCustomerAddress;
    @FXML
    private TableColumn<CustomerDB, Integer> colCustomerPhone;
    @FXML
    private TableColumn<CustomerDB, String> colCustomerMail;
    @FXML
    private TableColumn<CustomerDB, String> colCustomerGender;
    @FXML
    private ImageView imgCustomer;
    @FXML
    private Label lbCustomerID;
    @FXML
    private javafx.scene.control.TextField tfCustomerName;
    @FXML
    private javafx.scene.control.TextField tfCustomerAddress;
    @FXML
    private javafx.scene.control.TextField tfCustomerPhone;
    @FXML
    private javafx.scene.control.TextField tfCustomerMail;
    @FXML
    private ComboBox<String> cbCustomerGender;
    @FXML
    private Button btnCustomerBrowser;
    @FXML
    private Button btnCustomerClear;
    @FXML
    private Button btnCustomerCreate;
    @FXML
    private Button btnCustomerUpdate;
    @FXML
    private Button btnCustomerDelete;
    @FXML
    private DatePicker tfCustomerDOB;
    @FXML
    private Label lbOrderMenuAll;
    @FXML
    private TableView<OrderMenuDB> tvOrderMenu;
    @FXML
    private TableColumn<OrderMenuDB, String> colOrderMenuDishName;
    @FXML
    private TableColumn<OrderMenuDB, Integer> colOrderMenuDishPrice;
    @FXML
    private TableColumn<OrderMenuDB, Integer> colOrderMenuDishAvailable;
    @FXML
    private TableColumn<OrderMenuDB, String> colOrderMenuDishDescription;
    @FXML
    private Label lbOrderDishName;
    @FXML
    private VBox vbOrderMenu;
    @FXML
    private Label lbOrderMenuHors;
    @FXML
    private Label lbOrderMenuSoup;
    @FXML
    private Label lbOrderMenuFishDish;
    @FXML
    private Label lbOrderMenuMeatDish;
    @FXML
    private Label lbOrderMenuMainCourse;
    @FXML
    private Label lbOrderMenuSalad;
    @FXML
    private Label lbOrderMenuDessert;
    @FXML
    private Label lbOrderMenuDrink;
    @FXML
    private Spinner<Integer> snOrderDishQuantity;
    @FXML
    private TableColumn<CodeDB, Integer> colCodeDiscountPercent;
    @FXML
    private javafx.scene.control.TextField tfCodeDiscountPercent;
    @FXML
    private ImageView imgOrderMenu;
    @FXML
    private Button btnOrderMenuAdd;
    private ComboBox<Integer> cbOrderTable;
    @FXML
    private ComboBox<String> cbOrderCatalogies;
    @FXML
    private Label lbTime;
    @FXML
    private TableView<OrderListMini> tvOderListMini;
    @FXML
    private TableColumn<OrderListMini, String> colOrderListMiniDishName;
    @FXML
    private TableColumn<OrderListMini, Integer> colOrderListMiniDishPrice;
    @FXML
    private TableColumn<OrderListMini, Integer> colOrderListMiniDishQuantity;
    @FXML
    private TableView<OrderList> tvOderList;
    @FXML
    private TableColumn<OrderList, Integer> colOrderID;
    @FXML
    private TableColumn<OrderList, String> colOrderTime;
    @FXML
    private TableColumn<OrderList, String> colOrderName;
    @FXML
    private TableColumn<OrderList, Integer> colOrderQuantity;
    @FXML
    private TableColumn<OrderList, String> colOrderCatalogies;
    @FXML
    private Label lbOrderID;
    @FXML
    private Button btnOrderMiniSend;
    @FXML
    private Button btnOrderMiniRemove;
    @FXML
    private Button btnOrderMiniDelete;
    @FXML
    private ComboBox<String> cbBillTable;
    private ComboBox<Integer> cbBillTakeAway;
    @FXML
    private TableColumn<BillDB, String> colBillDishName;
    @FXML
    private TableColumn<BillDB, Integer> colBillDishQuantity;
    @FXML
    private TableColumn<BillDB, Integer> colBillDishPrice;
    @FXML
    private TableView<BillDB> tvBill;
    @FXML
    private Button btnBillGet;
    private Spinner<?> snBillPeople;
    @FXML
    private javafx.scene.control.TextField tfBillDiscount;
    @FXML
    private Button btnBillClear;
    @FXML
    private TableColumn<OrderList, String> colOrderNote;
    @FXML
    private TextArea taOrderNote;
    @FXML
    private TableColumn<OrderList, Boolean> colOrderCheck;
    @FXML
    private Label lbBillTotal;
    @FXML
    private Label lbBookCount;
    @FXML
    private TableView<BookDetail> tvBookDetail;
    @FXML
    private TableColumn<BookDetail, String> colBookDetailName;
    @FXML
    private TableColumn<BookDetail, Integer> colBookDetailQuantity;
    @FXML
    private TableColumn<BookDetail, Integer> colBookDetailPrice;
    @FXML
    private TableView<BookInfo> tvBookInfo;
    @FXML
    private TableColumn<BookInfo, Integer> colBookInfoID;
    @FXML
    private TableColumn<BookInfo, LocalDate> colBookInfoDate;
    @FXML
    private TableColumn<BookInfo, String> colBookInfoTime;
    @FXML
    private TableColumn<BookInfo, String> colBookInfoCusName;
    @FXML
    private TableColumn<BookInfo, String> colBookInfoCatalogies;
    @FXML
    private TableColumn<BookInfo, String> colBookInfoNote;
    @FXML
    private Button btnGetBookDetail;
    @FXML
    private Label lbBookTotal;
    @FXML
    public Tab tabMenu;
    @FXML
    private Tab tabOrder;
    @FXML
    private Tab tabOrderList;
    @FXML
    private Tab tabTable;
    @FXML
    private Tab tabBook;
    @FXML
    public Tab tabInventory;
    @FXML
    public Tab tabStaff;
    @FXML
    private Tab tabCustomer;
    @FXML
    public Tab tabDisCode;
    @FXML
    public Tab tabReceipts;
    @FXML
    public Tab tabPayments;
    @FXML
    public Tab tabReport;
    @FXML
    public Tab tabAccount;
    @FXML
    private Label lbOrderMenuOther;
    @FXML
    private TextArea taBillNote;
    @FXML
    private Button btnBillCheckOut;
    @FXML
    private Label lbTotalReceipt;
    @FXML
    private TableView<ReceiptDB> tvReceipt;
    @FXML
    private TableColumn<ReceiptDB, Integer> colReceiptID;
    @FXML
    private TableColumn<ReceiptDB, String> colReceiptTime;
    @FXML
    private TableColumn<ReceiptDB, String> colReceiptCatalog;
    @FXML
    private TableColumn<ReceiptDB, Integer> colReceiptPrice;
    @FXML
    private TableColumn<ReceiptDB, String> colReceiptNote;
    @FXML
    private ComboBox<String> cbReceiptCatalog;
    @FXML
    private javafx.scene.control.TextField tfReceiptPrice;
    @FXML
    private TextArea taReceiptNote;
    @FXML
    private Button btnReceiptCreate;
    @FXML
    private Button btnReceiptUpdate;
    @FXML
    public Button btnReceiptDelete;
    @FXML
    private Label lbTotalPayment;
    @FXML
    private TableView<PaymentDB> tvPayment;
    @FXML
    private TableColumn<PaymentDB, Integer> colPaymentID;
    @FXML
    private TableColumn<PaymentDB, String> colPaymentTime;
    @FXML
    private TableColumn<PaymentDB, String> colPaymentCatalog;
    @FXML
    private TableColumn<PaymentDB, Integer> colPaymentPrice;
    @FXML
    private TableColumn<PaymentDB, String> colPaymentNote;
    @FXML
    private javafx.scene.control.TextField tfPaymentPrice;
    @FXML
    private TextArea taPaymentNote;
    @FXML
    private Button btnPaymentCreate;
    @FXML
    public Button btnPaymentUpdate;
    @FXML
    public Button btnPaymentDelete;
    @FXML
    private javafx.scene.control.TextField tfInventoryUnit;
    @FXML
    private Label lbStaffRole;
    @FXML
    private Button btnLogOut;
    @FXML
    private Label lbOrderMiniDishName;
    @FXML
    private TableColumn<BillDB, Integer> colBillDishAmount;

    private ObservableList<BillDB> orderList;
    @FXML
    private Label lbBillDiscount;
    @FXML
    private Label lbBillAfter;
    @FXML
    private TextArea taOrderDishDescription;
    @FXML
    private Button btnChangePassword;
    @FXML
    private ComboBox<String> cbSendTable;
    @FXML
    private Button btnSendBook;
    @FXML
    private Button btnDeleteBook;
    @FXML
    public Button btnInventoryAdd;
    @FXML
    private Button btnRefresh;
    @FXML
    private PieChart pChart;
    @FXML
    private ComboBox<String> cbPaymentCatalog;
    @FXML
    private Button btnDayReport;
    @FXML
    private Button btnReceiptClear;
    @FXML
    private Button btnPaymentClear;
    @FXML
    private Label lbCheck;
    @FXML
    private Label lbStaffCheck;
    @FXML
    private Label lbCusCheck;
    @FXML
    private TableColumn<StaffDB, String> colStaffUserName;
    @FXML
    private javafx.scene.control.TextField tfStaffUsername;
    @FXML
    private TableColumn<CustomerDB, String> colCustomerUserName;
    @FXML
    private javafx.scene.control.TextField tfCustomerUserName;
    private ComboBox<String> cbStaffUsername;
    private ComboBox<String> cbCustomerUserName;
    @FXML
    private Label lbDishNameCheck;
    @FXML
    private Label lbInventoryCheck;
    @FXML
    public Button btnInventoryRemove;
    @FXML
    private Label lbCodeCheck;
    @FXML
    private Label lbBookID;
    @FXML
    private DatePicker dpBookDate;
    @FXML
    private javafx.scene.control.TextField tfBookCusName;
    @FXML
    private ComboBox<String> cbBookCatalogies;
    @FXML
    private TextArea taBookNote;
    @FXML
    private Button btnUpdateBook;
    @FXML
    private Spinner<String> snBookTime;
    @FXML
    private Button btnEditBook;
    @FXML
    private Button btnShowReport;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnStaffBrowser) {
            stage = (Stage) bpStaff.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                System.out.println("" + file.getAbsolutePath());
                image = new Image(file.getAbsoluteFile().toURI().toString(), imgStaffImage.getFitWidth(), imgStaffImage.getFitHeight(), true, true);
                imgStaffImage.setImage(image);
                imgStaffImage.setPreserveRatio(true);
            }
        }
        if (event.getSource() == btnInventoryBrowser) {
            stage = (Stage) bpStaff.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                System.out.println("" + file.getAbsolutePath());
                image = new Image(file.getAbsoluteFile().toURI().toString(), imgInventory.getFitWidth(), imgInventory.getFitHeight(), true, true);
                imgInventory.setImage(image);
                imgInventory.setPreserveRatio(true);
            }
        }
        if (event.getSource() == btnDishBrowser) {
            stage = (Stage) bpStaff.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                System.out.println("" + file.getAbsolutePath());
                image = new Image(file.getAbsoluteFile().toURI().toString(), imgDish.getFitWidth(), imgDish.getFitHeight(), true, true);
                imgDish.setImage(image);
                imgDish.setPreserveRatio(true);
            }
        }
        if (event.getSource() == btnCustomerBrowser) {
            stage = (Stage) bpStaff.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                System.out.println("" + file.getAbsolutePath());
                image = new Image(file.getAbsoluteFile().toURI().toString(), imgCustomer.getFitWidth(), imgCustomer.getFitHeight(), true, true);
                imgCustomer.setImage(image);
                imgCustomer.setPreserveRatio(true);
            }
        }
    }

//    @FXML
    @FXML
    private void handleMouseAction(MouseEvent event) throws IOException {
        if (event.getSource() == btnLogOut) {
            modalBox("/FXMLFile/LoginScene.fxml", "Sign In");
        }
        if (event.getSource() == tvStaff) {
            selectStaff();
        }
        if (event.getSource() == btnStaffClear) {
            clearStaff();
        }
        if (event.getSource() == btnStaffCreate) {
            if (!Pattern.matches("\\X{1,}", tfStaffName.getText())) {
                alert("Please fill Staff name");
            } else if (tfStaffDOB.getValue() == null) {
                alert("Please fill Staff DOB in right form");
            } else if (!Pattern.matches("\\X{1,}", tfStaffAddress.getText())) {
                alert("Please fill Staff Address");
            } else if (cbStaffPossition.getValue() == null) {
                alert("Please fill choose Staff possition");
            } else if (!Pattern.matches("\\d{8,12}", tfStaffPhone.getText())) {
                alert("Please fill Staff phone in right form");
            } else if (!Pattern.matches("\\w{3,30}@([a-z0-9]{3,10}\\.){1,2}[a-z]{2,3}", tfStaffMail.getText())) {
                alert("Please fill Staff mail in right form");
            } else if (!Pattern.matches("\\d{1,}", tfStaffSalary.getText())) {
                alert("Please fill Staff salary");
            } else if (!Pattern.matches("\\w{1,}", tfStaffUsername.getText())) {
                alert("Please fill Staff Username");
            } else if (imgStaffImage.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to create new staff?") == true) {
                    insertStaff();
                    //insert("insert into Chi values(1,N'" + lbTime.getText() + "','Salary' , " + tfStaffSalary.getText() + ",'Salary for " + tfStaffName.getText() + "," + lbUser.getText() + " have edit')");
                    clearStaff();
                    log("" + lbUser.getText() + " have create new staff!");
                    showLogDB();
                    showPaymentDB();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnStaffUpdate) {
            if (!Pattern.matches("\\X{1,}", tfStaffName.getText())) {
                alert("Please fill Staff name");
            } else if (tfStaffDOB.getValue() == null) {
                alert("Please fill Staff DOB in right form");
            } else if (!Pattern.matches("\\X{1,}", tfStaffAddress.getText())) {
                alert("Please fill Staff Address");
            } else if (cbStaffPossition.getValue() == null) {
                alert("Please fill choose Staff possition");
            } else if (!Pattern.matches("\\d{8,12}", tfStaffPhone.getText())) {
                alert("Please fill Staff phone in right form");
            } else if (!Pattern.matches("\\w{3,30}@([a-z0-9]{3,10}\\.){1,2}[a-z]{2,3}", tfStaffMail.getText())) {
                alert("Please fill Staff mail in right form");
            } else if (!Pattern.matches("\\d{1,}", tfStaffSalary.getText())) {
                alert("Please fill Staff salary");
            } else if (!Pattern.matches("\\w{1,}", tfStaffUsername.getText())) {
                alert("Please fill Staff Username");
            } else if (imgStaffImage.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to update staff?") == true) {
                    updateStaff();
                    //update("update Chi set chiPrice=" + tfStaffSalary.getText() + " where chiNote like 'Salary for " + tfStaffName.getText() + "%'");
                    //update("update Account set accountPhone=N'" + tfStaffPhone.getText() + "',accountMail=N'" + tfStaffMail.getText() + "' where accountPhone=N'" + tfStaffPhone.getText() + "'");
                    clearStaff();
                    log("" + lbUser.getText() + " have update staff!");
                    showLogDB();
                    showPaymentDB();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnStaffDelete) {
            if (alertConFirm("Are you want to delete staff?") == true) {
                deleteStaff();
                //delete("delete from Chi where chiNote like 'Salary for " + tfStaffName.getText() + "%'");
                clearCode();
                log("" + lbUser.getText() + " have delete staff!");
                showLogDB();
                showPaymentDB();
                alertSuccess("Delete Successfully!");

            }
        }
        if (event.getSource() == tvAccount) {
            selectAccount();
        }
        if (event.getSource() == btnAccountClear) {
            clearAccount();
        }
        if (event.getSource() == btnAccountCreate) {
            if (!Pattern.matches("\\w{1,}", tfAccountUsername.getText())) {
                alert("Please fill Account username");
            } else if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", tfAccountPassword.getText())) {
                alert("Password must contain at least 1 digit [0-9],\n"
                        + "One lowercase [a-z],"
                        + "One uppercase [A-Z],\n"
                        + "One special character like !@#.\n"
                        + "8-20 characters");
            } else if (cbAccountRole.getValue() == null) {
                alert("Please fill Account role");
            } else {
                if (alertConFirm("Are you want to create new account?") == true) {
                    insert("insert into Account values (N'" + tfAccountUsername.getText() + "',N'" + tfAccountPassword.getText() + "',N'" + cbAccountRole.getValue() + "')");
                    showAccountDB();
                    clearAccount();
                    log("" + lbUser.getText() + " have create new account!");
                    showLogDB();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnAccountUpdate) {
            if (!Pattern.matches("\\w{1,}", tfAccountUsername.getText())) {
                alert("Please fill Account username");
            } else if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", tfAccountPassword.getText())) {
                alert("Password must contain at least one digit [0-9].\n"
                        + "Password must contain at least one lowercase Latin character [a-z].\n"
                        + "Password must contain at least one uppercase Latin character [A-Z].\n"
                        + "Password must contain at least one special character like ! @ # & ( ).\n"
                        + "Password must contain a length of at least 8 characters and a maximum of 20 characters.");
            } else if (cbAccountRole.getValue() == null) {
                alert("Please fill Account role");
            } else {
                if (alertConFirm("Are you want to update account?") == true) {
                    update("update Account set accountUserName=N'" + tfAccountUsername.getText() + "',accountPassWord=" + tfAccountPassword.getText() + ",accountRole=N'" + cbAccountRole.getValue() + "' where accountID=" + Integer.valueOf(lbAccountID.getText()) + "");
                    showAccountDB();
                    clearAccount();
                    log("" + lbUser.getText() + " have update account!");
                    showLogDB();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnAccountDelete) {
            if (alertConFirm("Are you want to delete account?") == true) {
                delete("delete from Account where accountID=" + Integer.valueOf(lbAccountID.getText()) + "");
                showAccountDB();
                clearAccount();
                log("" + lbUser.getText() + " have delete account!");
                showLogDB();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == tvCodeDiscount) {
            selectCode();
        }
        if (event.getSource() == btnCodeClear) {
            clearCode();
        }
        if (event.getSource() == btnCodeCreate) {
            if (!Pattern.matches("\\w{1,}", tfCodeValue.getText())) {
                alert("Please fill Code name");
            } else if (!Pattern.matches("\\d{1,}", tfCodeQuantity.getText())) {
                alert("Please fill Code quantity");
            } else if (!Pattern.matches("\\d{1,}", tfCodeDiscountPercent.getText())) {
                alert("Please fill Code discount percent");
            } else if (getMaGiamGia() == false) {
                alert("Code is exits");
            } else {
                if (alertConFirm("Are you want to create new code?") == true) {
                    insert("insert into codeDiscount values (1,N'" + tfCodeValue.getText().toUpperCase() + "'," + tfCodeQuantity.getText() + "," + tfCodeDiscountPercent.getText() + ")");
                    showCodeDB();
                    clearCode();
                    log("" + lbUser.getText() + " have create new code!");
                    showLogDB();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnCodeUpdate) {
            CodeDB i = tvCodeDiscount.getSelectionModel().getSelectedItem();
            if (!Pattern.matches("\\w{1,}", tfCodeValue.getText())) {
                alert("Please fill Code name");
            } else if (!Pattern.matches("\\d{1,}", tfCodeQuantity.getText())) {
                alert("Please fill Code quantity");
            } else if (!Pattern.matches("\\d{1,}", tfCodeDiscountPercent.getText())) {
                alert("Please fill Code discount percent");
            } else if (!Pattern.matches("\\d{1,}", tfCodeDiscountPercent.getText())) {
                alert("Please fill Code discount percent");
            } else if (!Pattern.matches(i.getCodeValue(), tfCodeValue.getText())) {
                alert("Can't update code value");
            } else {
                if (alertConFirm("Are you want to update code?") == true) {
                    update("update codeDiscount set codeQuantity=" + Integer.valueOf(tfCodeQuantity.getText()) + " ,discountPercent=" + Integer.valueOf(tfCodeDiscountPercent.getText()) + "where codeID=" + Integer.valueOf(lbCodeID.getText()) + "");
                    showCodeDB();
                    clearCode();
                    log("" + lbUser.getText() + " have update code!");
                    showLogDB();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnCodeDelete) {
            if (alertConFirm("Are you want to delete code?") == true) {
                delete("delete from codeDiscount where codeID=" + Integer.valueOf(lbCodeID.getText()) + "");
                showCodeDB();
                clearCode();
                log("" + lbUser.getText() + " have delete code!");
                showLogDB();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == tvInventory) {
            selectInventory();
        }
        if (event.getSource() == btnInventoryClear) {
            clearInventory();
        }
        if (event.getSource() == btnInventoryCreate) {
            if (!Pattern.matches("\\X{1,}", tfInventoryName.getText())) {
                alert("Please fill Product name");
            } else if (!Pattern.matches("\\X{1,}", tfInventoryUnit.getText())) {
                alert("Please fill Product Unit");
            } else if (cbInventoryCatalogies.getValue() == null) {
                alert("Please fill Product Catalogies");
            } else if (imgInventory.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to create new product?") == true) {
                    insertInventory();
                    clearInventory();
                    getIngredient();
                    showOrderMenuDB();
                    log("" + lbUser.getText() + " have create new product!");
                    showLogDB();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnInventoryUpdate) {
            if (!Pattern.matches("\\X{1,}", tfInventoryName.getText())) {
                alert("Please fill Product name");
            } else if (!Pattern.matches("\\X{1,}", tfInventoryUnit.getText())) {
                alert("Please fill Product Unit");
            } else if (cbInventoryCatalogies.getValue() == null) {
                alert("Please fill Product Catalogies");
            } else if (imgInventory.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to update product?") == true) {
                    updateInventory();
                    clearInventory();
                    showOrderMenuDB();
                    log("" + lbUser.getText() + " have update product!");
                    showLogDB();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnInventoryDelete) {
            InventoryDB i = tvInventory.getSelectionModel().getSelectedItem();
            if (textDialog("Confirm", "Reason", "" + lbUser.getText() + " have delete " + i.getProductName() + " product for ") == true) {
                deleteInventory();
                clearInventory();
                update("update Menu set dishStatus='Unavailable' where dishIngredient = N'" + i.getProductName() + "')");
                showOrderMenuDB();
                showLogDB();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == tvMenu) {
            selectMenu();
        }
        if (event.getSource() == btnDishClear) {
            clearMenu();
        }
        if (event.getSource() == btnDishCreate) {
            if (!Pattern.matches("\\X{1,}", tfDishName.getText())) {
                alert("Please fill DishName");
            } else if (!Pattern.matches("\\d{1,}", tfDishPrice.getText())) {
                alert("Please fill DishPrice in right form");
            } else if (cbDishIngredient.getValue() == null) {
                alert("Please fill DishIngredient");
            } else if (!Pattern.matches("\\d{1,}", tfDishConsume.getText())) {
                alert("Please fill DishConsume in right form");
            } else if (cbDishCatalogies.getValue() == null) {
                alert("Please fill DishCatalogies");
            } else if (cbDishStatus.getValue() == null) {
                alert("Please fill DishStatus");
            } else if (imgDish.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to create new dish?") == true) {
                    insertMenu();
                    clearMenu();
                    showOrderMenuDB();
                    log("" + lbUser.getText() + " have create new dish!");
                    showLogDB();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnDishUpdate) {
            if (!Pattern.matches("\\X{1,}", tfDishName.getText())) {
                alert("Please fill DishName");
            } else if (!Pattern.matches("\\d{1,}", tfDishPrice.getText())) {
                alert("Please fill DishPrice in right form");
            } else if (cbDishIngredient.getValue() == null) {
                alert("Please fill DishIngredient");
            } else if (!Pattern.matches("\\d{1,}", tfDishConsume.getText())) {
                alert("Please fill DishConsume in right form");
            } else if (cbDishCatalogies.getValue() == null) {
                alert("Please fill DishCatalogies");
            } else if (cbDishStatus.getValue() == null) {
                alert("Please fill DishStatus");
            } else if (imgDish.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to update dish?") == true) {
                    updateMenu();
                    clearMenu();
                    showOrderMenuDB();
                    log("" + lbUser.getText() + " have update dish!");
                    showLogDB();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnDishDelete) {
            if (alertConFirm("Are you want to delete dish?") == true) {
                deleteMenu();
                clearMenu();
                showOrderMenuDB();
                log("" + lbUser.getText() + " have delete dish!");
                showLogDB();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == tvCustomer) {
            selectCustomer();
        }
        if (event.getSource() == btnCustomerClear) {
            clearCustomer();
        }
        if (event.getSource() == btnCustomerCreate) {
            if (!Pattern.matches("\\X{1,}", tfCustomerName.getText())) {
                alert("Please fill Customer name");
            } else if (tfCustomerDOB.getValue() == null) {
                alert("Please fill Customer DOB in right form");
            } else if (!Pattern.matches("\\X{1,}", tfCustomerAddress.getText())) {
                alert("Please fill Customer Address");
            } else if (!Pattern.matches("\\d{8,12}", tfCustomerPhone.getText())) {
                alert("Please fill Customer phone in right form");
            } else if (!Pattern.matches("\\w{3,30}@([a-z0-9]{3,10}\\.){1,2}[a-z]{2,3}", tfCustomerMail.getText())) {
                alert("Please fill Customer mail in right form");
            } else if (cbCustomerGender.getValue() == null) {
                alert("Please fill choose Customer gender");
            } else if (!Pattern.matches("\\w{1,}", tfCustomerUserName.getText())) {
                alert("Please fill Customer Username");
            } else if (imgCustomer.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to create new customer?") == true) {
                    insertCustomer();
                    clearCustomer();
                    log("" + lbUser.getText() + " have create new customer!");
                    showLogDB();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnCustomerUpdate) {
            if (!Pattern.matches("\\X{1,}", tfCustomerName.getText())) {
                alert("Please fill Customer name");
            } else if (tfCustomerDOB.getValue() == null) {
                alert("Please fill Customer DOB in right form");
            } else if (!Pattern.matches("\\X{1,}", tfCustomerAddress.getText())) {
                alert("Please fill Customer Address");
            } else if (!Pattern.matches("\\d{8,12}", tfCustomerPhone.getText())) {
                alert("Please fill Customer phone in right form");
            } else if (!Pattern.matches("\\w{3,30}@([a-z0-9]{3,10}\\.){1,2}[a-z]{2,3}", tfCustomerMail.getText())) {
                alert("Please fill Customer mail in right form");
            } else if (cbCustomerGender.getValue() == null) {
                alert("Please fill choose Customer gender");
            } else if (!Pattern.matches("\\w{1,}", tfCustomerUserName.getText())) {
                alert("Please fill Customer Username");
            } else if (imgCustomer.getImage() == null) {
                alert("Please Choose image");
            } else {
                if (alertConFirm("Are you want to update customer?") == true) {
                    updateCustomer();
                    update("update Account set accountPhone=N'" + tfCustomerPhone.getText() + "',accountMail=N'" + tfCustomerMail.getText() + "' where accountPhone=N'" + tfCustomerPhone.getText() + "'");
                    clearCustomer();
                    log("" + lbUser.getText() + " have update customer!");
                    showLogDB();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnCustomerDelete) {
            if (alertConFirm("Are you want to delete customer?") == true) {
                deleteCustomer();
                clearCustomer();
                log("" + lbUser.getText() + " have delete customer!");
                showLogDB();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == lbOrderMenuAll) {
            showOrderMenuDB();
        }
        if (event.getSource() == lbOrderMenuHors) {
            showOrderMenuByCatalogiesDB("Hors d''oeuvres");
        }
        if (event.getSource() == lbOrderMenuSoup) {
            showOrderMenuByCatalogiesDB("Soup");
        }
        if (event.getSource() == lbOrderMenuFishDish) {
            showOrderMenuByCatalogiesDB("Fish Dish");
        }
        if (event.getSource() == lbOrderMenuMeatDish) {
            showOrderMenuByCatalogiesDB("Meat Dish");
        }
        if (event.getSource() == lbOrderMenuMainCourse) {
            showOrderMenuByCatalogiesDB("Main Course");
        }
        if (event.getSource() == lbOrderMenuSalad) {
            showOrderMenuByCatalogiesDB("Salad");
        }
        if (event.getSource() == lbOrderMenuDessert) {
            showOrderMenuByCatalogiesDB("Dessert");
        }
        if (event.getSource() == lbOrderMenuDrink) {
            showOrderMenuByCatalogiesDB("Drink");
        }
        if (event.getSource() == lbOrderMenuOther) {
            showOrderMenuByCatalogiesDB("Other");
        }
        if (event.getSource() == tvOrderMenu) {
            OrderMenuDB o = tvOrderMenu.getSelectionModel().getSelectedItem();
            SpinnerValueFactory<Integer> dishSpiner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, o.getMenuDishAvailabe(), 0, 1);
            snOrderDishQuantity.setValueFactory(dishSpiner);
            selectOrderMenu();
        }
        if (event.getSource() == btnOrderMenuAdd) {
            OrderMenuDB om = tvOrderMenu.getSelectionModel().getSelectedItem();
            if (om.getMenuDishAvailabe() == snOrderDishQuantity.getValue()) {
                update("update Menu set dishStatus='Unavailable' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getMenuDishName() + "')");
            }
            lbOrderDishName.setText(om.getMenuDishName());
            addToOderList();
            insert("update Inventory set productQOH-=(select a.dishConsume*" + snOrderDishQuantity.getValue() + " as ingredientDown from Menu a join OrderMini b on a.dishName =b.dishName where b.dishName=N'" + om.getMenuDishName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getMenuDishName() + "')");
            showOrderMiniDB();
            showMenuDB();
            showOrderMenuDB();
            showInventoryDB();
        }
        if (event.getSource() == btnOrderMiniSend) {
            if (cbOrderCatalogies.getValue() == null) {
                alert("Please choose Catalogies");
            } else if (getBangMini() == false) {
                alert("Please choose dish");
            } else {
                if (alertConFirm("Are you want to send order?") == true) {
                    lbOrderID.setText("" + count.getAndIncrement());
                    insert("insert into [Order](brandID,orderID,orderTime,dishCatalogies,orderNote,dishName,dishPrice,dishQuantity) select 1," + lbOrderID.getText() + ",N'" + lbTime.getText() + "',N'" + cbOrderCatalogies.getValue() + "' ,N'" + taOrderNote.getText() + "',OrderMini.dishName,OrderMini.dishPrice,OrderMini.dishQuantity from [OrderMini]");
                    delete("delete from [OrderMini]");
                    cbOrderCatalogies.setValue(null);
                    taOrderNote.clear();
                    showOrderListDB();
                    showOrderMiniDB();
                    showMenuDB();
                    getTable();
                    log("" + lbUser.getText() + " have send order!");
                    showLogDB();
                    alertSuccess("Send Order Successfully!");
                }
            }
        }
        if (event.getSource() == btnSendBook) {
            if (cbSendTable.getValue() == null) {
                alert("Please choose Catalogies");
            } else {
                if (alertConFirm("Are you want to send order?") == true) {
                    BookInfo bi = tvBookInfo.getSelectionModel().getSelectedItem();
                    lbOrderID.setText("" + count.getAndIncrement());
                    insert("insert into [Order](brandID,orderID,orderTime,dishCatalogies,orderNote,dishName,dishPrice,dishQuantity) select 1," + bi.getBookID() + ",N'" + lbTime.getText() + "',N'" + cbSendTable.getValue() + "' ,N'" + bi.getBookNote() + "',Book.bookDishName,Book.bookDishPrice,Book.bookDishQuantity from [Book] where Book.bookCustomerName='" + bi.getBookCustomerName() + "' and Book.bookID=" + bi.getBookID() + "");
                    delete("delete from [Book] where bookID=" + bi.getBookID() + "");
                    cbSendTable.setValue(null);
                    showOrderListDB();
                    showBookInfoDB();
                    tvBookDetail.getItems().clear();
                    getTable();
                    bookCount();
                    lbBookTotal.setText(null);
                    log("" + lbUser.getText() + " have send order!");
                    showLogDB();
                    alertSuccess("Send Order Successfully!");
                }
            }
        }
        if (event.getSource() == btnBillGet) {
            showBillDB();
            totalBill();
        }

        if (event.getSource() == btnBillClear) {
            clearBill();
            tvBill.getItems().clear();
        }
        if (event.getSource() == btnOrderMiniRemove) {
            OrderListMini om = tvOderListMini.getSelectionModel().getSelectedItem();
            lbOrderMiniDishName.setText(om.getOrderMiniName());
            if (om.getOrderMiniQuantity() != 1) {
                update("update [OrderMini] set dishQuantity-=1 where dishName=N'" + om.getOrderMiniName() + "'");
                insert("update Inventory set productQOH+=(select a.dishConsume*1 as ingredientUp from Menu a join OrderMini b on a.dishName =b.dishName where b.dishName=N'" + om.getOrderMiniName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getOrderMiniName() + "')");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getOrderMiniName() + "')");
                showOrderMiniDB();
                showOrderMenuDB();
                showMenuDB();
                showInventoryDB();
            } else {
                insert("update Inventory set productQOH+=(select a.dishConsume*1 as ingredientUp from Menu a join OrderMini b on a.dishName =b.dishName where b.dishName=N'" + om.getOrderMiniName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getOrderMiniName() + "')");
                delete("delete from [OrderMini] where dishName=N'" + om.getOrderMiniName() + "'");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getOrderMiniName() + "')");
                showOrderMiniDB();
                showOrderMenuDB();
                showMenuDB();
                showInventoryDB();
            }

        }
        if (event.getSource() == btnOrderMiniDelete) {
            if (alertConFirm("Are you want to delete order?") == true) {
                OrderListMini om = tvOderListMini.getSelectionModel().getSelectedItem();
                lbOrderMiniDishName.setText(om.getOrderMiniName());
                insert("update Inventory set productQOH+=(select a.dishConsume*" + om.getOrderMiniQuantity() + " as ingredientUp from Menu a join OrderMini b on a.dishName =b.dishName where b.dishName=N'" + om.getOrderMiniName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getOrderMiniName() + "')");
                delete("delete from [OrderMini] where dishName=N'" + om.getOrderMiniName() + "'");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getOrderMiniName() + "')");
                showOrderMiniDB();
                showMenuDB();
                showOrderMenuDB();
                showInventoryDB();
                log("" + lbUser.getText() + " have delete order!");
                showLogDB();
                alertSuccess("Delete Order Successfully!");
            }
        }
        if (event.getSource() == btnGetBookDetail) {
            BookInfo bi = tvBookInfo.getSelectionModel().getSelectedItem();
            showBookDetailDB(bi.getBookCustomerName(), bi.getBookID());
            totalBook();
        }
        if (event.getSource() == btnBillCheckOut) {
            if (cbBillTable.getValue() == null) {
                alert("Please choose table!");
            } else {
                cbBillTable.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    showBillDB();
                    totalBill();
                });
                if (alertConFirm("Are you want to check out " + cbBillTable.getValue() + "?") == true) {
                    insert("insert into Thu values(1,N'" + lbTime.getText() + "',N'" + cbBillTable.getValue() + "'," + lbBillAfter.getText() + ",N'" + lbUser.getText() + " have check out." + taBillNote.getText() + "')");
                    delete("delete from [Order] where dishCatalogies=N'" + cbBillTable.getValue() + "'");
                    alertSuccess("Check out " + cbBillTable.getValue() + " Successfully!");
                    lastCode();
                    update("update codeDiscount set codeQuantity -=1 where codeValue=N'" + tfBillDiscount.getText() + "'");
                    log("" + lbUser.getText() + " have check out " + cbBillTable.getValue() + " with discount code " + tfBillDiscount.getText() + "!");
                    clearBill();
                    showLogDB();
                    tvBill.getItems().clear();
                    showReceiptDB();
                    showOrderListDB();
                    showCodeDB();
                    getTable();
                }
            }
        }
//        if(event.getSource()==btnNew){
//            tabOrder.set;
//        }
//        if (event.getSource() == btnBillPrint) {
//            showInvoice2();
//        }
        if (event.getSource() == btnReceiptClear) {
            clearReceipt();
        }
        if (event.getSource() == btnPaymentClear) {
            clearPayment();
        }
        if (event.getSource() == btnReceiptCreate) {
            if (cbReceiptCatalog.getValue() == null) {
                alert("Please fill Receipt catalogies");
            } else if (!Pattern.matches("\\d{1,}", tfReceiptPrice.getText())) {
                alert("Please fill Price of Receipt");
            } else {
                if (alertConFirm("Are you want to create receipt?") == true) {
                    insert("insert into Thu values(1,N'" + lbTime.getText() + "',N'" + cbReceiptCatalog.getValue() + "'," + tfReceiptPrice.getText() + ",N'" + taReceiptNote.getText() + "')");
                    clearReceipt();
                    showReceiptDB();
                    log("" + lbUser.getText() + " have create receipt!");
                    showLogDB();
                    totalReceipt();
                    createChart();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnReceiptUpdate) {
            if (cbReceiptCatalog.getValue() == null) {
                alert("Please fill Receipt catalogies");
            } else if (!Pattern.matches("\\d{1,}", tfReceiptPrice.getText())) {
                alert("Please fill Price of Receipt");
            } else {
                if (alertConFirm("Are you want to update receipt?") == true) {
                    ReceiptDB i = tvReceipt.getSelectionModel().getSelectedItem();
                    update("update Thu set thuCatalog=N'" + cbReceiptCatalog.getValue() + "', thuPrice=" + tfReceiptPrice.getText() + ", thuNote=N'" + taReceiptNote.getText() + "' where thuID=" + i.getThuID() + "");
                    if (i == null) {
                        alert("Please choose receipt");
                    }
                    clearReceipt();
                    showReceiptDB();
                    log("" + lbUser.getText() + " have update receipt!");
                    showLogDB();
                    totalReceipt();
                    createChart();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == btnReceiptDelete) {
            if (alertConFirm("Are you want to delete repceit?") == true) {
                ReceiptDB i = tvReceipt.getSelectionModel().getSelectedItem();
                delete("delete from Thu where thuID=" + i.getThuID() + "");
                if (i == null) {
                    alert("Please choose receipt");
                }
                clearReceipt();
                showPaymentDB();
                log("" + lbUser.getText() + " have delete repceipt!");
                showLogDB();
                totalReceipt();
                createChart();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == btnPaymentCreate) {
            if (cbPaymentCatalog.getValue() == null) {
                alert("Please fill Payment catalogies");
            } else if (!Pattern.matches("\\d{1,}", tfPaymentPrice.getText())) {
                alert("Please fill Price of Payment");
            } else {
                if (alertConFirm("Are you want to create payment?") == true) {
                    insert("insert into Chi values(1,N'" + lbTime.getText() + "',N'" + cbPaymentCatalog.getValue() + "'," + tfPaymentPrice.getText() + ",N'" + taPaymentNote.getText() + "')");
                    clearPayment();
                    showPaymentDB();
                    log("" + lbUser.getText() + " have create payment!");
                    showLogDB();
                    totalPayment();
                    createChart();
                    alertSuccess("Create Successfully!");
                }
            }
        }
        if (event.getSource() == btnPaymentUpdate) {
            if (cbPaymentCatalog.getValue() == null) {
                alert("Please fill Payment catalogies");
            } else if (!Pattern.matches("\\d{1,}", tfPaymentPrice.getText())) {
                alert("Please fill Price of Payment");
            } else {
                if (alertConFirm("Are you want to update Payment?") == true) {
                    PaymentDB i = tvPayment.getSelectionModel().getSelectedItem();
                    update("update Chi set chiCatalog=N'" + cbPaymentCatalog.getValue() + "', chiPrice=" + tfPaymentPrice.getText() + ", chiNote=N'" + taPaymentNote.getText() + "' where chiID=" + i.getChiID() + "");
                    if (i == null) {
                        alert("Please choose payment");
                    }
                    clearPayment();
                    showPaymentDB();
                    log("" + lbUser.getText() + " have update payment!");
                    showLogDB();
                    totalPayment();
                    createChart();
                    alertSuccess("Update Successfully!");
                }
            }
        }
        if (event.getSource() == tvReceipt) {
            selectReceipt();
        }
        if (event.getSource() == tvBookInfo) {
            selectBookInfo();
        }
        if (event.getSource() == tvPayment) {
            selectPayment();
        }
        if (event.getSource() == btnPaymentDelete) {
            if (alertConFirm("Are you want to delete payment?") == true) {
                PaymentDB i = tvPayment.getSelectionModel().getSelectedItem();
                delete("delete from Chi where chiID=" + i.getChiID() + "");
                if (i == null) {
                    alert("Please choose receipt");
                }
                clearPayment();
                showPaymentDB();
                log("" + lbUser.getText() + " have delete payment!");
                showLogDB();
                totalPayment();
                createChart();
                alertSuccess("Delete Successfully!");
            }
        }
        if (event.getSource() == btnChangePassword) {
            modalBoxChangePassword("/FXMLFile/StaffChangePassword.fxml", "Staff Change Password");
        }
        if (event.getSource() == btnDeleteBook) {
            BookInfo bi = tvBookInfo.getSelectionModel().getSelectedItem();
            if (textDialog("Confirm", "Reason", "" + lbUser.getText() + " have delete " + bi.getBookID() + " book for ") == true) {
                delete("delete from Book where bookID=N'" + bi.getBookID() + "'");
                lbBookTotal.setText(null);
                showBookInfoDB();
                showLogDB();
                alertSuccess("Delete Successfully!");
                bookCount();
            }
        }
        if (event.getSource() == btnUpdateBook) {
            if (alertConFirm("Are you want to update book info?") == true) {
                update("update Book set bookDate=N'" + dpBookDate.getValue() + "',bookTime=N'" + snBookTime.getValue() + "',bookCatalogies=N'" + cbBookCatalogies.getValue() + "',bookNote=N'" + taBookNote.getText() + "' where bookID=N'" + lbBookID.getText() + "' and bookCustomerName=N'" + tfBookCusName.getText() + "'");
                lbBookTotal.setText(null);
                showBookInfoDB();
                showLogDB();
                log("" + lbUser.getText() + " have update Book Info!");
                alertSuccess("Update Successfully!");
            }
        }
        if (event.getSource() == btnInventoryAdd) {
            modalBoxAddProduct("/FXMLFile/AddProductScene.fxml", "Add Product");
        }
        if (event.getSource() == btnInventoryRemove) {
            modalBoxRemoveProduct("/FXMLFile/AddProductScene.fxml", "Remove Product");
        }
        if (event.getSource() == btnRefresh) {
            showPaymentDB();
            totalPayment();
            totalReceipt();
            showOrderMiniDB();
            showOrderMenuDB();
            showMenuDB();
            showInventoryDB();
            createChart();
            bookCount();
            showLogDB();
        }
        if (event.getSource() == tvMenu && event.getClickCount() == 2) {
            modalBoxMenuDetailForMenu("/FXMLFile/MenuDetailScene.fxml", "Menu Detail");
        }
        if (event.getSource() == tvOrderMenu && event.getClickCount() == 2) {
            modalBoxMenuDetailForOrderMenu("/FXMLFile/MenuDetailScene.fxml", "Menu Detail");
        }
        if (event.getSource() == btnDayReport) {
            if (checkDayReport() == true) {
                alert("Please Check out all table");
            } else {
                insert("insert into EOD values(1,'" + lbTime.getText() + "'," + lbTotalReceipt.getText() + "," + lbTotalPayment.getText() + ")");
                insert("insert into EODDetailThu(brandID,eodDetailThuID,eodDetailThuTime,eoddetailThuCatalog,eoddetailThuPrice,eoddetailThuNote) select 1,thuID,Thu.thuDate,Thu.thuCatalog,Thu.thuPrice,Thu.thuNote from Thu");
                insert("insert into EODDetailChi(brandID,eodDetailChiID,eodDetailChiTime,eoddetailChiCatalog,eoddetailChiPrice,eoddetailChiNote) select 1,chiID,Chi.chiDate,Chi.chiCatalog,Chi.chiPrice,Chi.chiNote from Chi");
                delete("delete from table Thu");
                delete("delete from table Chi");
                showReceiptDB();
                showPaymentDB();
                modalBoxEOD("/FXMLFile/EOD.fxml", "EOD");
            }
        }
        if (event.getSource() == btnShowReport) {
            modalBoxEOD("/FXMLFile/EOD.fxml", "EOD");
        }
        if (event.getSource() == btnEditBook) {
            modalBoxBookEdit("/FXMLFile/UpdateBook.fxml", "Update Book");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //phanQuyen();

        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "* *"),
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Text File", "*.txt")
        );
        cbStaffPossition.getItems().addAll(possition);
        cbAccountRole.getItems().addAll(role);

        cbInventoryCatalogies.getItems().addAll(productCatalogies);
        //snInventoryQOH.setValueFactory(productSpinner);
        cbDishCatalogies.getItems().addAll(dishCatalogies);
        cbDishStatus.getItems().addAll(dishStatus);
        cbCustomerGender.getItems().addAll(gender);
        cbOrderCatalogies.getItems().addAll(orderCatalogies);
        cbReceiptCatalog.getItems().addAll(receiptCatalogies);
        cbPaymentCatalog.getItems().addAll(paymentCatalogies);
        cbSendTable.getItems().addAll(orderCatalogies);
        lbOrderID.setText("" + count);
        tfStaffDOB.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });
        tfCustomerDOB.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });
        dpBookDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) < 0);
            }
        });
        tfStaffDOB.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        tfCustomerDOB.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        dpBookDate.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        cbBookCatalogies.getItems().addAll(bookCatalogies);
        snBookTime.setValueFactory(time);
        totalPayment();
        totalReceipt();
        showOrderMiniDB();
        showReceiptDB();
        showPaymentDB();
        bookCount();
        getTable();
        getIngredient();
        createChart();
        //getTakeAwayID();
        //showBillDB();
        Timenow();
        showLogDB();
        showStaffDB();
        showAccountDB();
        showCodeDB();
        showInventoryDB();
        showMenuDB();
        showCustomerDB();
        showOrderMenuDB();
        showOrderListDB();
        showBookInfoDB();
        orderList = FXCollections.observableArrayList();
    }

    public void setName(String name) {
        lbUser.setText(name);
    }

    public void setRole(String role) {
        lbStaffRole.setText(role);
    }

    private void modalBox(String fxmlFile, String Title) throws IOException {
        Stage stage = (Stage) bpStaff.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxChangePassword(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        StaffChangePasswordController userRole = loader.getController();
        userRole.setName(lbUser.getText());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxAddProduct(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        AddProductSceneController userRole = loader.getController();
        InventoryDB i = tvInventory.getSelectionModel().getSelectedItem();
        userRole.setName(i.getProductName());
        userRole.setStaff(lbUser.getText());
        userRole.setTitle("Add Product");
        userRole.btnProductRemove.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        if (i == null) {
            alert("Please choose Product to add");
        }
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxRemoveProduct(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        AddProductSceneController userRole = loader.getController();
        InventoryDB i = tvInventory.getSelectionModel().getSelectedItem();
        userRole.setName(i.getProductName());
        userRole.setStaff(lbUser.getText());
        userRole.setTitle("Remove product");
        userRole.btnProductAdd.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userRole.tfProductPrice.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userRole.lbPrice.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        SpinnerValueFactory<Integer> invetorySpiner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, i.getProductQOH(), 0, 1);
        userRole.snProductQOH.setValueFactory(invetorySpiner);
        userRole.lbMax.setText("" + i.getProductQOH());
        if (i == null) {
            alert("Please choose Product to remove");
        }
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxMenuDetailForMenu(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        MenuDetailSceneController userRole = loader.getController();
        MenuDB i = tvMenu.getSelectionModel().getSelectedItem();
        userRole.setName(i.getDishName());
        userRole.setPrice("" + i.getDishPrice());
        userRole.setDescription(i.getDishDescription());
        userRole.setImage(imgDish.getImage());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxMenuDetailForOrderMenu(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        MenuDetailSceneController userRole = loader.getController();
        OrderMenuDB i = tvOrderMenu.getSelectionModel().getSelectedItem();
        userRole.setName(i.getMenuDishName());
        userRole.setPrice("" + i.getMenuDishPrice());
        userRole.setDescription(i.getMenuDishDescription());
        userRole.setImage(imgOrderMenu.getImage());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxEOD(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void modalBoxBookEdit(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        UpdateBookController userRole = loader.getController();
        BookInfo i = tvBookInfo.getSelectionModel().getSelectedItem();
        userRole.setInfo("" + i.getBookID(), i.getBookCustomerName(), i.getBookCatalogies(), i.getBookNote(), i.getBookDate().toString(), i.getBookTime());
        userRole.showBookDetailDB(i.getBookCustomerName(), "" + i.getBookID());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final String[] possition = {"Manager", "Supervisor", "Waiter"};
    private static final String[] role = {"Manager", "Supervisor", "Waiter", "Customer"};
    private static final String[] productCatalogies = {"Ingredient"};
    private static final String[] dishCatalogies = {"Hors d'oeuvres", "Soup", "Fish Dish", "Meat Dish", "Main Course", "Salad", "Dessert", "Drink", "Other"};
    private static final String[] dishStatus = {"Available", "Unavailable"};
    private static final String[] gender = {"Male", "Female"};
    private static final String[] orderCatalogies = {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6", "Table 7", "Table 8", "Take-away"};
    private static final String[] receiptCatalogies = {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6", "Table 7", "Table 8", "Take-away", "Other"};
    private static final String[] paymentCatalogies = {"Other", "Salary", "Product"};
    private static final SpinnerValueFactory<Integer> productSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 1, 1);
    private static final AtomicInteger count = new AtomicInteger(100);
    private static final String[] bookCatalogies = {"Eat at Restaurant", "Take-away"};
    ObservableList<String> Time = FXCollections.observableArrayList("10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30");
    SpinnerValueFactory<String> time = new SpinnerValueFactory.ListSpinnerValueFactory<String>(Time);
    public static final Logger log = Logger.getLogger(StaffSceneController.class);

    public volatile boolean stop = false;

    private void insertInvoice() {
        Connection cn = getConnect();
        String sql = "insert into Invoice values(1,?,?,?,?,?)";
        for (BillDB ol : orderList) {
            try {
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, lbTime.getText());
                st.setString(2, ol.getBillDishName());
                st.setInt(3, ol.getBillDishPrice());
                st.setInt(4, ol.getBillDishQuantity());
                st.setInt(5, ol.getBillDishAmount());
                st.executeUpdate();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setInvoice() {
        Connection cn = getConnect();
        String sql = "insert into Invoice values(1,?,?,?,?,?)";
        for (BillDB ol : orderList) {
            try {
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, lbTime.getText());
                st.setString(2, ol.getBillDishName());
                st.setInt(3, ol.getBillDishPrice());
                st.setInt(4, ol.getBillDishQuantity());
                st.setInt(5, ol.getBillDishAmount());
                st.executeUpdate();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String sourceFile = "D:/Aptech/HK2/3. JP-2/3. JP-2/ProjectII/GithubPro/Javafx-Restaurant-Management-System/Main/src/report/Invoice.jrxml";
        try {
            JasperReport jr = JasperCompileManager.compileReport(sourceFile);
            HashMap<String, Object> para = new HashMap<>();
            para.put("Cashier", "smey");
            ArrayList<InvoiceDB> in = new ArrayList<>();
            for (BillDB bi : orderList) {
                in.add(new InvoiceDB(bi.getBillDishName(), "" + bi.getBillDishQuantity(), "" + bi.getBillDishPrice(), "" + bi.getBillDishAmount()));
            }
            JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(in);
            JasperPrint jp = JasperFillManager.fillReport(jr, para, jcs);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void notePad() throws IOException {
        Runtime rt = Runtime.getRuntime();
        String file = "D:/random.txt";
        Process p = rt.exec("notepad " + file);
    }

    public void showInvoice2() throws JRException {
        Connection con = getConnect();

        //PropertyConfigurator.configure(getClass().getResource("log4j.properties"));
        JasperDesign jasperDesign = JRXmlLoader.load("D:\\Aptech\\HK2\\3. JP-2\\3. JP-2\\ProjectII\\GithubPro\\Javafx-Restaurant-Management-System\\Main\\src\\report\\Invoice6.jrxml");
        //String query = "select dishName,dishPrice,dishQuantity, dishPrice*dishQuantity  as dishAmount from [Order];";
        //JRDesignQuery jrquery = new JRDesignQuery();
        //jrquery.setText(query);
        //jasperDesign.setQuery(jrquery);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
        JasperViewer viewer = new JasperViewer(JasperPrint, false);
        viewer.setTitle("Invoice");
        viewer.show();
    }

    private void showInvoice3() throws JRException {
        Connection con = getConnect();

        // Compile the report design
        JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Invoice6.jrxml");

// Fill the report with data
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);

// Preview the report
        JasperViewer.viewReport(jasperPrint, false);

// Print the report
        JasperPrintManager.printReport(jasperPrint, true);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");
    }

    private void log(String mess) {
        Logger.getLogger(StaffSceneController.class.getName()).info(mess);
    }

    private void validateOrder() {
        OrderMenuDB om = tvOrderMenu.getSelectionModel().getSelectedItem();
        if (om.getMenuDishAvailabe() < 1) {
            btnOrderMenuAdd.setDisable(true);
        } else {
            btnOrderMenuAdd.setDisable(false);
        }
    }

    private boolean alertConFirm(String mess) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mess, ButtonType.OK, ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        } else if (result.isPresent() && result.get() == ButtonType.CANCEL) {
            return false;
        }
        return false;
    }

    private void alert(String mess) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mess, ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.NONE, mess, ButtonType.OK);
        alert.setTitle("Notification!");
        Optional<ButtonType> result = alert.showAndWait();
    }

    private boolean textDialog(String title, String mess, String reason) {
        TextInputDialog textInput = new TextInputDialog();
        textInput.setTitle(title);
        textInput.getDialogPane().setContentText(mess);
        Optional<String> result = textInput.showAndWait();
        javafx.scene.control.TextField input = textInput.getEditor();

        final Button ok = (Button) textInput.getDialogPane().lookupButton(ButtonType.OK);
        ok.addEventFilter(ActionEvent.ACTION, event
                -> System.out.println("OK was definitely pressed")
        );

        final Button cancel = (Button) textInput.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancel.addEventFilter(ActionEvent.ACTION, event
                -> System.out.println("Cancel was definitely pressed")
        );

        if (input.getText() != null && input.getText().toString().length() != 0) {
            if (result.isPresent()) {
                Logger.getLogger(StaffSceneController.class.getName()).info(reason + input.getText());
                return true;
            } else {
                return false;
            }
        } else {
            alert("Please input reason!!");
            return false;
        }
    }

    private void Close_clicked(MouseEvent event) {
        stop = true;
        javafx.application.Platform.exit();
    }

    private void Timenow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {
                    lbTime.setText(timenow); // This is the label
                });
            }
        });
        thread.start();
    }

    private void updateBrowser(String anh, Label maID) {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = anh;

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
            fis = new FileInputStream(file);
            st.setBinaryStream(1, fis, file.length());
            st.setInt(2, Integer.valueOf(maID.getText()));
            file = null;
            //4 thuc hien insert sql
            st.executeUpdate();
            showMenuDB();
            showStaffDB();
            showCustomerDB();
            showInventoryDB();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnect() {
        Connection cn = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433;database=Project";
        String uid = "sa";
        String pwd = "123";
        try {
            //1. dang ky driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2 tao ket noi den co so du lieu
            cn = DriverManager.getConnection(url, uid, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    private void executeQuery(String sql) {
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert(String query) {
        String sql = query;
        executeQuery(sql);
    }

    private void update(String query) {
        String sql = query;
        executeQuery(sql);
    }

    private void delete(String query) {
        String sql = query;
        executeQuery(sql);
    }

    private void showImage(String query, Integer staffID, ImageView img) {
        String sql = query;
        java.sql.Connection cn = getConnect();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, staffID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream(1);
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] contents = new byte[1024];
                int size = 0;
                while ((size = is.read(contents)) != -1) {
                    os.write(contents, 0, size);
                }
                image = new Image("file:photo.jpg", img.getFitHeight(), img.getFitWidth(), true, true);
                img.setImage(image);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showImage(String query, String staffID, ImageView img) {
        String sql = query;
        java.sql.Connection cn = getConnect();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, staffID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream(1);
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] contents = new byte[1024];
                int size = 0;
                while ((size = is.read(contents)) != -1) {
                    os.write(contents, 0, size);
                }
                image = new Image("file:photo.jpg", img.getFitHeight(), img.getFitWidth(), true, true);
                img.setImage(image);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ObservableList<LogDB> getLogDB() {
        ObservableList<LogDB> LogList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select * from Logger";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            LogDB l = null;
            while (rs.next()) {
                l = new LogDB(rs.getInt("id"), rs.getString("datetime"), rs.getString("method_name"), rs.getString("level"), rs.getString("message"));
                LogList.add(l);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LogList;
    }

    public void showLogDB() {
        ObservableList<LogDB> list = getLogDB();
        colLoggerID.setCellValueFactory(new PropertyValueFactory<LogDB, Integer>("loggerID"));
        colLoggerDateTime.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerDateTime"));
        colLoggerMethod.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerMethod"));
        colLoggerLevel.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerLevel"));
        colLoggerMessage.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerMessage"));
        tvLogger.setItems(list);
    }

    public static ObservableList<StaffDB> getStaffDB() {
        ObservableList<StaffDB> StaffList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select staffID,staffName,staffDOB,staffAddress,staffPossition,staffPhone,staffMail,staffSalary,staffUserName from Staff";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            StaffDB s = null;
            while (rs.next()) {
                s = new StaffDB(rs.getInt("staffID"), rs.getString("staffName"), rs.getDate("staffDOB").toLocalDate(), rs.getString("staffAddress"), rs.getString("staffPossition"), rs.getString("staffPhone"), rs.getString("staffMail"), rs.getInt("staffSalary"), rs.getString("staffUserName"));
                StaffList.add(s);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StaffList;
    }

    public void showStaffDB() {
        ObservableList<StaffDB> list = getStaffDB();
        colStaffID.setCellValueFactory(new PropertyValueFactory<StaffDB, Integer>("staffID"));
        colStaffName.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffName"));
        colStaffDOB.setCellValueFactory(new PropertyValueFactory<StaffDB, Date>("staffDOB"));
        colStaffAddress.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffAddress"));
        colStaffPossition.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffPossition"));
        colStaffPhone.setCellValueFactory(new PropertyValueFactory<StaffDB, Integer>("staffPhone"));
        colStaffMail.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffMail"));
        colStaffSalary.setCellValueFactory(new PropertyValueFactory<StaffDB, Integer>("staffSalary"));
        colStaffUserName.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffUserName"));
        tvStaff.setItems(list);
    }

    private void selectStaff() {
        StaffDB s = tvStaff.getSelectionModel().getSelectedItem();
        if (s != null) {
            lbStaffID.setText("" + s.getStaffID());
            tfStaffName.setText(s.getStaffName());
            tfStaffDOB.setValue(s.getStaffDOB());
            tfStaffAddress.setText(s.getStaffAddress());
            cbStaffPossition.setValue(s.getStaffPossition());
            tfStaffPhone.setText("" + s.getStaffPhone());
            tfStaffMail.setText(s.getStaffMail());
            tfStaffSalary.setText("" + s.getStaffSalary());
            tfStaffUsername.setText(s.getStaffUserName());
            showImage("select staffImage from Staff where staffID=?", s.getStaffID(), imgStaffImage);
        }
    }

    private void clearStaff() {
        lbStaffID.setText("");
        tfStaffName.clear();
        tfStaffDOB.setValue(null);
        tfStaffAddress.clear();
        cbStaffPossition.setValue(null);
        tfStaffPhone.clear();
        tfStaffMail.clear();
        tfStaffSalary.clear();
        tfStaffUsername.clear();
        imgStaffImage.setImage(null);
    }

    private void insertStaff() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Staff VALUES (1,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
            st.setString(1, tfStaffName.getText());
            st.setDate(2, java.sql.Date.valueOf(tfStaffDOB.getValue()));
            st.setString(3, tfStaffAddress.getText());
            st.setString(4, cbStaffPossition.getValue());
            st.setInt(5, Integer.valueOf(tfStaffPhone.getText()));
            st.setString(6, tfStaffMail.getText());
            st.setInt(7, Integer.valueOf(tfStaffSalary.getText()));
            st.setString(8, tfStaffUsername.getText());
            fis = new FileInputStream(file);
            st.setBinaryStream(9, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showStaffDB();
            file = null;
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateStaff() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "UPDATE Staff set staffName=?,staffDOB=?,staffAddress=?,staffPossition=?,staffPhone=?,staffMail=?,staffSalary=?,staffUserName=? where staffID=?";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfStaffName.getText());
            st.setDate(2, java.sql.Date.valueOf(tfStaffDOB.getValue()));
            st.setString(3, tfStaffAddress.getText());
            st.setString(4, cbStaffPossition.getValue());
            st.setInt(5, Integer.valueOf(tfStaffPhone.getText()));
            st.setString(6, tfStaffMail.getText());
            st.setInt(7, Integer.valueOf(tfStaffSalary.getText()));
            st.setString(8, tfStaffUsername.getText());
            st.setInt(9, Integer.valueOf(lbStaffID.getText()));
            if (file != null) {
                updateBrowser("UPDATE Staff set staffImage=? where staffID=?", lbStaffID);
            }
            file = null;
            st.executeUpdate();
            showStaffDB();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteStaff() {
        String sql = "delete from Staff where staffID=" + Integer.valueOf(lbStaffID.getText()) + "";
        executeQuery(sql);
        showStaffDB();
    }

    public static ObservableList<AccountDB> getAccountDB() {
        ObservableList<AccountDB> accountList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select accountID, accountUserName,accountPassWord,accountRole from Account";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            AccountDB a = null;
            while (rs.next()) {
                a = new AccountDB(rs.getInt("accountID"), rs.getString("accountUserName"), rs.getString("accountPassWord"), rs.getString("accountRole"));
                accountList.add(a);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public void showAccountDB() {
        ObservableList<AccountDB> list = getAccountDB();
        colAccountID.setCellValueFactory(new PropertyValueFactory<AccountDB, Integer>("accountID"));
        colAccountUsername.setCellValueFactory(new PropertyValueFactory<AccountDB, String>("accountUserName"));
        colAccountPassword.setCellValueFactory(new PropertyValueFactory<AccountDB, String>("accountPassWord"));
        colAccountRole.setCellValueFactory(new PropertyValueFactory<AccountDB, String>("accountRole"));
        tvAccount.setItems(list);
    }

    private void selectAccount() {
        AccountDB a = tvAccount.getSelectionModel().getSelectedItem();
        if (a != null) {
            lbAccountID.setText("" + a.getAccountID());
            tfAccountUsername.setText(a.getAccountUserName());
            tfAccountPassword.setText(a.getAccountPassWord());
            cbAccountRole.setValue(a.getAccountRole());
        }
    }

    private void clearAccount() {
        lbAccountID.setText("");
        tfAccountUsername.clear();
        tfAccountPassword.clear();
        cbAccountRole.setValue(null);
    }

    private void lastCode() {
        String sql = "select codeQuantity from codeDiscount where codeValue='" + tfBillDiscount.getText() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int codeQty = rs.getInt("codeQuantity");
                if (codeQty == 1) {
                    delete("delete from codeDiscount where codeValue='" + tfBillDiscount.getText() + "'");
                    log(""+tfBillDiscount.getText()+"has been expires");
                }
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<CodeDB> getCodeDB() {
        ObservableList<CodeDB> codeList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select codeID, codeValue,codeQuantity,discountPercent from codeDiscount";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            CodeDB c = null;
            while (rs.next()) {
                int codeqty = rs.getInt("codeQuantity");
                c = new CodeDB(rs.getInt("codeID"), rs.getString("codeValue"), rs.getInt("codeQuantity"), rs.getInt("discountPercent"));
                codeList.add(c);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codeList;
    }

    public void showCodeDB() {
        ObservableList<CodeDB> list = getCodeDB();
        colCodeID.setCellValueFactory(new PropertyValueFactory<CodeDB, Integer>("codeID"));
        colCodeValue.setCellValueFactory(new PropertyValueFactory<CodeDB, String>("codeValue"));
        colCodeQuantity.setCellValueFactory(new PropertyValueFactory<CodeDB, Integer>("codeQuantity"));
//        colAccountRole.setCellValueFactory(new PropertyValueFactory<AccountDB, String>("accountRole"));
        colCodeDiscountPercent.setCellValueFactory(new PropertyValueFactory<CodeDB, Integer>("discountPercent"));
        tvCodeDiscount.setItems(list);
    }

    private void selectCode() {
        CodeDB c = tvCodeDiscount.getSelectionModel().getSelectedItem();
        if (c != null) {
            lbCodeID.setText("" + c.getCodeID());
            tfCodeValue.setText(c.getCodeValue());
            tfCodeQuantity.setText("" + c.getCodeQuantity());
            tfCodeDiscountPercent.setText("" + c.getDiscountPercent());
        }
    }

    private void clearCode() {
        lbCodeID.setText("");
        tfCodeValue.clear();
        tfCodeQuantity.clear();
        tfCodeDiscountPercent.clear();
    }

    public static ObservableList<InventoryDB> getInventoryDB() {
        ObservableList<InventoryDB> inventoryList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select productID, productName,productQOH,productUnit,productPrice,productCatalogies from Inventory";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            InventoryDB i = null;
            while (rs.next()) {
                i = new InventoryDB(rs.getInt("productID"), rs.getString("productName"), rs.getInt("productQOH"), rs.getString("productUnit"), rs.getInt("productPrice"), rs.getString("productCatalogies"));
                inventoryList.add(i);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    public void showInventoryDB() {
        ObservableList<InventoryDB> list = getInventoryDB();
        colInventoryID.setCellValueFactory(new PropertyValueFactory<InventoryDB, Integer>("productID"));
        colInventoryName.setCellValueFactory(new PropertyValueFactory<InventoryDB, String>("productName"));
        colInventoryQOH.setCellValueFactory(new PropertyValueFactory<InventoryDB, Integer>("productQOH"));
        colInventoryUnit.setCellValueFactory(new PropertyValueFactory<InventoryDB, String>("productUnit"));
        colInventoryPrice.setCellValueFactory(new PropertyValueFactory<InventoryDB, Integer>("productPrice"));
        colInventoryCatalogies.setCellValueFactory(new PropertyValueFactory<InventoryDB, String>("productCatalogies"));
        tvInventory.setItems(list);
    }

    private void selectInventory() {
        InventoryDB i = tvInventory.getSelectionModel().getSelectedItem();
        if (i != null) {
            lbInventoryID.setText("" + i.getProductID());
            tfInventoryName.setText(i.getProductName());
            //snInventoryQOH.getValueFactory().setValue(i.getProductQOH());
            tfInventoryUnit.setText(i.getProductUnit());
            //tfInventoryPrice.setText("" + i.getProductPrice());
            cbInventoryCatalogies.setValue(i.getProductCatalogies());
            showImage("select productImage from Inventory where productID=?", i.getProductID(), imgInventory);
        }
    }

    private void clearInventory() {
        lbInventoryID.setText("");
        tfInventoryName.clear();
        //snInventoryQOH.getValueFactory().setValue(1);
        tfInventoryUnit.clear();
        //tfInventoryPrice.clear();
        cbInventoryCatalogies.setValue(null);
        imgInventory.setImage(null);
    }

    private void insertInventory() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Inventory VALUES (1,?,0,?,0,?,?)";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfInventoryName.getText());
            //st.setInt(2, snInventoryQOH.getValue());
            st.setString(2, tfInventoryUnit.getText());
            //st.setInt(4, Integer.valueOf(tfInventoryPrice.getText()));
            st.setString(3, cbInventoryCatalogies.getValue());
            fis = new FileInputStream(file);
            st.setBinaryStream(4, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showInventoryDB();
            file = null;
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateInventory() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "UPDATE Inventory set productName=?,productUnit=?,productCatalogies=? where productID=?";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfInventoryName.getText());
            //st.setInt(2, snInventoryQOH.getValue());
            st.setString(2, tfInventoryUnit.getText());
            //st.setInt(4, Integer.valueOf(tfInventoryPrice.getText()));
            st.setString(3, cbInventoryCatalogies.getValue());
            st.setInt(4, Integer.valueOf(lbInventoryID.getText()));
            //4 thuc hien insert sql
            if (file != null) {
                updateBrowser("UPDATE Inventory set productImage=? where productID=?", lbInventoryID);
            }
            file = null;
            st.executeUpdate();
            showInventoryDB();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteInventory() {
        String sql = "delete from Inventory where productID=" + Integer.valueOf(lbInventoryID.getText()) + "";
        executeQuery(sql);
        showInventoryDB();
    }

    public static ObservableList<MenuDB> getMenuDB() {
        ObservableList<MenuDB> menuList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select dishID, dishName,dishPrice,dishIngredient,dishConsume,dishCatalogies,dishStatus,dishDescription from Menu";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            MenuDB m = null;
            while (rs.next()) {
                m = new MenuDB(rs.getInt("dishID"), rs.getString("dishName"), rs.getInt("dishPrice"), rs.getString("dishIngredient"), rs.getInt("dishConsume"), rs.getString("dishCatalogies"), rs.getString("dishStatus"), rs.getString("dishDescription"));
                menuList.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    public void showMenuDB() {
        ObservableList<MenuDB> list = getMenuDB();
        colDishID.setCellValueFactory(new PropertyValueFactory<MenuDB, Integer>("dishID"));
        colDishName.setCellValueFactory(new PropertyValueFactory<MenuDB, String>("dishName"));
        colDishPrice.setCellValueFactory(new PropertyValueFactory<MenuDB, Integer>("dishPrice"));
        colDishIngredient.setCellValueFactory(new PropertyValueFactory<MenuDB, String>("dishIngredient"));
        colDishConsume.setCellValueFactory(new PropertyValueFactory<MenuDB, Integer>("dishConsume"));
        colDishCatalogies.setCellValueFactory(new PropertyValueFactory<MenuDB, String>("dishCatalogies"));
        colDishStatus.setCellValueFactory(new PropertyValueFactory<MenuDB, String>("dishStatus"));
        colDishDescription.setCellValueFactory(new PropertyValueFactory<MenuDB, String>("dishDescription"));
        tvMenu.setItems(list);
    }

    private void selectMenu() {
        MenuDB m = tvMenu.getSelectionModel().getSelectedItem();
        if (m != null) {
            lbDishID.setText("" + m.getDishID());
            tfDishName.setText(m.getDishName());
            tfDishPrice.setText("" + m.getDishPrice());
            cbDishIngredient.setValue(m.getDishIngredient());
            tfDishConsume.setText("" + m.getDishConsume());
            cbDishCatalogies.setValue(m.getDishCatalogies());
            cbDishStatus.setValue(m.getDishStatus());
            taDishDesciption.setText(m.getDishDescription());
            showImage("select dishImage from Menu where dishID=?", m.getDishID(), imgDish);
        }
    }

    private void clearMenu() {
        lbDishID.setText("");
        tfDishName.clear();
        tfDishPrice.clear();
        cbDishIngredient.setValue(null);
        tfDishConsume.clear();
        cbDishCatalogies.setValue(null);
        cbDishStatus.setValue(null);
        taDishDesciption.clear();
        imgDish.setImage(null);
    }

    private void insertMenu() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Menu VALUES (1,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfDishName.getText());
            st.setInt(2, Integer.valueOf(tfDishPrice.getText()));
            st.setString(3, cbDishIngredient.getValue());
            st.setInt(4, Integer.valueOf(tfDishConsume.getText()));
            st.setString(5, cbDishCatalogies.getValue());
            st.setString(6, cbDishStatus.getValue());
            st.setString(7, taDishDesciption.getText());
            fis = new FileInputStream(file);
            st.setBinaryStream(8, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showMenuDB();
            file = null;
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateMenu() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "UPDATE Menu set dishName=?,dishPrice=?,dishIngredient=?,dishConsume=?,dishCatalogies=?,dishStatus=?,dishDescription=? where dishID=?";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfDishName.getText());
            st.setInt(2, Integer.valueOf(tfDishPrice.getText()));
            st.setString(3, cbDishIngredient.getValue());
            st.setInt(4, Integer.valueOf(tfDishConsume.getText()));
            st.setString(5, cbDishCatalogies.getValue());
            st.setString(6, cbDishStatus.getValue());
            st.setString(7, taDishDesciption.getText());
            st.setInt(8, Integer.valueOf(lbDishID.getText()));
            if (file != null) {
                updateBrowser("UPDATE Menu set dishImage=? where dishID=?", lbDishID);
            }
            file = null;
            //4 thuc hien insert sql
            st.executeUpdate();
            showMenuDB();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteMenu() {
        String sql = "delete from Menu where dishID=" + Integer.valueOf(lbDishID.getText()) + "";
        executeQuery(sql);
        showMenuDB();
    }

    public static ObservableList<CustomerDB> getCustomerDB() {
        ObservableList<CustomerDB> cusList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select customerID, customerName,customerDOB,customerAddress,customerPhone,customerMail,customerGender,customerUserName from Customer";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            CustomerDB c = null;
            while (rs.next()) {
                c = new CustomerDB(rs.getInt("customerID"), rs.getString("customerName"), rs.getDate("customerDOB").toLocalDate(), rs.getString("customerAddress"), rs.getString("customerPhone"), rs.getString("customerMail"), rs.getString("customerGender"), rs.getString("customerUserName"));
                cusList.add(c);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cusList;
    }

    public void showCustomerDB() {
        ObservableList<CustomerDB> list = getCustomerDB();
        colCustomerID.setCellValueFactory(new PropertyValueFactory<CustomerDB, Integer>("customerID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("customerName"));
        colCustomerDOB.setCellValueFactory(new PropertyValueFactory<CustomerDB, LocalDate>("customerDOB"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("customerAddress"));
        colCustomerPhone.setCellValueFactory(new PropertyValueFactory<CustomerDB, Integer>("customerPhone"));
        colCustomerMail.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("customerMail"));
        colCustomerGender.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("customerGender"));
        colCustomerUserName.setCellValueFactory(new PropertyValueFactory<CustomerDB, String>("customerUserName"));
        tvCustomer.setItems(list);
    }

    private void selectCustomer() {
        CustomerDB c = tvCustomer.getSelectionModel().getSelectedItem();
        if (c != null) {
            lbCustomerID.setText("" + c.getCustomerID());
            tfCustomerName.setText(c.getCustomerName());
            tfCustomerDOB.setValue(c.getCustomerDOB());
            tfCustomerAddress.setText(c.getCustomerAddress());
            tfCustomerPhone.setText("" + c.getCustomerPhone());
            tfCustomerMail.setText(c.getCustomerMail());
            cbCustomerGender.setValue(c.getCustomerGender());
            tfCustomerUserName.setText(c.getCustomerUserName());
            showImage("select customerImage from Customer where customerID=?", c.getCustomerID(), imgCustomer);
        }
    }

    private void clearCustomer() {
        lbCustomerID.setText("");
        tfCustomerName.clear();
        tfCustomerDOB.setValue(null);
        tfCustomerAddress.clear();
        tfCustomerPhone.clear();
        tfCustomerMail.clear();
        cbCustomerGender.setValue(null);
        tfCustomerUserName.clear();
        imgCustomer.setImage(null);
    }

    private void insertCustomer() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
            st.setString(1, tfCustomerName.getText());
            st.setDate(2, java.sql.Date.valueOf(tfCustomerDOB.getValue()));
            st.setString(3, tfCustomerAddress.getText());
            st.setInt(4, Integer.valueOf(tfCustomerPhone.getText()));
            st.setString(5, tfCustomerMail.getText());
            st.setString(6, cbCustomerGender.getValue());
            st.setString(7, tfCustomerUserName.getText());
            fis = new FileInputStream(file);
            st.setBinaryStream(8, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showCustomerDB();
            file = null;
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateCustomer() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "UPDATE Customer set customerName=?,customerDOB=?,customerAddress=?,customerPhone=?,customerMail=?,customerGender=?,customerUserName=? where customerID=?";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfCustomerName.getText());
            st.setDate(2, java.sql.Date.valueOf(tfCustomerDOB.getValue()));
            st.setString(3, tfCustomerAddress.getText());
            st.setInt(4, Integer.valueOf(tfCustomerPhone.getText()));
            st.setString(5, tfCustomerMail.getText());
            st.setString(6, cbCustomerGender.getValue());
            st.setString(7, tfCustomerUserName.getText());
            st.setInt(8, Integer.valueOf(lbCustomerID.getText()));
            //4 thuc hien insert sql
            if (file != null) {
                updateBrowser("UPDATE Customer set customerImage=? where customerID=?", lbCustomerID);
            }
            file = null;
            st.executeUpdate();
            showCustomerDB();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteCustomer() {
        String sql = "delete from Customer where customerID=" + Integer.valueOf(lbCustomerID.getText()) + "";
        executeQuery(sql);
        showCustomerDB();
    }

    public static ObservableList<OrderMenuDB> getOrderMenuDB() {
        ObservableList<OrderMenuDB> orderMenuList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select a.dishName,a.dishPrice,floor(b.productQOH/a.dishConsume) as dishAvailable,a.dishDescription from Menu a join Inventory b on productName =dishIngredient where a.dishStatus='Available'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            OrderMenuDB om = null;
            while (rs.next()) {
                om = new OrderMenuDB(rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishAvailable"), rs.getString("dishDescription"));
                orderMenuList.add(om);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderMenuList;
    }

    public void showOrderMenuDB() {
        ObservableList<OrderMenuDB> list = getOrderMenuDB();
        colOrderMenuDishName.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishName"));
        colOrderMenuDishPrice.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishPrice"));
        colOrderMenuDishAvailable.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishAvailabe"));
        colOrderMenuDishDescription.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishDescription"));
        tvOrderMenu.setItems(list);
    }

    public static ObservableList<OrderMenuDB> getOrderMenuDB(String Catalogies) {
        ObservableList<OrderMenuDB> orderMenuList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select a.dishName,a.dishPrice,floor(b.productQOH/a.dishConsume) as dishAvailable,a.dishDescription from Menu a join Inventory b on productName =dishIngredient where a.dishStatus='Available' and a.dishCatalogies=N'" + Catalogies + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            OrderMenuDB om = null;
            while (rs.next()) {
                om = new OrderMenuDB(rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishAvailable"), rs.getString("dishDescription"));
                orderMenuList.add(om);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderMenuList;
    }

    public void showOrderMenuByCatalogiesDB(String Catalogies) {
        ObservableList<OrderMenuDB> list = getOrderMenuDB(Catalogies);
        colOrderMenuDishName.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishName"));
        colOrderMenuDishPrice.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishPrice"));
        colOrderMenuDishAvailable.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishAvailabe"));
        colOrderMenuDishDescription.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishDescription"));
        tvOrderMenu.setItems(list);
    }

    private void selectOrderMenu() {
        OrderMenuDB o = tvOrderMenu.getSelectionModel().getSelectedItem();
        if (o != null) {
            lbOrderDishName.setText(o.getMenuDishName());
            taOrderDishDescription.setText(o.getMenuDishDescription());
            showImage("select dishImage from Menu where dishName=?", o.getMenuDishName(), imgOrderMenu);
        }
    }

    private void addToOderList() {
        OrderMenuDB o = tvOrderMenu.getSelectionModel().getSelectedItem();
        String sql = "select * from [OrderMini] where dishName=N'" + o.getMenuDishName() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String sqlUpdate = "update [OrderMini] set dishQuantity+=" + snOrderDishQuantity.getValue() + " where dishName=N'" + o.getMenuDishName() + "'";
                executeQuery(sqlUpdate);
            } else {
                String sqInsert = "insert into [OrderMini] values (1,N'" + o.getMenuDishName() + "'," + o.getMenuDishPrice() + "," + snOrderDishQuantity.getValue() + ")";
                executeQuery(sqInsert);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<OrderListMini> getOrderMiniDB() {
        ObservableList<OrderListMini> OrderMiniList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select dishName,dishPrice,dishQuantity from [OrderMini]";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            OrderListMini m = null;
            while (rs.next()) {

                m = new OrderListMini(rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishQuantity"));
                OrderMiniList.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderMiniList;
    }

    public void showOrderMiniDB() {
        ObservableList<OrderListMini> list = getOrderMiniDB();
        lbOrderID.setVisible(true);
        colOrderListMiniDishName.setCellValueFactory(new PropertyValueFactory<OrderListMini, String>("orderMiniName"));
        colOrderListMiniDishPrice.setCellValueFactory(new PropertyValueFactory<OrderListMini, Integer>("orderMiniPrice"));
        colOrderListMiniDishQuantity.setCellValueFactory(new PropertyValueFactory<OrderListMini, Integer>("orderMiniQuantity"));
        tvOderListMini.setItems(list);
    }

    public ObservableList<OrderList> getOrderListDB() {
        ObservableList<OrderList> orderList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select orderID,orderTime,dishName,dishPrice,dishQuantity,dishCatalogies,orderNote from [Order]";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            OrderList m = null;
            while (rs.next()) {

                m = new OrderList(rs.getInt("orderID"), rs.getString("orderTime"), rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishQuantity"), rs.getString("dishCatalogies"), rs.getString("orderNote"));
                orderList.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void showOrderListDB() {
        ObservableList<OrderList> list = getOrderListDB();
        lbOrderID.setVisible(true);
        colOrderID.setCellValueFactory(new PropertyValueFactory<OrderList, Integer>("orderID"));
        colOrderTime.setCellValueFactory(new PropertyValueFactory<OrderList, String>("orderTime"));
        colOrderName.setCellValueFactory(new PropertyValueFactory<OrderList, String>("orderName"));
        colOrderQuantity.setCellValueFactory(new PropertyValueFactory<OrderList, Integer>("orderQuantity"));
        colOrderCatalogies.setCellValueFactory(new PropertyValueFactory<OrderList, String>("orderCatalogies"));
        colOrderNote.setCellValueFactory(new PropertyValueFactory<OrderList, String>("orderNote"));
        colOrderCheck.setCellFactory(tc -> new CheckBoxTableCell<>());
        tvOderList.setItems(list);
    }

    public ObservableList<String> getTable() {
        ObservableList<String> TableList = FXCollections.observableArrayList();
        Connection cn = getConnect();
        String sql = "select distinct dishCatalogies from [Order]";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
//            BillDB b = null;
            while (rs.next()) {
                String table = rs.getString("dishCatalogies");
                TableList.add(table);
                cbBillTable.setItems(TableList);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableList;
    }

    public ObservableList<InputStream> getImage() {
        ObservableList<InputStream> ImageList = FXCollections.observableArrayList();
        Connection cn = getConnect();
        String sql = "select dishImage from [Menu] where dishID=" + lbDishID.getText() + "";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
//            BillDB b = null;
            while (rs.next()) {
                InputStream table = rs.getBinaryStream("dishCatalogies");
                ImageList.add(table);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ImageList;
    }

//    public ObservableList<Integer> getTakeAwayID() {
//        ObservableList<Integer> TableList = FXCollections.observableArrayList();
//        Connection cn = getConnect();
//        String sql = "select distinct orderID from [Order]";
//        Statement st;
//        ResultSet rs;
//        try {
//            st = cn.createStatement();
//            rs = st.executeQuery(sql);
////            BillDB b = null;
//            while (rs.next()) {
//                int table = rs.getInt("orderID");
//                TableList.add(table);
//                cbBillTakeAway.setItems(TableList);
//            }
//            cn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return TableList;
//    }
    public ObservableList<BillDB> getBillDB() {
        ObservableList<BillDB> billList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select dishName,dishPrice,dishQuantity, dishPrice*dishQuantity  as dishAmount from [Order] where dishCatalogies=N'" + cbBillTable.getValue() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            BillDB b = null;
            while (rs.next()) {
                b = new BillDB(rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishQuantity"), rs.getInt("dishAmount"));
                billList.add(b);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billList;
    }

    public void showBillDB() {
        ObservableList<BillDB> list = getBillDB();
        colBillDishName.setCellValueFactory(new PropertyValueFactory<BillDB, String>("billDishName"));
        colBillDishQuantity.setCellValueFactory(new PropertyValueFactory<BillDB, Integer>("billDishQuantity"));
        colBillDishPrice.setCellValueFactory(new PropertyValueFactory<BillDB, Integer>("billDishPrice"));
        colBillDishAmount.setCellValueFactory(new PropertyValueFactory<BillDB, Integer>("billDishAmount"));
        tvBill.setItems(list);
    }

    private void clearBill() {
        cbBillTable.setValue(null);
        tfBillDiscount.clear();
        lbBillDiscount.setText(null);
        lbBillTotal.setText(null);
        lbBillAfter.setText(null);
    }

    private void totalBill() {
        String sql1 = "select SUM(dishPrice* dishQuantity) as billTotal from [Order] where dishCatalogies=N'" + cbBillTable.getValue() + "'";
        String sql2 = "select discountPercent from codeDiscount where codeValue=N'" + tfBillDiscount.getText() + "'";
        Connection cn = getConnect();
        Statement st1;
        Statement st2;
        try {
            st1 = cn.createStatement();
            st2 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            ResultSet rs2 = st2.executeQuery(sql2);
            if (Pattern.matches("\\w{1,}", tfBillDiscount.getText())) {
                if (rs2.next() && rs1.next()) {
                    int totalBill = rs1.getInt("billTotal");
                    int discountTotal = rs2.getInt("discountPercent");
                    int afterTotal = totalBill - (totalBill * discountTotal / 100);
                    lbBillDiscount.setText("" + discountTotal);
                    lbBillTotal.setText("" + totalBill);
                    lbBillAfter.setText("" + afterTotal);
                } else if (rs1.next() && !rs2.next()) {
                    alert("Invalid discount code");
                    int totalBill = rs1.getInt("billTotal");
                    lbBillTotal.setText("" + totalBill);
                    lbBillDiscount.setText("0");
                    lbBillAfter.setText("" + totalBill);
                }
            } else {
                if (rs1.next()) {
                    int totalBill = rs1.getInt("billTotal");
                    lbBillTotal.setText("" + totalBill);
                    lbBillDiscount.setText("0");
                    lbBillAfter.setText("" + totalBill);
                }
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDiscount() {
        String sql = "select discountPercent from codeDiscount where codeValue=N'" + tfBillDiscount.getText() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                update("update codeDiscount set codeQuantity -=1 where codeValue=N'" + tfBillDiscount.getText() + "'");
                int discountTotal = rs.getInt("discountPercent");
                lbBillDiscount.setText("" + discountTotal);
            } else {
                alert("Invalid discount code");
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<BookInfo> getBookInfoDB() {
        ObservableList<BookInfo> bookInfo = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select distinct bookID,bookDate,bookTime,bookCustomerName,bookCatalogies,bookNote from Book";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            BookInfo bi = null;
            while (rs.next()) {

                bi = new BookInfo(rs.getInt("bookID"), rs.getDate("bookDate").toLocalDate(), rs.getString("bookTime"), rs.getString("bookCustomerName"), rs.getString("bookCatalogies"), rs.getString("bookNote"));
                bookInfo.add(bi);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfo;
    }

    public void showBookInfoDB() {
        ObservableList<BookInfo> list = getBookInfoDB();
        colBookInfoID.setCellValueFactory(new PropertyValueFactory<BookInfo, Integer>("bookID"));
        colBookInfoDate.setCellValueFactory(new PropertyValueFactory<BookInfo, LocalDate>("bookDate"));
        colBookInfoTime.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("bookTime"));
        colBookInfoCusName.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("bookCustomerName"));
        colBookInfoCatalogies.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("bookCatalogies"));
        colBookInfoNote.setCellValueFactory(new PropertyValueFactory<BookInfo, String>("bookNote"));
        tvBookInfo.setItems(list);
    }

    private void selectBookInfo() {
        BookInfo o = tvBookInfo.getSelectionModel().getSelectedItem();
        if (o != null) {
            lbBookID.setText("" + o.getBookID());
            dpBookDate.setValue(o.getBookDate());
            snBookTime.getValueFactory().setValue(o.getBookTime());
            tfBookCusName.setText(o.getBookCustomerName());
            cbBookCatalogies.setValue(o.getBookCatalogies());
            taBookNote.setText(o.getBookNote());
        }
    }

    public static ObservableList<BookDetail> getBookDetailDB(String ma, Integer id) {
        ObservableList<BookDetail> bookDetail = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select bookDishName,bookDishQuantity,bookDishPrice from Book where bookCustomerName='" + ma + "' and bookID=" + id + "";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            BookDetail m = null;
            while (rs.next()) {

                m = new BookDetail(rs.getString("bookDishName"), rs.getInt("bookDishQuantity"), rs.getInt("bookDishPrice"));
                bookDetail.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookDetail;
    }

    public void showBookDetailDB(String ma, Integer id) {
        ObservableList<BookDetail> list = getBookDetailDB(ma, id);
        colBookDetailName.setCellValueFactory(new PropertyValueFactory<BookDetail, String>("bookDishName"));
        colBookDetailQuantity.setCellValueFactory(new PropertyValueFactory<BookDetail, Integer>("bookDishQuantity"));
        colBookDetailPrice.setCellValueFactory(new PropertyValueFactory<BookDetail, Integer>("bookDishPrice"));
        tvBookDetail.setItems(list);
    }

    private void bookCount() {
        String sql = "select COUNT(distinct bookCustomerName) as bookCount from Book";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int bookCount = rs.getInt("bookCount");
                lbBookCount.setText("" + bookCount);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void totalBook() {
        BookInfo bi = tvBookInfo.getSelectionModel().getSelectedItem();
        String sql = "select SUM(bookDishQuantity* bookDishPrice) as bookTotal from Book where bookID=" + bi.getBookID() + " and bookCustomerName='" + bi.getBookCustomerName() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int totalBill = rs.getInt("bookTotal");
                lbBookTotal.setText("" + totalBill);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<ReceiptDB> getReceiptDB() {
        ObservableList<ReceiptDB> receipt = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select thuID,thuDate,thuCatalog,thuPrice,thuNote from Thu";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            ReceiptDB r = null;
            while (rs.next()) {
                r = new ReceiptDB(rs.getInt("thuID"), rs.getDate("thuDate").toLocalDate(), rs.getString("thuCatalog"), rs.getInt("thuPrice"), rs.getString("thuNote"));
                receipt.add(r);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receipt;
    }

    public void showReceiptDB() {
        ObservableList<ReceiptDB> list = getReceiptDB();
        colReceiptID.setCellValueFactory(new PropertyValueFactory<ReceiptDB, Integer>("thuID"));
        colReceiptTime.setCellValueFactory(new PropertyValueFactory<ReceiptDB, String>("thuDate"));
        colReceiptCatalog.setCellValueFactory(new PropertyValueFactory<ReceiptDB, String>("thuCatalog"));
        colReceiptPrice.setCellValueFactory(new PropertyValueFactory<ReceiptDB, Integer>("thuPrice"));
        colReceiptNote.setCellValueFactory(new PropertyValueFactory<ReceiptDB, String>("thuNote"));
        tvReceipt.setItems(list);
    }

    public ObservableList<PaymentDB> getPaymentDB() {
        ObservableList<PaymentDB> payment = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select chiID,chiDate,chiCatalog,chiPrice,chiNote from Chi";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            PaymentDB p = null;
            while (rs.next()) {
                p = new PaymentDB(rs.getInt("chiID"), rs.getDate("chiDate").toLocalDate(), rs.getString("chiCatalog"), rs.getInt("chiPrice"), rs.getString("chiNote"));
                payment.add(p);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;
    }

    public void showPaymentDB() {
        ObservableList<PaymentDB> list = getPaymentDB();
        colPaymentID.setCellValueFactory(new PropertyValueFactory<PaymentDB, Integer>("chiID"));
        colPaymentTime.setCellValueFactory(new PropertyValueFactory<PaymentDB, String>("chiDate"));
        colPaymentCatalog.setCellValueFactory(new PropertyValueFactory<PaymentDB, String>("chiCatalog"));
        colPaymentPrice.setCellValueFactory(new PropertyValueFactory<PaymentDB, Integer>("chiPrice"));
        colPaymentNote.setCellValueFactory(new PropertyValueFactory<PaymentDB, String>("chiNote"));
        tvPayment.setItems(list);
    }

    public ObservableList<String> getIngredient() {
        ObservableList<String> ingredientList = FXCollections.observableArrayList();
        Connection cn = getConnect();
        String sql = "select distinct productName from Inventory where productCatalogies='Ingredient'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
//            BillDB b = null;
            while (rs.next()) {
                String ingredient = rs.getString("productName");
                ingredientList.add(ingredient);
                cbDishIngredient.setItems(ingredientList);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientList;
    }

    public PieChart createChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChartData.addAll(new PieChart.Data("Receipt", Integer.parseInt(lbTotalReceipt.getText())),
                new PieChart.Data("Payment", Integer.parseInt(lbTotalPayment.getText())));

        pChart.setData(pieChartData);
        pChart.setTitle("The chart summarizes the area of each continent.");
        pChart.setClockwise(true);
        pChart.setLabelLineLength(30);
        pChart.setLabelsVisible(true);
        pChart.setLegendVisible(true);
        pChart.setStartAngle(50);
        pChart.setLegendSide(Side.RIGHT);

        pChart.getData().forEach(data -> {
            double total = 0;
            for (PieChart.Data d : pChart.getData()) {
                total += d.getPieValue();
            }
            String text = String.format("%.1f%%", 100 * data.getPieValue() / total);
            Tooltip toolTip = new Tooltip(text);
            Tooltip.install(data.getNode(), toolTip);
        });

        return pChart;
    }

    private void totalReceipt() {
        String sql = "select SUM(thuPrice) as thuTotal from Thu";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int totalBill = rs.getInt("thuTotal");
                lbTotalReceipt.setText("" + totalBill);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void totalPayment() {
        String sql = "select SUM(chiPrice) as chiTotal from Chi";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int totalBill = rs.getInt("chiTotal");
                lbTotalPayment.setText("" + totalBill);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getMaGiamGia() {
        Connection cn = getConnect();
        String sql = "select * from codeDiscount where codeValue=N'" + tfCodeValue.getText().toUpperCase() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return false;
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean getBangMini() {
        Connection cn = getConnect();
        String sql = "select * from [OrderMini]";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void selectReceipt() {
        ReceiptDB i = tvReceipt.getSelectionModel().getSelectedItem();
        if (i != null) {
            cbReceiptCatalog.setValue(i.getThuCatalog());
            tfReceiptPrice.setText("" + i.getThuPrice());
            taReceiptNote.setText(i.getThuNote());
        }
    }

    private void selectPayment() {
        PaymentDB i = tvPayment.getSelectionModel().getSelectedItem();
        if (i != null) {
            cbPaymentCatalog.setValue(i.getChiCatalog());
            tfPaymentPrice.setText("" + i.getChiPrice());
            taPaymentNote.setText(i.getChiNote());
        }
    }

    private void clearReceipt() {
        cbReceiptCatalog.setValue(null);
        tfReceiptPrice.clear();
        taReceiptNote.clear();
    }

    private void clearPayment() {
        cbPaymentCatalog.setValue(null);
        tfPaymentPrice.clear();
        taPaymentNote.clear();
    }

    private void checkUserName(javafx.scene.control.TextField p, Label lb, Button btn1, Button btn2) {
        String sql1 = "select * from Staff where staffUserName=N'" + p.getText() + "'";
        String sql2 = "select * from Account where accountUserName=N'" + p.getText() + "'";
        String sql3 = "select * from Customer where customerUserName=N'" + p.getText() + "'";
        Connection cn = getConnect();
        Statement st1;
        Statement st2;
        Statement st3;
        try {
            st1 = cn.createStatement();
            st2 = cn.createStatement();
            st3 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            ResultSet rs2 = st2.executeQuery(sql2);
            ResultSet rs3 = st3.executeQuery(sql3);
            if ((rs1.next() && rs2.next()) || (rs3.next() && rs2.next())) {
                lb.setText("Your UserName is used");
                btn1.setDisable(true);
                btn2.setDisable(true);
            } else if (!rs1.next() && rs2.next()) {
                btn1.setDisable(false);
                btn2.setDisable(false);
                lb.setText("");
            } else {
                lb.setText("Your UserName is invalid");
                btn1.setDisable(true);
                btn2.setDisable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkDishName(String query, Label lb, String tb, Button btn1, Button btn2) {
        String sql1 = query;
        Connection cn = getConnect();
        Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            if ((rs1.next())) {
                lb.setText(tb);
                btn1.setDisable(true);
                btn2.setDisable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkDayReport() {
        String sql1 = "Select * from [Order]";
        Connection cn = getConnect();
        Statement st1;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            if ((rs1.next())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    private void handleMouseAction(ActionEvent event) {
//        if (event.getSource() == btnBillPrint) {
//            PrintReport pr = new PrintReport();
//            pr.showInvoice();
//        }
//    }
    @FXML
    private void handleTypeAction(KeyEvent event) {
        if (event.getSource() == tfStaffUsername) {
            checkUserName(tfStaffUsername, lbStaffCheck, btnStaffCreate, btnStaffUpdate);
        }
        if (event.getSource() == tfCustomerUserName) {
            checkUserName(tfCustomerUserName, lbCusCheck, btnCustomerCreate, btnCustomerUpdate);
        }
        if (event.getSource() == tfDishName) {
            checkDishName("select * from Menu where dishName=N'" + tfDishName.getText() + "'", lbDishNameCheck, "Your Dish is exits", btnDishCreate, btnDishUpdate);
        }
        if (event.getSource() == tfDishName) {
            checkDishName("select * from Inventory where productName=N'" + tfInventoryName.getText() + "'", lbInventoryCheck, "Your Inventory is exits", btnInventoryCreate, btnInventoryUpdate);
        }
        if (event.getSource() == tfCodeValue) {
            checkDishName("select * from codeDiscount where codeValue=N'" + tfCodeValue.getText() + "'", lbCodeCheck, "Your Code is exits", btnCodeCreate, btnCodeUpdate);
        }
    }
}
