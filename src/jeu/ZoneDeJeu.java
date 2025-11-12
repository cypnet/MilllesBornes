package jeu;

import cartes.*;
import java.util.*;


public class ZoneDeJeu {

    private Deque<Bataille> pileBataille = new ArrayDeque<>();
    private Deque<Limite> pileLimite = new ArrayDeque<>();
    private List<Borne> bornes = new ArrayList<>();
    private Set<Botte> bottes = new HashSet<>();

    public void deposer(Carte carte) {
        if (carte instanceof Borne borne) {
            bornes.add(borne);
        } else if (carte instanceof Limite limite) {
            pileLimite.push(limite);
        } else if (carte instanceof Bataille bataille) {
            pileBataille.push(bataille);
        } else if (carte instanceof Botte botte) {
            bottes.add(botte);
        }
    }

    public int donnerKmParcourus() {
        int total = 0;
        for (Borne b : bornes) {
            total += b.getKm();
        }
        return total;
    }

   

    
    public boolean estPrioritaire() {
        for (Botte b : bottes) {
            if (b.getType() == Type.FEU) return true;
        }
        return false;
    }

    
    public int donnerLimitationVitesse() {
        if (estPrioritaire()) return 200; 
        if (!pileLimite.isEmpty() && pileLimite.peek() instanceof DebutLimite) {
            return 50;
        }
        return 200;
    }

    
    public boolean peutAvancer() {
        if (pileBataille.isEmpty() && estPrioritaire()) return true;

        Bataille sommet = pileBataille.peek();
        if (sommet instanceof Parade && sommet.getType() == Type.FEU) return true;
        if (sommet instanceof Attaque && estPrioritaire()) return true;

        if (sommet instanceof Attaque) {
            for (Botte b : bottes) {
                if (b.getType() == sommet.getType()) return true;
            }
        }

        return false;
    }

    
    public boolean estDepotFeuVertAutorise() {
        if (estPrioritaire()) return false;
        if (pileBataille.isEmpty()) return true;

        Bataille sommet = pileBataille.peek();
        if (sommet instanceof Attaque && sommet.getType() == Type.FEU) return true;
        if (sommet instanceof Parade && sommet.getType() != Type.FEU) return true;

        for (Botte b : bottes) {
            if (b.getType() == sommet.getType()) return true;
        }

        return false;
    }

    
    public boolean estDepotLimiteAutorise() {
    	return !estPrioritaire();
    }

    
    public boolean estDepotBatailleAutorise(Bataille bataille) {
        for (Botte b : bottes) {
            if (b.getType() == bataille.getType()) return false;
        }
        return true;
    }

    
    public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Botte) return true; 
        if (carte instanceof Borne) return peutAvancer();
        if (carte instanceof Limite) return estDepotLimiteAutorise();
        if (carte instanceof Bataille bataille) return estDepotBatailleAutorise(bataille);
        return false;
    }
}




