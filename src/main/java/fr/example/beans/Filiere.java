package fr.example.beans;

import fr.example.services.DatabaseManagment;

public class Filiere {

    public void searchFiliereNb(int nbFiliere){
        DatabaseManagment.searchDatabase(nbFiliere, "SELECT * FROM etudiant WHERE filiereEtud = ");
    }

    public void changeprenom(int i, String arg1){
        DatabaseManagment.changeDataPrenom(i, arg1);
    }
    public void changenom(int i, String arg1){
        DatabaseManagment.changeDatanom(i, arg1);
    }
    public void changeprenomnom(int i, String arg1, String arg2){
        DatabaseManagment.changeDatanomprenom(i, arg1, arg2);
    }


}
