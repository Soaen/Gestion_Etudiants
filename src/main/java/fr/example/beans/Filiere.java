package fr.example.beans;

import fr.example.services.DatabaseManagment;

public class Filiere {

    public void searchFiliereNb(int nbFiliere){DatabaseManagment.searchDatabase(nbFiliere, "SELECT * FROM etudiant WHERE filiereEtud = ");}
    public void changePrenom(int i, String arg1){
        DatabaseManagment.changeDataPrenom(i, arg1);
    }
    public void changeNom(int i, String arg1){
        DatabaseManagment.changeDatanom(i, arg1);
    }
    public void changePrenomNom(int i, String arg1, String arg2){DatabaseManagment.changeDatanomprenom(i, arg1, arg2);}
    public void addEtudiant(int id, String nom, String prenom,int idfil){DatabaseManagment.addUser(id, nom, prenom, idfil);}
    public void removeEtudiant(int id){
        DatabaseManagment.removeUser(id);
    }
}