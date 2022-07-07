package fr.example;

import fr.example.services.ServiceMenu;

import static fr.example.services.HidePassword.getDBInfo;

public class Main {
    public static void main(String[] args) {
        ServiceMenu sm = new ServiceMenu();
        sm.startingMenu();
    }
}