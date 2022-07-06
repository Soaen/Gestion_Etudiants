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
                System.out.println("WIP");
                break;
            case 3:
                System.out.println("WIP");
                break;
            case 4:
                System.out.println("WIP");
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