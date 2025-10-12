package testsFonctionnels;

import cartes.*;

public class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.affichageJeuDeCartes();
        System.out.println("Le jeu est conforme à la configuration ? " + jeu.checkCount());
    }
}

