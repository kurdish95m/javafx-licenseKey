package LicenseKeyPkg;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActivationApplication {

    public void activeAppUi(Stage stage) {
        try {
            Parent root = new FXMLLoader(getClass()
                    .getResource("/LicenseKeyPkg/licenseKey.fxml"))
                    .load();
            stage.setTitle("Activeation");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public licensKeyObj getLicensInfo() {
        LicenseKeyList ls = new LicenseKeyList();
        licensKeyObj licensInfo = ls.getLicensInfo();
        licensInfo.decryption();
        return licensInfo;
    }

    public void save(licensKeyObj licensKeyObj) {
        licensKeyObj.encryption();
        LicenseKeyList ls = new LicenseKeyList();
        ls.savelicensKey(licensKeyObj);
    }

    public boolean checkIsActive() {
        boolean state = false;
        licensKeyObj licensInfo = getLicensInfo();
        if (MacAddress_LK.isMacEqual(licensInfo.getMac())
                && isLicensKeyExists(licensInfo.getLicensKey())) {
            state = true;
        }
        return state;
    }

    public boolean isLicensKeyExists(String licensKey) {
        return new LicenseKeyList().isLicensKeyExists(licensKey);
    }

}
