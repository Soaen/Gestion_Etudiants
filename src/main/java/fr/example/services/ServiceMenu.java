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
            System.out.println("|     2. Afficher les étudiants d'une filière                   |");
            System.out.println("|                                                               |");
            System.out.println("|     3. Afficher tous les étudiants                            |");
            System.out.println("|                                                               |");
            System.out.println("|     4. Changer le prénom ou le nom d'un étudiant              |");
            System.out.println("|                                                               |");
            System.out.println("|     5. Ajouter un étudiant                                    |");
            System.out.println("|                                                               |");
            System.out.println("|     6. Supprimé un étudiant                                   |");
            System.out.println("|                                                               |");
            System.out.println("|     7. Quitter le programme                                   |");
            System.out.println("|                                                               |");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Entrez votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
            sm.firstMenu(choix);
        }while(choix != 7);
    }
}
