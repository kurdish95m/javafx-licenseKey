/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicenseKeyPkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LicenseKeyList {

    public ArrayList<String> LicenseKeyList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 999199; i < 999299; i++) {
            list.add(new GenerateLicensekey().Generate("" + i));
        }
        return list;

    }

    /**
     * add list of License Key to License Key.txt
     */
    public void addToFile() {
        LicenseKeyList().forEach((t) -> {
            append(t);
        });
    }

    private final File file = new File("License Key.txt");

    /**
     * use for append to License Key.txt
     */
    private void append(String message) {
        try {
            if (file.createNewFile()) {
                String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                        .format(new Date());
                System.out.println("File created: " + file.getName());
                write("Last update is " + date);
            } else {
                //  System.out.println("File already exists.");
            }
            write(message);
        } catch (IOException ex) {
            Logger.getLogger(LicenseKeyList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * use for write to License Key.txt
     *
     * @param message
     * @throws java.io.IOException
     */
    public static void write(String message) throws IOException {
        try (FileWriter fw = new FileWriter("License Key.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw)) {
            pw.println(message);
            pw.flush();
        } catch (Exception ex) {
            Logger.getLogger(LicenseKeyList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * use for read list of License Key and add to ArrayList<String> list
     *
     * @return ArrayList<String> list
     */
    public ArrayList<String> read() {
        ArrayList<String> list = new ArrayList<>();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (Scanner myReader = new Scanner(file)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    list.add(data);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LicenseKeyList.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println("An error occurred.");
        } catch (IOException ex) {
            Logger.getLogger(LicenseKeyList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * read Resource As Stream /app/License Key.txt
     *
     * @return
     */
    public ArrayList<String> readResourceAsStream() {
        ArrayList<String> list = new ArrayList<>();
        try {
            InputStream requireNonNull
                    = Objects.requireNonNull(getClass()
                            .getResourceAsStream("/LicenseKeyPkg/License Key.txt")
                    );
            Scanner myReader = new Scanner(requireNonNull);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    /**
     * @param licensKey
     * @return
     */
    public boolean isLicensKeyExists(String licensKey) {
        boolean state = false;
        for (String s : readResourceAsStream()) {
            if (licensKey.equals(s)) {
                state = true;
                System.out.println("licens Key is exists >> [ AAAAA-AAXXX-XXXXX-XXXXX-XXXXX ]");
                break;
            }
        }
        return state;
    }

    /**
     *
     * @return
     */
    public licensKeyObj getLicensInfo() {
        try {
            String extension = "properties";
            File directory = new File("data/sec/");
            File f = new File("data/sec/licens." + extension);
            if (!directory.exists()) {
                directory.mkdirs();
                f.createNewFile();
                System.out.println("directory mdk [data/settings/]");
                System.out.println("file create New File " + f.getAbsolutePath());
                savelicensKey(new licensKeyObj());
            } else if (!f.exists()) {
                f.createNewFile();
                System.out.println("file create New File " + f.getAbsolutePath());
                savelicensKey(new licensKeyObj());
            }
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream(f);
            properties.load(inputStream);

            licensKeyObj obj = new licensKeyObj();

            obj.setLicensKey(properties.getProperty("licensKey"));
            obj.setMac(properties.getProperty("mac"));
            obj.setPersonalName(properties.getProperty("personalName"));

            return obj;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    /**
     *
     * @param so
     * @return
     */
    public boolean savelicensKey(licensKeyObj so) {
        try {
            Properties properties = new Properties();
            String extension = "properties";
            File directory = new File("data/sec/");
            File f = new File("data/sec/licens." + extension);
            if (!directory.exists()) {
                directory.mkdirs();
                f.createNewFile();
            } else if (!f.exists()) {
                f.createNewFile();
            }
            FileInputStream inputStream = new FileInputStream(f);
            properties.load(inputStream);

            FileOutputStream outputStream = new FileOutputStream(f);

            properties.setProperty("licensKey", String.valueOf(so.getLicensKey()));
            properties.setProperty("mac", String.valueOf(so.getMac()));
            properties.setProperty("personalName", String.valueOf(so.getPersonalName()));

            properties.store(outputStream, "Update Section");
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
