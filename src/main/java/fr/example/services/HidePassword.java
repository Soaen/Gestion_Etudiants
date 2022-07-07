package fr.example.services;

import java.io.*;
import java.util.Properties;

public class HidePassword {
    static String yourFile = "src/main/resources/config.properties";
    static String yourContent = "DB_URL=jdbc:postgresql://localhost/\n#Default DB_URL: jdbc:postgresql://localhost/\n\nDB_USER=postgres\n#Default DB_USER: postgres\n\nDB_PASSWORD=admin\n#Default DB_PASSWORD: admin";

    static File tmpDir = new File(yourFile);
    static boolean exists = tmpDir.exists();

    public static String getDBInfo(String s) throws IOException {
        if(!exists) {
            FileOutputStream fos = new FileOutputStream(yourFile);
            fos.write(yourContent.getBytes());
            fos.flush();
            fos.close();
        }
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            if (prop.getProperty(s) == null) {System.out.println("La valeur " + s + " n'existe pas !");}
            return prop.getProperty(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
