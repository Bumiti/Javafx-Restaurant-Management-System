/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.SignUpController.getConnect;
import static FXMLFile.StaffSceneController.getConnect;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import jdbcDAO.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.apache.log4j.PropertyConfigurator;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CustomerSceneController implements Initializable {

    @FXML
    private BorderPane bpHomepage;
    @FXML
    private BorderPane bpMenu;
    private BorderPane bpBook;
    @FXML
    private BorderPane bpMyRestaurant;
    @FXML
    private BorderPane bpAboutUs;
    @FXML
    private Button btnHomepage;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnMyRestaurant;
    @FXML
    private Button btnAboutUS;
    private Button btnBookTable;
    @FXML
    private ImageView imgDish;
    @FXML
    private Label lbDishName;
    @FXML
    private Label lbDishPrice;
    @FXML
    private Spinner<Integer> snDishQuantity;
    @FXML
    private Button btnAdd;
    @FXML
    private Label lbOrderMenuAll;
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
    private TableView<OrderMenuDB> tvMenu;
    @FXML
    private TableColumn<OrderMenuDB, String> colMenuDishName;
    @FXML
    private TableColumn<OrderMenuDB, Integer> colMenuDishPrice;
    @FXML
    private TableColumn<OrderMenuDB, String> colMenuDishDescription;
    @FXML
    private TableView<OrderCusMini> tvOrderMini;
    @FXML
    private TableColumn<OrderCusMini, String> colOrderName;
    @FXML
    private TableColumn<OrderCusMini, Integer> colOrderPrice;
    @FXML
    private TableColumn<OrderCusMini, Integer> colOrderQuantity;
    private FileChooser fileChooser;
    @FXML
    private Label lbTime;
    private File file;
    private Stage stage;
    private final Desktop deskTop = Desktop.getDesktop();
    private Image image;
    private FileInputStream fis;
    @FXML
    private TableColumn<OrderMenuDB, Integer> colMenuDishAvailable;
    @FXML
    private Spinner<String> snTime;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnOrder;
    @FXML
    private DatePicker dpDate;
    @FXML
    private ComboBox<String> cbCatalogies;
    @FXML
    private TextArea taNote;
    @FXML
    private Label lbTotal;
    @FXML
    private Label lbOrderID;
    @FXML
    private Label lbCusName;
    @FXML
    private Button btnLeft;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private Button btnRight;
    @FXML
    private Label lbChangeCheck;
    @FXML
    private StackPane spCustomer;
    @FXML
    private Button btnLanguage;
    @FXML
    private TextArea taDescription;
    @FXML
    private Button btnLogOut;
    @FXML
    private WebView webView;
    @FXML
    private Button btnChangeInfo;
    @FXML
    private BorderPane bpChangeInfo;
    @FXML
    private ImageView imgCustomer;
    @FXML
    private TextField tfSignUpFullName;
    @FXML
    private DatePicker tfSignUpDOB;
    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private TextField tfSignUpMail;
    @FXML
    private TextField tfSignUpAddress;
    @FXML
    private TextField tfSignUpPhone;
    @FXML
    private TextField tfSignUpUserName;
    @FXML
    private Label lbCheck;
    @FXML
    private PasswordField tfSignUpPassWord1;
    @FXML
    private PasswordField tfSignUpPassWord2;
    @FXML
    private Button btnDarkMode;
    @FXML
    private Button btnImageBrowser;

    /**
     * Initializes the controller class.
     */
    ToggleGroup gender = new ToggleGroup();
    @FXML
    private Button btnAccountUpdate;
    @FXML
    private Label lbCusID;
    @FXML
    private Label lbCusUserName;
    @FXML
    private Label lbBookTotal;
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
    private BorderPane bpHistory;
    @FXML
    private Button btnHistory;
    @FXML
    private Label lbDarkMode;
    @FXML
    private Label lbBackground;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "* *"),
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Text File", "*.txt")
        );
        cbCatalogies.getItems().addAll(bookCatalogies);
        snTime.setValueFactory(time);
        rbMale.setToggleGroup(gender);
        rbFemale.setToggleGroup(gender);
        lbDarkMode.setText("Light");
        lbBackground.setText("1");
        file = null;
        Timenow();
        showOrderMenuDB();
        showOrderMiniDB();
        showBookInfoDB();
        dpDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) < 0);
            }
        });
        tfSignUpDOB.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });
        dpDate.setConverter(new StringConverter<LocalDate>() {
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
        tfSignUpDOB.setConverter(new StringConverter<LocalDate>() {
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
        getCustomerDB();
        getAccountDB();
        WebEngine webEngine = webView.getEngine();
        final URL urlGoogleMaps = getClass().getResource("/FXMLFile/googlemap.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }

    //chuyen scene
    @FXML
    private void handleClickAction(MouseEvent event) throws IOException {
        if (event.getSource() == btnHomepage) {
            bpHomepage.setVisible(true);
            bpMenu.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
            bpChangeInfo.setVisible(false);
            bpHistory.setVisible(false);
        }
//        if(event.getSource()==btnHomepage){
//            bpHomepage.setVisible(false);
//            bpMenu.setVisible(false);
//            bpBook.setVisible(false);
//            bpMyRestaurant.setVisible(false);
//            bpAboutUs.setVisible(false);
//        }
        if (event.getSource() == btnMenu) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(true);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
            bpChangeInfo.setVisible(false);
            bpHistory.setVisible(false);
        }
        if (event.getSource() == btnMyRestaurant) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpMyRestaurant.setVisible(true);
            bpAboutUs.setVisible(false);
            bpChangeInfo.setVisible(false);
            bpHistory.setVisible(false);

        }
        if (event.getSource() == btnAboutUS) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(true);
            bpChangeInfo.setVisible(false);
            bpHistory.setVisible(false);
        }
        if (event.getSource() == btnBookTable) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
            bpChangeInfo.setVisible(false);
            bpHistory.setVisible(false);
        }
        if (event.getSource() == btnChangeInfo) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
            bpChangeInfo.setVisible(true);
            bpHistory.setVisible(false);
            getCustomerDB();
            getAccountDB();
            showImage("select customerImage from Customer where customerUserName=?", lbCusName.getText(), imgCustomer);
        }
        if (event.getSource() == btnHistory) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
            bpChangeInfo.setVisible(false);
            bpHistory.setVisible(true);
            showBookInfoDB();
        }
        if (event.getSource() == btnLeft) {
            left();
        }
        if (event.getSource() == btnRight) {
            right();
        }
        if (event.getSource() == btnLanguage) {
            if (Pattern.matches("Welcome", lbChangeCheck.getText())) {
                Stage stage = (Stage) spCustomer.getScene().getWindow();
                stage.close();
                getSceneVN("/FXMLFile/CustomerScene.fxml", "Customer");
            } else {
                Stage stage = (Stage) spCustomer.getScene().getWindow();
                stage.close();
                getSceneEN("/FXMLFile/CustomerScene.fxml", "Customer");
            }
        }
        if (event.getSource() == btnDarkMode) {
            if (Pattern.matches("Light", lbDarkMode.getText())) {
                spCustomer.getStylesheets().remove(theme2Url);
                lbDarkMode.setText("Dark");
                spCustomer.getStylesheets().add(theme1Url);
            } else if (Pattern.matches("Dark", lbDarkMode.getText())) {
                spCustomer.getStylesheets().remove(theme1Url);
                lbDarkMode.setText("Light");
                spCustomer.getStylesheets().add(theme2Url);
            }
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) throws IOException {
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
        if (event.getSource() == tvMenu) {
            OrderMenuDB o = tvMenu.getSelectionModel().getSelectedItem();
            SpinnerValueFactory<Integer> dishSpiner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, o.getMenuDishAvailabe(), 0, 1);
            snDishQuantity.setValueFactory(dishSpiner);
            selectOrderMenu();
        }
        if (event.getSource() == btnAdd) {
            OrderMenuDB om = tvMenu.getSelectionModel().getSelectedItem();
            if (om.getMenuDishAvailabe() == snDishQuantity.getValue()) {
                update("update Menu set dishStatus='Unavailable' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getMenuDishName() + "')");
            }
            addToOderList();
            insert("update Inventory set productQOH-=(select a.dishConsume*" + snDishQuantity.getValue() + " as ingredientDown from Menu a join CusOrderMini b on a.dishName =b.dishName where b.dishName=N'" + om.getMenuDishName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getMenuDishName() + "')");
            showOrderMenuDB();
            showOrderMiniDB();
            totalBill();
        }
        if (event.getSource() == btnRemove) {
            OrderCusMini ocm = tvOrderMini.getSelectionModel().getSelectedItem();
            if (ocm.getOrderCusQuantity() != 1) {
                update("update [CusOrderMini] set dishQuantity-=1 where dishName=N'" + ocm.getOrderCusName() + "'");
                insert("update Inventory set productQOH+=(select a.dishConsume*1 as ingredientUp from Menu a join CusOrderMini b on a.dishName =b.dishName where b.dishName=N'" + ocm.getOrderCusName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + ocm.getOrderCusName() + "')");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + ocm.getOrderCusName() + "')");
                showOrderMiniDB();
                showOrderMenuDB();
                totalBill();
            } else {
                insert("update Inventory set productQOH+=(select a.dishConsume*1 as ingredientUp from Menu a join CusOrderMini b on a.dishName =b.dishName where b.dishName=N'" + ocm.getOrderCusName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + ocm.getOrderCusName() + "')");
                delete("delete from [CusOrderMini] where dishName=N'" + ocm.getOrderCusName() + "'");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + ocm.getOrderCusName() + "')");
                showOrderMiniDB();
                showOrderMenuDB();
                totalBill();
            }
        }
        if (event.getSource() == btnDelete) {
            if (alertConFirm("Are you want to delete order?") == true) {
                OrderCusMini ocm = tvOrderMini.getSelectionModel().getSelectedItem();
                insert("update Inventory set productQOH+=(select a.dishConsume*" + ocm.getOrderCusQuantity() + " as ingredientUp from Menu a join CusOrderMini b on a.dishName =b.dishName where b.dishName=N'" + ocm.getOrderCusName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + ocm.getOrderCusName() + "')");
                delete("delete from [CusOrderMini] where dishName=N'" + ocm.getOrderCusName() + "'");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + ocm.getOrderCusName() + "')");
                showOrderMenuDB();
                showOrderMiniDB();
                totalBill();
                alertSuccess("Delete Order Successfully!");
            }

        }
        if (event.getSource() == btnOrder) {
            if (dpDate.getValue() == null) {
                alert("Please choose date");
            } else if (cbCatalogies.getValue() == null) {
                alert("Please chooose catelogies!");
            } else if (getBangMini() == false) {
                alert("Please choose dish");
            } else {
                if (alertConFirm("Are you want to confirm order?") == true) {
                    lbOrderID.setText("" + count.incrementAndGet());
                    insert("insert into Book(brandID,bookID,bookDate,bookTime,bookCustomerName,bookCatalogies,bookNote,bookDishName,bookDishQuantity,bookDishPrice) select 1," + lbOrderID.getText() + ",N'" + dpDate.getValue() + "',N'" + snTime.getValue() + "',N'" + lbCusName.getText() + "',N'" + cbCatalogies.getValue() + "' ,N'" + taNote.getText() + "',CusOrderMini.dishName,CusOrderMini.dishQuantity,CusOrderMini.dishPrice from [CusOrderMini]");
                    delete("delete from [CusOrderMini]");
                    showOrderMiniDB();
                    showOrderMenuDB();
                    showBookInfoDB();
                    alertSuccess("Order Successfully!");
                    dpDate.setValue(null);
                    cbCatalogies.setValue(null);
                    taNote.clear();
                }
            }
        }
        if (event.getSource() == btnLogOut) {
            modalBox("/FXMLFile/LoginScene.fxml", "Sign In");
        }
        if (event.getSource() == btnImageBrowser) {
            stage = (Stage) spCustomer.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                System.out.println("" + file.getAbsolutePath());
                image = new Image(file.getAbsoluteFile().toURI().toString(), imgCustomer.getFitWidth(), imgCustomer.getFitHeight(), true, true);
                imgCustomer.setImage(image);
                imgCustomer.setPreserveRatio(true);
            }
        }
        if (event.getSource() == btnAccountUpdate) {
            if (!Pattern.matches("\\X{1,}", tfSignUpFullName.getText())) {
                alert("Please input Fullname");
            } else if (tfSignUpDOB.getValue() == null) {
                alert("Please input Day of Birth");
            } else if (!Pattern.matches("\\w{3,30}@([a-z0-9]{3,10}\\.){1,2}[a-z]{2,3}", tfSignUpMail.getText())) {
                alert("Mail wrong form");
            } else if (!Pattern.matches("\\X{1,}", tfSignUpAddress.getText())) {
                alert("Please input Address");
            } else if (!Pattern.matches("\\d{8,12}", tfSignUpPhone.getText())) {
                alert("Phone from 8-12");
            } else if (!Pattern.matches("\\w{1,}", tfSignUpUserName.getText())) {
                alert("Please input Username");
            } else if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", tfSignUpPassWord1.getText())) {
                alert("Password must contain at least 1 digit [0-9],\n"
                        + "One lowercase [a-z],"
                        + "One uppercase [A-Z],\n"
                        + "One special character like !@#.\n"
                        + "8-20 characters");
            } else if (!Pattern.matches(tfSignUpPassWord1.getText(), tfSignUpPassWord2.getText())) {
                alert("Password is not same");
            } else if (imgCustomer.getImage() == null) {
                alert("Please choose image");
            } else {
                alertSuccess("Successfully Update");
                update("update Account set accountUserName=N'" + tfSignUpUserName.getText() + "',accountPassWord=" + tfSignUpPassWord2.getText() + ",accountRole='Customer' where accountUserName=N'" + lbCusName.getText() + "'");
                insertCustomer();
                getCustomerDB();
                getAccountDB();
                showImage("select customerImage from Customer where customerUserName=?", lbCusName.getText(), imgCustomer);
            }
        }
        if (event.getSource() == tvBookInfo && event.getClickCount() == 2) {
            BookInfo bi = tvBookInfo.getSelectionModel().getSelectedItem();
            showBookDetailDB(bi.getBookID());
            totalBook();
        }
        if (event.getSource() == tvMenu && event.getClickCount() == 2) {
            modalBoxMenuDetailForMenu("/FXMLFile/MenuDetailScene.fxml", "Menu Detail");
        }
    }
    private static final String[] bookCatalogies = {"Eat at Restaurant", "Take-away"};
    ObservableList<String> Time = FXCollections.observableArrayList("10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30");
    SpinnerValueFactory<String> time = new SpinnerValueFactory.ListSpinnerValueFactory<String>(Time);
    private static final AtomicInteger count = new AtomicInteger(100);
    public volatile boolean stop = false;
    private String theme1Url = getClass().getResource("/FXMLFile/DarkMode.css").toExternalForm();
    private String theme2Url = getClass().getResource("/FXMLFile/application.css").toExternalForm();

    private void right() {
        if (Pattern.matches("4", lbBackground.getText())) {
            img1.setVisible(false);
            img2.setVisible(false);
            img3.setVisible(true);
            img4.setVisible(false);
            lbBackground.setText("3");
        } else if (Pattern.matches("3", lbBackground.getText())) {
            img1.setVisible(false);
            img2.setVisible(true);
            img3.setVisible(false);
            img4.setVisible(false);
            lbBackground.setText("2");
        } else if (Pattern.matches("2", lbBackground.getText())) {
            img1.setVisible(true);
            img2.setVisible(false);
            img3.setVisible(false);
            img4.setVisible(false);
            lbBackground.setText("1");
        }
    }

    private void left() {
        if (Pattern.matches("1", lbBackground.getText())) {
            img1.setVisible(false);
            img2.setVisible(true);
            img3.setVisible(false);
            img4.setVisible(false);
            lbBackground.setText("2");
        } else if (Pattern.matches("2", lbBackground.getText())) {
            img1.setVisible(false);
            img2.setVisible(false);
            img3.setVisible(true);
            img4.setVisible(false);
            lbBackground.setText("3");
        } else if (Pattern.matches("3", lbBackground.getText())) {
            img1.setVisible(false);
            img2.setVisible(false);
            img3.setVisible(false);
            img4.setVisible(true);
            lbBackground.setText("4");
        }
    }

    private void modalBox(String fxmlFile, String Title) throws IOException {
        Stage stage = (Stage) spCustomer.getScene().getWindow();
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

    private void modalBoxMenuDetailForMenu(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        MenuDetailSceneController userRole = loader.getController();
        OrderMenuDB i = tvMenu.getSelectionModel().getSelectedItem();
        userRole.setName(i.getMenuDishName());
        userRole.setPrice("" + i.getMenuDishPrice());
        userRole.setDescription(i.getMenuDishDescription());
        userRole.setImage(imgDish.getImage());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    private void getSceneVN(String fxmlFile, String Title) throws IOException {
        Locale locale = new Locale("vi_VI");
        ResourceBundle bundle = ResourceBundle.getBundle("resources.labelText", locale);
        FXMLLoader fXmlLoader = new FXMLLoader(getClass().getResource(fxmlFile), bundle);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        //Parent root = fXmlLoader.load(getClass().getResource(fxmlFile), bundle);
        Parent root = fXmlLoader.load();
        Locale currentLocale = Locale.getDefault();

        CustomerSceneController userRole = fXmlLoader.getController();
        userRole.setName(lbCusName.getText());
        userRole.setUserName(lbCusUserName.getText());

        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Title);
        primaryStage.show();
    }

    private void getSceneEN(String fxmlFile, String Title) throws IOException {
        Locale locale = new Locale("en_US");
        ResourceBundle bundle = ResourceBundle.getBundle("resources.labelText", locale);
        FXMLLoader fXmlLoader = new FXMLLoader(getClass().getResource(fxmlFile), bundle);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        //Parent root = fXmlLoader.load(getClass().getResource(fxmlFile), bundle);
        Parent root = fXmlLoader.load();
        Locale currentLocale = Locale.getDefault();

        CustomerSceneController userRole = fXmlLoader.getController();
        userRole.setName(lbCusName.getText());
        userRole.setUserName(lbCusUserName.getText());

        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Title);
        primaryStage.show();
    }

    public void setName(String name) {
        lbCusName.setText(name);
    }

    public void setUserName(String name) {
        lbCusUserName.setText(name);
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
        colMenuDishName.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishName"));
        colMenuDishPrice.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishPrice"));
        colMenuDishAvailable.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishAvailabe"));
        colMenuDishDescription.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishDescription"));
        tvMenu.setItems(list);
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
        colMenuDishName.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishName"));
        colMenuDishPrice.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, Integer>("menuDishPrice"));
        colMenuDishDescription.setCellValueFactory(new PropertyValueFactory<OrderMenuDB, String>("menuDishDescription"));
        tvMenu.setItems(list);
    }

    private void selectOrderMenu() {
        OrderMenuDB o = tvMenu.getSelectionModel().getSelectedItem();
        lbDishName.setText(o.getMenuDishName());
        lbDishPrice.setText("" + o.getMenuDishPrice());
        taDescription.setText(o.getMenuDishDescription());
        showImage("select dishImage from Menu where dishName=?", o.getMenuDishName(), imgDish);
    }

    private void addToOderList() {
        OrderMenuDB o = tvMenu.getSelectionModel().getSelectedItem();
        String sql = "select * from [CusOrderMini] where dishName=N'" + o.getMenuDishName() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String sqlUpdate = "update [CusOrderMini] set dishQuantity+=" + snDishQuantity.getValue() + " where dishName=N'" + o.getMenuDishName() + "'";
                executeQuery(sqlUpdate);
            } else {
                String sqInsert = "insert into [CusOrderMini] values (1,N'" + o.getMenuDishName() + "'," + o.getMenuDishPrice() + "," + snDishQuantity.getValue() + ")";
                executeQuery(sqInsert);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<OrderCusMini> getOrderMiniDB() {
        ObservableList<OrderCusMini> OrderMiniList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select dishName,dishPrice,dishQuantity from [CusOrderMini]";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            OrderCusMini m = null;
            while (rs.next()) {

                m = new OrderCusMini(rs.getString("dishName"), rs.getInt("dishPrice"), rs.getInt("dishQuantity"));
                OrderMiniList.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderMiniList;
    }

    public void showOrderMiniDB() {
        ObservableList<OrderCusMini> list = getOrderMiniDB();
        colOrderName.setCellValueFactory(new PropertyValueFactory<OrderCusMini, String>("orderCusName"));
        colOrderPrice.setCellValueFactory(new PropertyValueFactory<OrderCusMini, Integer>("orderCusPrice"));
        colOrderQuantity.setCellValueFactory(new PropertyValueFactory<OrderCusMini, Integer>("orderCusQuantity"));
        tvOrderMini.setItems(list);
    }

    private void totalBill() {
        String sql = "select SUM(dishPrice* dishQuantity) as billTotal from [CusOrderMini]";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int totalBill = rs.getInt("billTotal");
                lbTotal.setText("" + totalBill);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<CustomerDB> getCustomerDB() {
        ObservableList<CustomerDB> cusList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select customerID, customerName,customerDOB,customerAddress,customerPhone,customerMail,customerGender from Customer where customerUserName=N'" + lbCusName.getText() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            CustomerDB c = null;
            while (rs.next()) {
                lbCusID.setText(rs.getString("customerID"));
                tfSignUpFullName.setText(rs.getString("customerName"));
                tfSignUpDOB.setValue(rs.getDate("customerDOB").toLocalDate());
                String gen = rs.getString("customerGender");
                if (gen.equals("Male")) {
                    rbMale.isSelected();
                } else {
                    rbFemale.isSelected();
                }
                tfSignUpMail.setText(rs.getString("customerMail"));
                tfSignUpAddress.setText(rs.getString("customerAddress"));
                tfSignUpPhone.setText("" + rs.getInt("customerPhone"));
                cusList.add(c);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cusList;
    }

    public ObservableList<AccountDB> getAccountDB() {
        ObservableList<AccountDB> accountList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select accountID, accountUserName,accountPassWord,accountRole from Account where accountUserName=N'" + lbCusName.getText() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            AccountDB a = null;
            while (rs.next()) {
                tfSignUpUserName.setText(rs.getString("accountUserName"));
                tfSignUpPassWord1.setText(rs.getString("accountPassWord"));
                tfSignUpPassWord2.setText(rs.getString("accountPassWord"));
                accountList.add(a);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
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
            st.setString(2, maID.getText());
            file = null;
            //4 thuc hien insert sql
            st.executeUpdate();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertCustomer() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "UPDATE Customer set customerName=?,customerDOB=?,customerAddress=?,customerPhone=?,customerMail=?,customerGender=? where customerUserName=?";

        try {
            PreparedStatement st = cn.prepareStatement(sql);
            //3. cap nhat du lieu vo cac tham so ? theo dung thu tu cua bang tbBatch
            st.setString(1, tfSignUpFullName.getText());
            st.setDate(2, java.sql.Date.valueOf(tfSignUpDOB.getValue()));
            st.setString(3, tfSignUpAddress.getText());
            st.setInt(4, Integer.valueOf(tfSignUpPhone.getText()));
            st.setString(5, tfSignUpMail.getText());
            RadioButton button = (RadioButton) gender.getSelectedToggle();
            st.setString(6, button.getText());
            st.setString(7, lbCusName.getText());
            if (file != null) {
                updateBrowser("UPDATE Customer set customerImage=? where customerUserName=?", lbCusName);
            }
            file = null;
            //4 thuc hien insert sql
            st.executeUpdate();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

    public boolean getBangMini() {
        Connection cn = getConnect();
        String sql = "select * from [CusOrderMini]";
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

    public ObservableList<BookInfo> getBookInfoDB() {
        ObservableList<BookInfo> bookInfo = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select distinct bookID,bookDate,bookTime,bookCustomerName,bookCatalogies,bookNote from Book a join Account b on a.bookCustomerName = b.accountUserName where b.accountUserName =N'" + lbCusName.getText() + "'";
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
        
    public ObservableList<BookDetail> getBookDetailDB(Integer ma) {
        ObservableList<BookDetail> bookDetail = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select bookDishName,bookDishQuantity,bookDishPrice from Book where bookID=" + ma + " and bookCustomerName='"+lbCusName.getText()+"'";
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

    public void showBookDetailDB(Integer ma) {
        ObservableList<BookDetail> list = getBookDetailDB(ma);
        colBookDetailName.setCellValueFactory(new PropertyValueFactory<BookDetail, String>("bookDishName"));
        colBookDetailQuantity.setCellValueFactory(new PropertyValueFactory<BookDetail, Integer>("bookDishQuantity"));
        colBookDetailPrice.setCellValueFactory(new PropertyValueFactory<BookDetail, Integer>("bookDishPrice"));
        tvBookDetail.setItems(list);
    }

    private void totalBook() {
        BookInfo bi = tvBookInfo.getSelectionModel().getSelectedItem();
        String sql = "select SUM(bookDishQuantity* bookDishPrice) as bookTotal from Book where bookID=" + bi.getBookID() + "";
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

    private void checkPhone() {
        String sql1 = "select * from Customer where customerPhone=N'" + tfSignUpPhone.getText() + "'";
        String sql2 = "select * from Staff where staffPhone=N'" + tfSignUpPhone.getText() + "'";
        Connection cn = getConnect();
        Statement st1;
        Statement st2;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            if (rs1.next() || rs2.next()) {
                lbCheck.setText("Your Phone is used");
                btnAccountUpdate.setDisable(true);
            } else {
                btnAccountUpdate.setDisable(false);
                lbCheck.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkMail() {
        String sql1 = "select * from Customer where customerMail=N'" + tfSignUpMail.getText() + "'";
        String sql2 = "select * from Staff where staffMail=N'" + tfSignUpMail.getText() + "'";

        Connection cn = getConnect();
        Statement st1;
        Statement st2;
        try {
            st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            if (rs1.next() || rs2.next()) {
                lbCheck.setText("Your Mail is used");
                btnAccountUpdate.setDisable(true);
            } else {
                btnAccountUpdate.setDisable(false);
                lbCheck.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleTypeAction(KeyEvent event) {
        if (event.getSource() == tfSignUpMail) {
            checkMail();
        }
        if (event.getSource() == tfSignUpPhone) {
            checkPhone();
        }
    }
}
