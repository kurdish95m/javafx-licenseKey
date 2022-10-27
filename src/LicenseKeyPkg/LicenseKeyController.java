package LicenseKeyPkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author roots
 */
public class LicenseKeyController implements Initializable {

    @FXML
    private TextField textFieldFullName;
    @FXML
    private TextField textFieldRegistrationCode;
    @FXML
    private Button buttonGetCode;
    @FXML
    private Button buttonBuy;
    @FXML
    private Button buttonRegistar;
    @FXML
    private Label showMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showMessage.setVisible(false);
        buttonGetCode.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 3) {
                try {
                    Parent root = new FXMLLoader(getClass()
                            .getResource("/LicenseKeyPkg/systempass.fxml"))
                            .load();
                    Stage s = new Stage();
                    s.setScene(new Scene(root));
                    s.show();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        buttonRegistar.setOnMouseClicked((event) -> {
            ActivationApplication ap = new ActivationApplication();
            licensKeyObj licensKeyObj = new licensKeyObj(
                    textFieldFullName.getText(),
                    textFieldRegistrationCode.getText(),
                    MacAddress_LK.getMds()
            );
            ap.save(licensKeyObj);
            showMessage.setVisible(true);
        });
        buttonBuy.setOnMouseClicked((event) -> {

        });

    }
}
