package jeu;

import cartes.*;


public class Coup {

    private Joueur joueur;
    private Carte carte;
    private Joueur cible;

    public Coup(Joueur joueur, Carte carte, Joueur cible) {
        this.joueur = joueur;
        this.carte = carte;
        this.cible = cible;
    }

    public Joueur getJoueur() { return joueur; }
    public Carte getCarte() { return carte; }
    public Joueur getCible() { return cible; }

   
    public boolean estValide() {
        if (carte instanceof Attaque || carte instanceof Limite) {
            return cible != null && !cible.equals(joueur);
        }
        return cible == joueur;
    }

    @Override
    public String toString() {
        if (cible == null) {
            return joueur.getNom() + " défausse la carte " + carte;
        } else {
            return joueur.getNom() + " dépose la carte " + carte +
                   " dans la zone de jeu de " + cible.getNom();
        }
    }
}

