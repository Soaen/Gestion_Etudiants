package fr.example.services;

import java.util.Scanner;

public class ServiceMenu {
    int choix = 0;
    Scanner sc = new Scanner(System.in);
    ServiceManagment sm = new ServiceManagment();
    public void startingMenu(){
        do{
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("|                                                               |");
            System.out.println("|     1. Créer la Database + ajouter les valeurs                |");
            System.out.println("|                                                               |");
            System.out.println("|     2. Recherche de chambre par Description                   |");
            System.out.println("|                                                               |");
            System.out.println("|     3. Recherche de chambre par nombre de personnes           |");
            System.out.println("|                                                               |");
            System.out.println("|     4. Rechercher par prix maximum                            |");
            System.out.println("|                                                               |");
            System.out.println("|     5. Ajouter une chambre                                    |");
            System.out.println("|                                                               |");
            System.out.println("|     6. Quitter le programme                                   |");
            System.out.println("|                                                               |");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Entrez votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
            sm.firstMenu(choix);
        }while(choix != 6);
    }
}
