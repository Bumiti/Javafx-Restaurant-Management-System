/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import java.io.File;
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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdbcDAO.BookDetail;
import jdbcDAO.BookInfo;
import jdbcDAO.OrderListMini;
import jdbcDAO.OrderMenuDB;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class UpdateBookController implements Initializable {

    @FXML
    private VBox vbOrderMenu;
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
    private Label lbOrderMenuOther;
    @FXML
    private BorderPane bpOrder;
    @FXML
    private TableView<BookDetail> tvOderListMini;
    @FXML
    private TableColumn<BookDetail, String> colOrderListMiniDishName;
    @FXML
    private TableColumn<BookDetail, Integer> colOrderListMiniDishPrice;
    @FXML
    private TableColumn<BookDetail, Integer> colOrderListMiniDishQuantity;
    @FXML
    private Label lbOrderID;
    @FXML
    private ComboBox<String> cbOrderCatalogies;
    @FXML
    private TextArea taOrderNote;
    @FXML
    private Button btnOrderMiniSend;
    @FXML
    private Button btnOrderMiniRemove;
    @FXML
    private Button btnOrderMiniDelete;
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
    private ImageView imgOrderMenu;
    @FXML
    private Label lbOrderDishName;
    @FXML
    private Spinner<Integer> snOrderDishQuantity;
    @FXML
    private TextArea taOrderDishDescription;
    @FXML
    private Button btnOrderMenuAdd;
    private Image image;
    @FXML
    private Label lbUserName;
    @FXML
    private Label lbDate;
    @FXML
    private Label lbTime;
    @FXML
    private BorderPane bpUpdateBook;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showOrderMenuDB();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
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
            addToOderList();
            insert("update Inventory set productQOH-=(select a.dishConsume*" + snOrderDishQuantity.getValue() + " as ingredientDown from Menu a join Book b on a.dishName =b.bookDishName where b.bookDishName=N'" + om.getMenuDishName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getMenuDishName() + "')");
            showOrderMenuDB();
            showBookDetailDB(lbUserName.getText(), lbOrderID.getText());
        }
        if (event.getSource() == btnOrderMiniSend) {
            Stage stage = (Stage) bpUpdateBook.getScene().getWindow();
            stage.close();
        }
        if (event.getSource() == btnOrderMiniRemove) {
            BookDetail om = tvOderListMini.getSelectionModel().getSelectedItem();
            if (om.getBookDishQuantity() != 1) {
                update("update [Book] set bookDishQuantity-=1 where bookDishName=N'" + om.getBookDishName() + "' and bookCustomerName='" + lbUserName.getText() + "' and bookID=" + lbOrderID.getText() + "");
                insert("update Inventory set productQOH+=(select a.dishConsume*1 as ingredientUp from Menu a join Book b on a.dishName =b.bookDishName where b.bookDishName=N'" + om.getBookDishName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getBookDishName() + "')");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getBookDishName() + "')");
                showBookDetailDB(lbUserName.getText(), lbOrderID.getText());
                showOrderMenuDB();
            } else {
                insert("update Inventory set productQOH+=(select a.dishConsume*1 as ingredientUp from Menu a join Book b on a.dishName =b.bookDishName where b.bookDishName=N'" + om.getBookDishName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getBookDishName() + "')");
                delete("delete from [Book] where bookDishName=N'" + om.getBookDishName() + "' and bookCustomerName='" + lbUserName.getText() + "' and bookID=" + lbOrderID.getText() + "");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getBookDishName() + "')");
                showBookDetailDB(lbUserName.getText(), lbOrderID.getText());
                showOrderMenuDB();
            }
        }
        if (event.getSource() == btnOrderMiniDelete) {
            if (alertConFirm("Are you want to delete order?") == true) {
                BookDetail om = tvOderListMini.getSelectionModel().getSelectedItem();
                insert("update Inventory set productQOH+=(select a.dishConsume*" + om.getBookDishQuantity() + " as ingredientUp from Menu a join Book b on a.dishName =b.bookDishName where b.bookDishName=N'" + om.getBookDishName() + "') where productName=(select dishIngredient from Menu  where dishName=N'" + om.getBookDishName() + "')");
                delete("delete from [Book] where where bookDishName=N'" + om.getBookDishName() + "' and bookCustomerName='" + lbUserName.getText() + "' and bookID=" + lbOrderID.getText() + "");
                update("update Menu set dishStatus='Available' where dishIngredient = (select dishIngredient from Menu where dishName=N'" + om.getBookDishName() + "')");
                showBookDetailDB(lbUserName.getText(), lbOrderID.getText());
                showOrderMenuDB();
                alertSuccess("Delete Order Successfully!");
            }
        }
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.NONE, mess, ButtonType.OK);
        alert.setTitle("Notification!");
        Optional<ButtonType> result = alert.showAndWait();
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

    public void setInfo(String id, String username, String catalog, String note, String date, String time) {
        lbOrderID.setText(id);
        lbUserName.setText(username);
        cbOrderCatalogies.setValue(catalog);
        taOrderNote.setText(note);
        lbDate.setText(date);
        lbTime.setText(time);
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

    private void addToOderList() {
        OrderMenuDB o = tvOrderMenu.getSelectionModel().getSelectedItem();
        String sql = "select * from [Book] where bookDishName=N'" + o.getMenuDishName() + "' and bookCustomerName='" + lbUserName.getText() + "' and bookID=" + lbOrderID.getText() + "";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String sqlUpdate = "update [Book] set bookDishQuantity+=" + snOrderDishQuantity.getValue() + " where bookDishName=N'" + o.getMenuDishName() + "' and bookCustomerName='" + lbUserName.getText() + "' and bookID=" + lbOrderID.getText() + "";
                executeQuery(sqlUpdate);
            } else {
                String sqInsert = ("insert into Book(brandID,bookID,bookDate,bookTime,bookCustomerName,bookCatalogies,bookNote,bookDishName,bookDishQuantity,bookDishPrice) select 1," + lbOrderID.getText() + ",N'" + lbDate.getText() + "',N'" + lbTime.getText() + "',N'" + lbUserName.getText() + "',N'" + cbOrderCatalogies.getValue() + "' ,N'" + taOrderNote.getText() + "',N'" + o.getMenuDishName() + "'," + snOrderDishQuantity.getValue() + "," + o.getMenuDishPrice() + "");
                executeQuery(sqInsert);
            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<BookDetail> getBookDetailDB(String ma, String id) {
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

    public void showBookDetailDB(String ma, String id) {
        ObservableList<BookDetail> list = getBookDetailDB(ma, id);
        colOrderListMiniDishName.setCellValueFactory(new PropertyValueFactory<BookDetail, String>("bookDishName"));
        colOrderListMiniDishPrice.setCellValueFactory(new PropertyValueFactory<BookDetail, Integer>("bookDishQuantity"));
        colOrderListMiniDishQuantity.setCellValueFactory(new PropertyValueFactory<BookDetail, Integer>("bookDishPrice"));
        tvOderListMini.setItems(list);
    }
}
