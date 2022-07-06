package fr.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import static fr.example.services.CreateDatabase.getDBInfo;

public class DatabaseManagment {
    public static void searchDatabase(int id, String dataRecover) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            Statement stmt = conn.createStatement();
            String sql = dataRecover + id;
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int numero = res.getInt("numEtud");
                String nom = res.getString("nomEtud");
                String prenom = res.getString("prenomEtud");
                int filiereEtud = res.getInt("filiereEtud");
                System.out.println("Numéro de l'Étudiant: " + numero);
                System.out.println("Nom de l'Étudiant: " + nom);
                System.out.println("Prenom de l'Étudiant: " + prenom);
                filiere(filiereEtud);
                System.out.println(" ");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void filiere(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(Objects.requireNonNull(getDBInfo("DB_URL")), Objects.requireNonNull(getDBInfo("DB_USER")), Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM filiere WHERE numFiliere = " + id;
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                String descstring = res.getString("nomFiliere");
                System.out.println("Filière de l'Étudiant: " + descstring);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
