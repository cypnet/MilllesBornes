package testsFonctionnels;

import cartes.*;

public class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.affichageJeuDeCartes();
        System.out.println("Le jeu est conforme A  la configuration ? " + jeu.checkCount());
    }
}

