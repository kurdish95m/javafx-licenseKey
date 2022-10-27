/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicenseKeyPkg;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roots
 */
public class MacAddress_LK {
    
    public static boolean isMacEqual(String mds){
        return getMds().equals(mds);
    }

    /**
     * mds address of computer 
     * @return 
     */
    public static String getMds() {
        String mac = "";
        try {
            Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
            String line;
            line = in.readLine();
            String[] result = line.split(",");
            mac = result[0].replace('"', ' ').trim();
        } catch (IOException ex) {
            Logger.getLogger(GenerateLicensekey.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mac;
    }
}
