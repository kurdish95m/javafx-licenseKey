package LicenseKeyPkg;

/**
 * private String licensKey; private String mac;
 *
 * @author roots
 */
public final class licensKeyObj {

    private String personalName;
    private String licensKey;
    private String mac;

    public void encryption() {
        this.licensKey = new ReverseCipher().encryption(licensKey);
        this.mac = new ReverseCipher().encryption(mac);
    }

    public void decryption() {
        this.licensKey = new ReverseCipher().decryption(licensKey);
        this.mac = new ReverseCipher().decryption(mac);
    }

    public licensKeyObj() {
        personalName = "";
        licensKey = "";
        mac = "";
    }

    public licensKeyObj(String personalName, String licensKey, String mac) {
        this.personalName = personalName;
        this.licensKey = licensKey;
        this.mac = mac;
    }

    /**
     * @return the personalName
     */
    public String getPersonalName() {
        return personalName;
    }

    /**
     * @param personalName the personalName to set
     */
    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    /**
     * @return the licensKey
     */
    public String getLicensKey() {
        return licensKey;
    }

    /**
     * @param licensKey the licensKey to set
     */
    public void setLicensKey(String licensKey) {
        this.licensKey = licensKey;
    }

    /**
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the mac to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "licensKeyObj{" + "personalName=" + personalName + ", licensKey=" + licensKey + ", mac=" + mac + '}';
    }

}
