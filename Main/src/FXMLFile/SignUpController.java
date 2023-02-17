/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField tfSignUpFullName;
    @FXML
    private DatePicker tfSignUpDOB;
    @FXML
    private TextField tfSignUpMail;
    @FXML
    private TextField tfSignUpAddress;
    @FXML
    private TextField tfSignUpPhone;
    @FXML
    private TextField tfSignUpUserName;
    @FXML
    private PasswordField tfSignUpPassWord1;
    @FXML
    private PasswordField tfSignUpPassWord2;
    @FXML
    private Button btnAccountCreate;
    @FXML
    private Button btnAccountClear;
    @FXML
    private Button btnAccountClose;
    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private BorderPane bpSignUp;
    @FXML
    private ImageView imgCustomer;
    @FXML
    private Button btnImageBrowser;
    private FileChooser fileChooser;
    private File file;
    private Stage stage;
    private final Desktop deskTop = Desktop.getDesktop();
    private Image image;
    private FileInputStream fis;

    ToggleGroup gender = new ToggleGroup();
    @FXML
    private Label lbCheck;
    @FXML
    private Label lbCheckMail;
    @FXML
    private Label lbCheckPhone;
    @FXML
    private Button tgPassword1;
    @FXML
    private Button tgPassword2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files", "* *"),
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Text File", "*.txt")
        );
        rbMale.setToggleGroup(gender);
        rbFemale.setToggleGroup(gender);
        rbMale.isSelected();
        tfSignUpDOB.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
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

    private void alert(String mess) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mess, ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
    }

    private void insertCustomer() {
        //1 tao ket noi
        Connection cn = getConnect();
        //2 tao doi tuong chua lenh insert
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?)";

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
            st.setString(7, tfSignUpUserName.getText());
            fis = new FileInputStream(file);
            st.setBinaryStream(8, fis, file.length());
            //4 thuc hien insert sql
            st.executeUpdate();
//            st.close();
//            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.NONE, mess, ButtonType.OK);
        alert.setTitle("Message");
        Optional<ButtonType> result = alert.showAndWait();
    }

    private void checkUserName() {
        String sql = "select * from Account where accountUserName=N'" + tfSignUpUserName.getText() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                lbCheck.setText("Your Username is used");
                btnAccountCreate.setDisable(true);
            } else {
                btnAccountCreate.setDisable(false);
                lbCheck.setText("");
            }
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
                lbCheckPhone.setText("Your Phone is used");
                btnAccountCreate.setDisable(true);
            } else {
                btnAccountCreate.setDisable(false);
                lbCheckPhone.setText("");
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
                lbCheckMail.setText("Your Mail is used");
                btnAccountCreate.setDisable(true);
            } else {
                btnAccountCreate.setDisable(false);
                lbCheckMail.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        if (event.getSource() == btnAccountCreate) {
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
            } else if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", tfSignUpPassWord2.getText())) {
                alert("Confirm Password must contain at least 1 digit [0-9],\n"
                        + "One lowercase [a-z],"
                        + "One uppercase [A-Z],\n"
                        + "One special character like !@#.\n"
                        + "8-20 characters");
            } else if (!Pattern.matches(tfSignUpPassWord1.getText(), tfSignUpPassWord2.getText())) {
                alert("Password is not same");
            } else if (imgCustomer.getImage() == null) {
                alert("Please choose image");
            } else {
                alertSuccess("Successfully Sign Up");
                insert("insert into Account values (N'" + tfSignUpUserName.getText() + "',N'" + tfSignUpPassWord1.getText() + "', 'Customer')");
                insertCustomer();
            }
        }
        if (event.getSource() == btnAccountClear) {
            tfSignUpFullName.clear();
            tfSignUpDOB.setValue(null);
            tfSignUpMail.clear();
            tfSignUpAddress.clear();
            tfSignUpPhone.clear();
            tfSignUpUserName.clear();
            tfSignUpPassWord1.clear();
            tfSignUpPassWord2.clear();
            imgCustomer.setImage(null);
        }
        if (event.getSource() == btnAccountClose) {
            Stage stage = (Stage) bpSignUp.getScene().getWindow();
            stage.close();
        }
        if (event.getSource() == btnImageBrowser) {
            stage = (Stage) bpSignUp.getScene().getWindow();
            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                System.out.println("" + file.getAbsolutePath());
                image = new Image(file.getAbsoluteFile().toURI().toString(), imgCustomer.getFitWidth(), imgCustomer.getFitHeight(), true, true);
                imgCustomer.setImage(image);
                imgCustomer.setPreserveRatio(true);
            }
        }
    }
    private String password1;
    private String password2;
    private int n = 1;

    @FXML
    private void showPassword1() {
        password1 = tfSignUpPassWord1.getText();
        tfSignUpPassWord1.clear();
        tfSignUpPassWord1.setPromptText(password1);
    }

    @FXML
    private void hidePassword1() {
        password1 = tfSignUpPassWord1.getPromptText();
        tfSignUpPassWord1.setText(password1);
        tfSignUpPassWord1.setPromptText("Password");
    }

    @FXML
    private void showPassword2() {
        password2 = tfSignUpPassWord2.getText();
        tfSignUpPassWord2.clear();
        tfSignUpPassWord2.setPromptText(password2);
    }

    @FXML
    private void hidePassword2() {
        password2 = tfSignUpPassWord2.getPromptText();
        tfSignUpPassWord2.setText(password2);
        tfSignUpPassWord2.setPromptText("Enter your Password again");
    }

    @FXML
    private void handleTypeAction(KeyEvent event) {
        if (event.getSource() == tfSignUpUserName) {
            checkUserName();
        }
        if (event.getSource() == tfSignUpPhone) {
            checkPhone();
        }
        if (event.getSource() == tfSignUpMail) {
            checkMail();
        }
    }

}
