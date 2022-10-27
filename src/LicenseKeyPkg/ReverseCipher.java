package LicenseKeyPkg;

/**
 * 
 * @author roots
 */
public class ReverseCipher {
    public String encryption(String mac) {
        String cipher = "";
        char[] ch = mac.toCharArray();
        for (int i = 0; i < mac.length(); i++) {
            int index = ch[i] - 97;
            cipher += (char) ((index + 97) + 97);
        }
        String reverseString = reverseString(cipher);
        return reverseString;
    }
    public String decryption(String mac) {
        mac = reverseString(mac);
        String cipher = "";
        char[] ch = mac.toCharArray();
        for (int i = 0; i < mac.length(); i++) {
            int index = ch[i] - 97;
            cipher += (char) ((index - 97) + 97);
        }
        return cipher;
    }
    public String reverseString(String str) {
        char ch[] = str.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        return rev;
    }
}
