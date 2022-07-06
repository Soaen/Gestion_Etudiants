package fr.example.services;

public class ServiceManagment {
    ServiceExecutor se = new ServiceExecutor();
    CreateDatabase cdb = new CreateDatabase();
    public void firstMenu(int choix) {
        switch (choix){
            case 1 :
                cdb.createDatabase();
                break;
            case 2:
                se.askSearchFiliere();
                break;
            case 3:
                se.showEtudiant();
                break;
            case 4:
                se.replaceEtud();
                break;
            case 5:
                System.out.println("WIP");
                break;
            case 6:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Le nombre doit être compris entre 1 et 6 !");
        }
    }
}