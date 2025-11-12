package testsFonctionnels;

import cartes.*;
import jeu.Sabot;

public class TestSabot {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        Carte[] cartes = jeu.donnerCartes();
        Sabot sabot = new Sabot(cartes);

        System.out.println("--- Test piocher() ---");
        while (!sabot.estVide()) {
            System.out.println("Je pioche " + sabot.piocher());
        }

        System.out.println("\n--- Test avec itérateur et remove() ---");
        sabot = new Sabot(jeu.donnerCartes());
        for (var it = sabot.iterator(); it.hasNext();) {
            Carte c = it.next();
            System.out.println("Je pioche " + c);
            it.remove();
        }

        System.out.println("\n--- Test d'exception ---");
        sabot = new Sabot(jeu.donnerCartes());
        try {
            sabot.piocher(); 
            for (var it = sabot.iterator(); it.hasNext();) {
                it.next();
                sabot.ajouterCarte(new Botte(Type.ACCIDENT));
            }
        } catch (Exception e) {
            System.out.println("Exception attendue : " + e);
        }
    }
}

