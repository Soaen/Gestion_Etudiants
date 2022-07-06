package fr.example.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class CreateDatabase {
    public static String getDBInfo(String s) {
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
    public void createDatabase(){
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("create table etudiant(numEtud numeric,nomEtud VARCHAR(255),prenomEtud VARCHAR(255),filiereEtud VARCHAR(255));");
            stmt.executeUpdate("create table filiere(numFiliere numeric,nomFiliere VARCHAR(255));");
            System.out.println("Base de données créer !");
            System.out.println("Implémentation des étudiants et filières en cours...");
            stmt.executeUpdate("INSERT INTO etudiant (numEtud, nomEtud, prenomEtud,filiereEtud) values" +
                    " (1,'Brasseur','Julian',1)," +
                    " (2,'Vansteenkiste','Sylvain',2)," +
                    " (3,'Delecroix','Alexis',1)," +
                    " (4,'Grande','Ariana',2)," +
                    " (5,'Rock','The',2)," +
                    " (6,'Cena','John',2)," +
                    " (7,'Weeknd','The',2)," +
                    " (8,'Lexploratrice','Dora',1);");
            System.out.println("Étudiants implémenté !");
            stmt.executeUpdate("INSERT INTO etudiant (numFiliere, nomFiliere) values" +
                    " (1,'Électronique')," +
                    " (2,'Informatique');");
            System.out.println("Filières implémenté !");
            System.out.println("Base de donnée entièrement fonctionnelle.");
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
