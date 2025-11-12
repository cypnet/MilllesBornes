package testsFonctionnels;

import jeu.*;
import cartes.*;


public class TestJeu {

    public static void main(String[] args) {

        System.out.println("=== DÉBUT DU TEST JEU ===\n");

        
        Jeu jeu = new Jeu();
        Joueur j1 = new Joueur("Jack");
        Joueur j2 = new Joueur("Bill");
        Joueur j3 = new Joueur("Luffy");

        
        jeu.inscrire(j1, j2, j3);

        
        jeu.distribuerCartes();

        
        System.out.println("Main de départ des joueurs :");
        System.out.println(j1.getNom() + " : " + j1.getMain());
        System.out.println(j2.getNom() + " : " + j2.getMain());
        System.out.println(j3.getNom() + " : " + j3.getMain());
        System.out.println("\n--- Début de la partie ---\n");

        
        String resultat = jeu.lancer();

        
        System.out.println(resultat);

        System.out.println("=== FIN DU TEST JEU ===");
    }
}

