package jeu;

import cartes.*;
import java.util.*;


public class Joueur {

    private String nom;
    private MainJoueur main;
    private ZoneDeJeu zone;

    public Joueur(String nom) {
        this.nom = nom;
        this.main = new MainJoueur();
        this.zone = new ZoneDeJeu();
    }

    public String getNom() { return nom; }
    public ZoneDeJeu getZone() { return zone; }
    public MainJoueur getMain() { return main; }

    public void donner(Carte c) { main.prendre(c); }
    public void deposer(Carte c) { zone.deposer(c); }
    public int donnerKmParcourus() { return zone.donnerKmParcourus(); }

   
    public void retirerDeLaMain(Carte carte) {
        main.jouer(carte);
    }

 
    public Set<Coup> coupsPossibles(Set<Joueur> participants) {
        Set<Coup> coups = new HashSet<>();
        for (Carte c : main) {
            for (Joueur cible : participants) {
                Coup coup = new Coup(this, c, cible);
                if (coup.estValide()) {
                    coups.add(coup);
                }
            }
        }
        return coups;
    }

  
    public Set<Coup> coupsDefausse() {
        Set<Coup> defausses = new HashSet<>();
        for (Carte c : main) {
            defausses.add(new Coup(this, c, null));
        }
        return defausses;
    }


    public Coup choisirCoup(Set<Joueur> participants) {
        Random rand = new Random();
        Set<Coup> coups = coupsPossibles(participants);

        if (!coups.isEmpty()) {
            List<Coup> liste = new ArrayList<>(coups);
            return liste.get(rand.nextInt(liste.size()));
        }

        List<Coup> defausses = new ArrayList<>(coupsDefausse());
        return defausses.get(rand.nextInt(defausses.size()));
    }

    
    public String afficherEtatJoueur() {
        return "Joueur " + nom + "\n"
                + "Bottes : " + zone + "\n"
                + "Limite : " + zone.donnerLimitationVitesse() + "\n"
                + "Main : " + main + "\n";
    }

    @Override
    public String toString() {
        return nom;
    }
}



