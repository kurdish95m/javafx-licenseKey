/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicenseKeyPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author roots
 */
public class LicenseKeyGeneratorController implements Initializable {

    @FXML
    private TextField textFieldProduceId;
    @FXML
    private ComboBox<?> comboBoxLicenseType;
    @FXML
    private DatePicker datePickerDate;
    @FXML
    private TextField textFieldProduceKey;
    @FXML
    private Button buttonGenerate;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonGenerate.setOnAction((event) -> {
            if (validProduceId()) {
                textFieldProduceKey.setText(
                        new GenerateLicensekey()
                                .Generate(textFieldProduceId.getText())
                );
            } else {
                System.out.println("textFieldProduceId is empty ");
            }  
        });
    }

    boolean validProduceId() {
        return !textFieldProduceId.getText().isEmpty();
    }
}
