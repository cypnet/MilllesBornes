package jeu;

import cartes.*;
import utils.GestionCartes;
import java.util.*;

public class Jeu {
    private Sabot sabot;

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] cartes = jeuDeCartes.donnerCartes();
        List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, cartes);

        listeCartes = GestionCartes.melanger(listeCartes);

        this.sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }

    public Sabot getSabot() {
        return sabot;
    }
}

