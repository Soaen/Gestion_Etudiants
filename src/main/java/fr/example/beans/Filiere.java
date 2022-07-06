package fr.example.beans;

import fr.example.services.DatabaseManagment;

public class Filiere {

    public void searchFiliereNb(int nbFiliere){
        DatabaseManagment.searchDatabase(nbFiliere, "SELECT * FROM etudiant WHERE filiereEtud = ");
    }


}
