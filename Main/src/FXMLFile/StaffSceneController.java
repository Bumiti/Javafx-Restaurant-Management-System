/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import jdbcDAO.*;

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
    private Tab tabLog;
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
    private Button btnStaffCreate;
    @FXML
    private TableView<StaffDB> tvStaff;
    @FXML
    private TableColumn<StaffDB, Integer> colStaffID;
    @FXML
    private TableColumn<StaffDB, String> colStaffName;
    @FXML
    private TableColumn<StaffDB, LocalDate> colStaffDOB;
    @FXML
    private TableColumn<StaffDB, String> colStaffAddress;
    @FXML
    private TableColumn<StaffDB, String> colStaffPossition;
    @FXML
    private TableColumn<StaffDB, Integer> colStaffSalary;
    private Button btnBrowser;
    @FXML
    private Button btnStaffClear;
    private FileChooser fileChooser;
    private File file;
    private Stage stage;
    private final Desktop deskTop = Desktop.getDesktop();
    private Image image;
    private FileInputStream fis;
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
    private TableColumn<AccountDB, String> colAccountFullname;
    @FXML
    private Label lbAccountID;
    @FXML
    private javafx.scene.control.TextField tfAccountUsername;
    @FXML
    private javafx.scene.control.TextField tfAccountPassword;
    @FXML
    private ComboBox<String> cbAccountRole;
    @FXML
    private javafx.scene.control.TextField tfAccountFullname;
    @FXML
    private Label lbStaffID;
    @FXML
    private Button btnStaffUpdate;
    @FXML
    private Button btnStaffDelete;
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
    private Button btnCodeClear;
    @FXML
    private Button btnCodeCreate;
    @FXML
    private Button btnCodeUpdate;
    @FXML
    private Button btnCodeDelete;
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
    private Spinner<Integer> snInventoryQOH;
    @FXML
    private ComboBox<String> cbInventoryUnit;
    @FXML
    private javafx.scene.control.TextField tfInventoryPrice;
    @FXML
    private ComboBox<String> cbInventoryCatalogies;
    @FXML
    private Button btnInventoryBrowser;
    @FXML
    private Button btnInventoryClear;
    @FXML
    private Button btnInventoryCreate;
    @FXML
    private Button btnInventoryUpdate;
    @FXML
    private Button btnInventoryDelete;
    @FXML
    private Button btnStaffBrowser;
    @FXML
    private ImageView imgInventory;
    @FXML
    private Button btnAccountCreate;
    @FXML
    private Button btnAccountUpdate;
    @FXML
    private Button btnAccountDelete;
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
    private Button btnDishBrowser;
    @FXML
    private Button btnDishClear;
    @FXML
    private Button btnDishCreate;
    @FXML
    private Button btnDishUpdate;
    @FXML
    private Button btnDishDelete;
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
    @FXML
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
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnStaffBrowser) {
            stage = (Stage) bpStaff.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            /*try {
                deskTop.open(file);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
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

    @FXML
    private void handleMouseAction(MouseEvent event) {
        if (event.getSource() == tvStaff) {
            selectStaff();
        }
        if (event.getSource() == btnStaffClear) {
            clearStaff();
        }
        if (event.getSource() == btnStaffCreate) {
            insertStaff();
            clearStaff();
        }
        if (event.getSource() == btnStaffUpdate) {
            updateStaff();
            clearStaff();
        }
        if (event.getSource() == btnStaffDelete) {
            deleteStaff();
            clearCode();
        }
        if (event.getSource() == tvAccount) {
            selectAccount();
        }
        if (event.getSource() == btnAccountClear) {
            clearAccount();
        }
        if (event.getSource() == btnAccountCreate) {
            insert("insert into Account values ('" + tfAccountUsername.getText() + "','" + tfAccountPassword.getText() + "','" + cbAccountRole.getValue() + "','" + tfAccountFullname.getText() + "')");
            showAccountDB();
            clearAccount();
        }
        if (event.getSource() == btnAccountUpdate) {
            update("update Account set accountUserName='" + tfAccountUsername.getText() + "',accountPassWord=" + tfAccountPassword.getText() + ",accountRole='" + cbAccountRole.getValue() + "',accountFullname='" + tfAccountFullname.getText() + "' where accountID=" + Integer.valueOf(lbAccountID.getText()) + "");
            showAccountDB();
            clearAccount();

        }
        if (event.getSource() == btnAccountDelete) {
            delete("delete from Account where accountID=" + Integer.valueOf(lbAccountID.getText()) + "");
            showAccountDB();
            clearAccount();
        }
        if (event.getSource() == tvCodeDiscount) {
            selectCode();
        }
        if (event.getSource() == btnCodeClear) {
            clearCode();
        }
        if (event.getSource() == btnCodeCreate) {
            insert("insert into codeDiscount values (1,'" + tfCodeValue.getText() + "'," + tfCodeQuantity.getText() + "," + tfCodeDiscountPercent.getText() + ")");
            showCodeDB();
            clearCode();
        }
        if (event.getSource() == btnCodeUpdate) {
            update("update codeDiscount set codeValue='" + tfCodeValue.getText() + "',codeQuantity=" + Integer.valueOf(tfCodeQuantity.getText()) + " ,discountPercent=" + Integer.valueOf(tfCodeDiscountPercent.getText()) + "where codeID=" + Integer.valueOf(lbCodeID.getText()) + "");
            showCodeDB();
            clearCode();
        }
        if (event.getSource() == btnCodeDelete) {
            delete("delete from codeDiscount where codeID=" + Integer.valueOf(lbCodeID.getText()) + "");
            showCodeDB();
            clearCode();
        }
        if (event.getSource() == tvInventory) {
            selectInventory();
        }
        if (event.getSource() == btnInventoryClear) {
            clearInventory();
        }
        if (event.getSource() == btnInventoryCreate) {
            insertInventory();
            clearInventory();
        }
        if (event.getSource() == btnInventoryUpdate) {
            updateInventory();
            clearInventory();
        }
        if (event.getSource() == btnInventoryDelete) {
            deleteInventory();
            clearInventory();
        }
        if (event.getSource() == tvMenu) {
            selectMenu();
        }
        if (event.getSource() == btnDishClear) {
            clearMenu();
        }
        if (event.getSource() == btnDishCreate) {
            insertMenu();
            clearMenu();
        }
        if (event.getSource() == btnDishUpdate) {
            updateMenu();
            clearMenu();
        }
        if (event.getSource() == btnDishDelete) {
            deleteMenu();
            clearMenu();
        }
        if (event.getSource() == tvCustomer) {
            selectCustomer();
        }
        if (event.getSource() == btnCustomerClear) {
            clearCustomer();
        }
        if (event.getSource() == btnCustomerCreate) {
            insertCustomer();
            clearCustomer();
        }
        if (event.getSource() == btnCustomerUpdate) {
            updateCustomer();
            clearCustomer();
        }
        if (event.getSource() == btnCustomerDelete) {
            deleteCustomer();
            clearCustomer();
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
        if (event.getSource() == tvOrderMenu) {
            OrderMenuDB o = tvOrderMenu.getSelectionModel().getSelectedItem();
            SpinnerValueFactory<Integer> dishSpiner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, o.getMenuDishAvailabe(), 0, 1);
            snOrderDishQuantity.setValueFactory(dishSpiner);
            selectOrderMenu();
        }
        if (event.getSource() == btnOrderMenuAdd) {
            addToOderList();
            showOrderMiniDB();
        }
        if (event.getSource() == btnOrderMiniSend) {
            lbOrderID.setText("" + count.incrementAndGet());
            insert("insert into [Order](brandID,orderID,orderTime,dishCatalogies,orderNote,dishName,dishPrice,dishQuantity) select 1," + lbOrderID.getText() + ",'" + lbTime.getText() + "','" + cbOrderCatalogies.getValue() + "' ,'" + taOrderNote.getText() + "',OrderMini.dishName,OrderMini.dishPrice,OrderMini.dishQuantity from [OrderMini]");
            delete("delete from [OrderMini]");
            showOrderListDB();
            showOrderMiniDB();
        }
        if (event.getSource() == btnBillGet) {
            showBillDB();
        }
        if (event.getSource() == btnBillClear) {
            clearBill();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "* *"),
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Text File", "*.txt")
        );
        cbStaffPossition.getItems().addAll(possition);
        cbAccountRole.getItems().addAll(role);
        cbInventoryUnit.getItems().addAll(productUnit);
        cbInventoryCatalogies.getItems().addAll(productCatalogies);
        snInventoryQOH.setValueFactory(productSpinner);
        cbDishIngredient.getItems().addAll(dishIngredient);
        cbDishCatalogies.getItems().addAll(dishCatalogies);
        cbDishStatus.getItems().addAll(dishStatus);
        cbCustomerGender.getItems().addAll(gender);
        cbOrderCatalogies.getItems().addAll(orderCatalogies);
        lbOrderID.setText("" + count);
        getTable();
        getTakeAwayID();
        showBillDB();
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
    }

    public void setName(String name) {
        lbUser.setText(name);
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final String[] possition = {"Manager", "Supervisor", "Waiter"};
    private static final String[] role = {"Manager", "Supervisor", "Waiter", "Customer"};
    private static final String[] productUnit = {"Kg", "L", "Lon"};
    private static final String[] productCatalogies = {"Tool", "Ingredient"};
    private static final String[] dishIngredient = {"Thit", "Ca"};
    private static final String[] dishCatalogies = {"Hors d'oeuvres", "Soup", "Fish Dish", "Meat Dish", "Main Course", "Salad", "Dessert", "Drink"};
    private static final String[] dishStatus = {"Available", "Unavailable"};
    private static final String[] gender = {"Male", "Female"};
    private static final String[] orderCatalogies = {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6", "Table 7", "Table 8", "Take-away"};
    private static final SpinnerValueFactory<Integer> productSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 1, 1);
    private static final AtomicInteger count = new AtomicInteger(100);
    public static final Logger log = Logger.getLogger(StaffSceneController.class);

    public volatile boolean stop = false;

    private void Close_clicked(MouseEvent event) {
        stop = true;
        javafx.application.Platform.exit();
    }

    private void Timenow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
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
        String sql = "select staffID,staffName,staffDOB,staffAddress,staffPossition,staffPhone,staffMail,staffSalary from Staff";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            StaffDB s = null;
            while (rs.next()) {
                s = new StaffDB(rs.getInt("staffID"), rs.getString("staffName"), rs.getDate("staffDOB").toLocalDate(), rs.getString("staffAddress"), rs.getString("staffPossition"), rs.getInt("staffPhone"), rs.getString("staffMail"), rs.getInt("staffSalary"));
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
        colStaffDOB.setCellValueFactory(new PropertyValueFactory<StaffDB, LocalDate>("staffDOB"));
        colStaffAddress.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffAddress"));
        colStaffPossition.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffPossition"));
        colStaffPhone.setCellValueFactory(new PropertyValueFactory<StaffDB, Integer>("staffPhone"));
        colStaffMail.setCellValueFactory(new PropertyValueFactory<StaffDB, String>("staffMail"));
        colStaffSalary.setCellValueFactory(new PropertyValueFactory<StaffDB, Integer>("staffSalary"));
        tvStaff.setItems(list);
    }

    private void selectStaff() {
        StaffDB s = tvStaff.getSelectionModel().getSelectedItem();
        lbStaffID.setText("" + s.getStaffID());
        tfStaffName.setText(s.getStaffName());
        tfStaffDOB.setValue(s.getStaffDOB());
        tfStaffAddress.setText(s.getStaffAddress());
        cbStaffPossition.setValue(s.getStaffPossition());
        tfStaffPhone.setText("" + s.getStaffPhone());
        tfStaffMail.setText(s.getStaffMail());
        tfStaffSalary.setText("" + s.getStaffSalary());
        showImage("select staffImage from Staff where staffID=?", s.getStaffID(), imgStaffImage);
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
        imgStaffImage.setImage(null);
    }

    private void insertStaff() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Staff VALUES (1,?,?,?,?,?,?,?,?)";

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
            fis = new FileInputStream(file);
            st.setBinaryStream(8, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showStaffDB();
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
        String sql = "UPDATE Staff set staffName=?,staffDOB=?,staffAddress=?,staffPossition=?,staffPhone=?,staffMail=?,staffSalary=?,staffImage=? where staffID=?";

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
            fis = new FileInputStream(file);
            st.setBinaryStream(8, fis, file.length());
            st.setInt(9, Integer.valueOf(lbStaffID.getText()));
            //4 thuc hien insert sql
            st.executeUpdate();
            showStaffDB();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "select accountID, accountUserName,accountPassWord,accountRole,accountFullname from Account";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            AccountDB a = null;
            while (rs.next()) {
                a = new AccountDB(rs.getInt("accountID"), rs.getString("accountUserName"), rs.getString("accountPassWord"), rs.getString("accountRole"), rs.getString("accountFullname"));
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
        colAccountFullname.setCellValueFactory(new PropertyValueFactory<AccountDB, String>("accountFullname"));
        tvAccount.setItems(list);
    }

    private void selectAccount() {
        AccountDB a = tvAccount.getSelectionModel().getSelectedItem();
        lbAccountID.setText("" + a.getAccountID());
        tfAccountUsername.setText(a.getAccountUserName());
        tfAccountPassword.setText(a.getAccountPassWord());
        cbAccountRole.setValue(a.getAccountRole());
        tfAccountFullname.setText(a.getAccountFullname());
    }

    private void clearAccount() {
        lbAccountID.setText("");
        tfAccountUsername.clear();
        tfAccountPassword.clear();
        cbAccountRole.setValue(null);
        tfAccountFullname.clear();
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
        lbCodeID.setText("" + c.getCodeID());
        tfCodeValue.setText(c.getCodeValue());
        tfCodeQuantity.setText("" + c.getCodeQuantity());
        tfCodeDiscountPercent.setText("" + c.getDiscountPercent());
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
        lbInventoryID.setText("" + i.getProductID());
        tfInventoryName.setText(i.getProductName());
        snInventoryQOH.getValueFactory().setValue(i.getProductQOH());
        cbInventoryUnit.setValue(i.getProductUnit());
        tfInventoryPrice.setText("" + i.getProductPrice());
        cbInventoryCatalogies.setValue(i.getProductCatalogies());
        showImage("select productImage from Inventory where productID=?", i.getProductID(), imgInventory);
    }

    private void clearInventory() {
        lbInventoryID.setText("");
        tfInventoryName.clear();
        snInventoryQOH.getValueFactory().setValue(null);
        cbInventoryUnit.setValue(null);
        tfInventoryPrice.clear();
        cbInventoryCatalogies.setValue(null);
        imgInventory.setImage(null);
    }

    private void insertInventory() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Inventory VALUES (1,?,?,?,?,?,?)";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfInventoryName.getText());
            st.setInt(2, snInventoryQOH.getValue());
            st.setString(3, cbInventoryUnit.getValue());
            st.setInt(4, Integer.valueOf(tfInventoryPrice.getText()));
            st.setString(5, cbInventoryCatalogies.getValue());
            fis = new FileInputStream(file);
            st.setBinaryStream(6, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showInventoryDB();
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
        String sql = "UPDATE Inventory set productName=?,productQOH=?,productUnit=?,productPrice=?,productCatalogies=?,productImage=? where productID=?";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
//            st.setInt(1, i.id);
            st.setString(1, tfInventoryName.getText());
            st.setInt(2, snInventoryQOH.getValue());
            st.setString(3, cbInventoryUnit.getValue());
            st.setInt(4, Integer.valueOf(tfInventoryPrice.getText()));
            st.setString(5, cbInventoryCatalogies.getValue());
            fis = new FileInputStream(file);
            st.setBinaryStream(6, fis, file.length());
            st.setInt(7, Integer.valueOf(lbInventoryID.getText()));
            //4 thuc hien insert sql
            st.executeUpdate();
            showInventoryDB();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "UPDATE Menu set dishName=?,dishPrice=?,dishIngredient=?,dishConsume=?,dishCatalogies=?,dishStatus=?,dishDescription=?,dishImage=? where dishID=?";

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
            st.setInt(9, Integer.valueOf(lbDishID.getText()));
            //4 thuc hien insert sql
            st.executeUpdate();
            showMenuDB();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "select customerID, customerName,customerDOB,customerAddress,customerPhone,customerMail,customerGender from Customer";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            CustomerDB c = null;
            while (rs.next()) {
                c = new CustomerDB(rs.getInt("customerID"), rs.getString("customerName"), rs.getDate("customerDOB").toLocalDate(), rs.getString("customerAddress"), rs.getInt("customerPhone"), rs.getString("customerMail"), rs.getString("customerGender"));
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
        tvCustomer.setItems(list);
    }

    private void selectCustomer() {
        CustomerDB c = tvCustomer.getSelectionModel().getSelectedItem();
        lbCustomerID.setText("" + c.getCustomerID());
        tfCustomerName.setText(c.getCustomerName());
        tfCustomerDOB.setValue(c.getCustomerDOB());
        tfCustomerAddress.setText(c.getCustomerAddress());
        tfCustomerPhone.setText("" + c.getCustomerPhone());
        tfCustomerMail.setText(c.getCustomerMail());
        cbCustomerGender.setValue(c.getCustomerGender());
        showImage("select customerImage from Customer where customerID=?", c.getCustomerID(), imgCustomer);
    }

    private void clearCustomer() {
        lbCustomerID.setText("");
        tfCustomerName.clear();
        tfCustomerDOB.setValue(null);
        tfCustomerAddress.clear();
        tfCustomerPhone.clear();
        tfCustomerMail.clear();
        cbCustomerGender.setValue(null);
        imgCustomer.setImage(null);
    }

    private void insertCustomer() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
            st.setString(1, tfCustomerName.getText());
            st.setDate(2, java.sql.Date.valueOf(tfCustomerDOB.getValue()));
            st.setString(3, tfCustomerAddress.getText());
            st.setInt(4, Integer.valueOf(tfCustomerPhone.getText()));
            st.setString(5, tfCustomerMail.getText());
            st.setString(6, cbCustomerGender.getValue());
            fis = new FileInputStream(file);
            st.setBinaryStream(7, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
            showCustomerDB();
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
        String sql = "UPDATE Customer set customerName=?,customerDOB=?,customerAddress=?,customerPhone=?,customerMail=?,customerGender=?,customerImage=? where customerID=?";

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
            fis = new FileInputStream(file);
            st.setBinaryStream(7, fis, file.length());
            st.setInt(8, Integer.valueOf(lbCustomerID.getText()));
            //4 thuc hien insert sql
            st.executeUpdate();
            showCustomerDB();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "select a.dishName,a.dishPrice,floor(b.productQOH/a.dishConsume) as dishAvailable,a.dishDescription from Menu a join Inventory b on productName =dishIngredient where a.dishStatus='Available' and a.dishCatalogies='" + Catalogies + "'";
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
        lbOrderDishName.setText(o.getMenuDishName());
        showImage("select dishImage from Menu where dishName=?", o.getMenuDishName(), imgOrderMenu);
    }

    private void addToOderList() {
        OrderMenuDB o = tvOrderMenu.getSelectionModel().getSelectedItem();
        String sql = "select * from [OrderMini] where dishName='" + o.getMenuDishName() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String sqlUpdate = "update [OrderMini] set dishQuantity+=" + snOrderDishQuantity.getValue() + " where dishName='" + o.getMenuDishName() + "'";
                executeQuery(sqlUpdate);
            } else {
                String sqInsert = "insert into [OrderMini] values (1,'" + o.getMenuDishName() + "'," + o.getMenuDishPrice() + "," + snOrderDishQuantity.getValue() + ")";
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

    public ObservableList<Integer> getTakeAwayID() {
        ObservableList<Integer> TableList = FXCollections.observableArrayList();
        Connection cn = getConnect();
        String sql = "select distinct orderID from [Order]";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
//            BillDB b = null;
            while (rs.next()) {
                int table = rs.getInt("orderID");
                TableList.add(table);
                cbBillTakeAway.setItems(TableList);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableList;
    }

    public ObservableList<BillDB> getBillDB() {
        ObservableList<BillDB> billList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select dishName,dishPrice,dishQuantity from [Order] where dishCatalogies='" + cbBillTable.getValue() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            BillDB b = null;
            while (rs.next()) {
                b = new BillDB(rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishQuantity"));
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
        tvBill.setItems(list);
    }

    private void clearBill() {
        cbBillTable.setValue(null);
        cbBillTakeAway.setValue(null);
        tfBillDiscount.clear();
    }
    //or orderID="+cbBillTakeAway.getValue()+"

}
