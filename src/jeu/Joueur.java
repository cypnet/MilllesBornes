package jeu;

import cartes.Carte;

public class Joueur {
    private String nom;
    private ZoneDeJeu zone;
    private MainJoueur main;

    public Joueur(String nom) {
        this.nom = nom;
        this.zone = new ZoneDeJeu();
        this.main = new MainJoueur();
    }

    public String getNom() {
        return nom;
    }

    public ZoneDeJeu getZone() {
        return zone;
    }

    public MainJoueur getMain() {
        return main;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Joueur)) return false;
        Joueur other = (Joueur) obj;
        return nom != null && nom.equalsIgnoreCase(other.nom);
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.toLowerCase().hashCode() : 0;
    }

    @Override
    public String toString() {
        return nom;
    }

    public void donner(Carte carte) {
        main.prendre(carte);
    }

    public Carte prendreCarte(Sabot sabot) {
        if (sabot.estVide()) return null;
        Carte carte = sabot.piocher();
        main.prendre(carte);
        return carte;
    }

    public void deposer(Carte c) {
        zone.deposer(c);
    }

    public int donnerKmParcourus() {
        return zone.donnerKmParcourus();
    }

    public boolean estDepotAutorise(Carte c) {
        return zone.estDepotAutorise(c);
    }
}

