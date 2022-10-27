/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicenseKeyPkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author roots
 */
public class SystempassController implements Initializable {
    
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label showMessage;
    @FXML
    private Button buttonOk;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        passwordField.setOnKeyTyped((event) -> {
            showMessage.setText("");
        });
        buttonOk.setOnAction((event) -> {
            if (passwordField.getText().equals("pass123")) {
                try {
                    AnchorPane root = FXMLLoader.load(getClass()
                            .getResource("/LicenseKeyPkg/licenseKeyGenerator.fxml")
                    );
                        anchorPane.getChildren().setAll(root);
                } catch (IOException ex) {
                    Logger.getLogger(SystempassController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                showMessage.setText("password is wrong");
            }
        });
    }
    
}
