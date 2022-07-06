package fr.example.services;

import fr.example.beans.Filiere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

import static fr.example.services.CreateDatabase.getDBInfo;

public class ServiceExecutor {
    Scanner sc = new Scanner(System.in);
    Filiere filiere = new Filiere();

    public void askSearchFiliere(){
        showFiliere();
        System.out.println("Quel est la filière qui vous intéresse ?");
        int tempfil = sc.nextInt();
        while (tempfil > 2 || tempfil < 0){
            System.out.println("La valeur doit être supérieur a 2 et inférieur à 0 !");
            System.out.println("Quel est la filière qui vous intéresse ?");
            tempfil = sc.nextInt();
        }
        filiere.searchFiliereNb(tempfil);
    }

    public void showFiliere(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM filiere";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int nb = res.getInt("numFiliere");
                String descstring = res.getString("nomFiliere");
                System.out.println(nb + " : " + descstring);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
