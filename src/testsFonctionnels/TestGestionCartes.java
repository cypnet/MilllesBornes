package testsFonctionnels;

import cartes.*;
import utils.GestionCartes;

import java.util.*;

public class TestGestionCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> listeOrigine = new LinkedList<>(Arrays.asList(jeu.donnerCartes()));
        List<Carte> listeMelangee = new ArrayList<>(listeOrigine);

        System.out.println("Avant mélange : " + listeMelangee.size() + " cartes");
        listeMelangee = GestionCartes.melanger(listeMelangee);
        System.out.println("Après mélange : " + listeMelangee.size() + " cartes");

        System.out.println("Mélange correct ? " + GestionCartes.verifierMelange(listeOrigine, listeMelangee));

        System.out.println("Rassemblement correct ? " + GestionCartes.verifierRassemblement(listeMelangee));
    }
}

