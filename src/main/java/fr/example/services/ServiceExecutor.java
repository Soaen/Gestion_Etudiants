package fr.example.services;

import fr.example.beans.Filiere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

import static fr.example.services.CreateDatabase.getDBInfo;
import static fr.example.services.DatabaseManagment.filiere;

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

    public void showEtudiant(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    Objects.requireNonNull(getDBInfo("DB_URL")),
                    Objects.requireNonNull(getDBInfo("DB_USER")),
                    Objects.requireNonNull(getDBInfo("DB_PASSWORD")));
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM etudiant";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int nb = res.getInt("numEtud");
                String nom = res.getString("nomEtud");
                String prenom = res.getString("prenomEtud");
                int fili = res.getInt("filiereEtud");
                System.out.println("Numéro de l'Étudiant: " + nb);
                System.out.println("Nom de l'Étudiant: " + nom);
                System.out.println("Prenom de l'Étudiant: " + prenom);
                filiere(fili);
                System.out.println(" ");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replaceEtud(){
        System.out.println("Que voulez vous changer ?");
        System.out.println("1: Prénom");
        System.out.println("2: Nom");
        System.out.println("3: Nom et Prénom");
        int tempchoix = sc.nextInt();
        while(tempchoix > 3 || tempchoix < 1){
            System.out.println("Choix invalide ! Recommencez !");
            System.out.println("Que voulez vous changer ?");
            System.out.println("1: Prénom");
            System.out.println("2: Nom");
            System.out.println("3: Nom et Prénom");
            tempchoix = sc.nextInt();
        }
    }

}
