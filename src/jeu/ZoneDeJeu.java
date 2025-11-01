package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.*;

public class ZoneDeJeu {

    private List<Limite> pileLimites;
    private List<Bataille> pileBatailles;
    private List<Borne> collectionBornes;

    public ZoneDeJeu() {
        this.pileLimites = new ArrayList<>();
        this.pileBatailles = new ArrayList<>();
        this.collectionBornes = new ArrayList<>();
    }

    /* ===================== PARTIE 2 ===================== */

    public int donnerLimitationVitesse() {
        if (pileLimites.isEmpty()) {
            return 200;
        }
        Limite sommet = pileLimites.get(pileLimites.size() - 1);
        if (sommet instanceof FinLimite) {
            return 200;
        }
        return 50;
    }

    public int donnerKmParcourus() {
        int total = 0;
        for (Borne b : collectionBornes) {
            total += b.getKm();
        }
        return total;
    }

    public void deposer(Carte c) {
        System.out.println("Déposer carte " + c);

        if (c instanceof Borne) {
            collectionBornes.add((Borne) c);
        } else if (c instanceof Limite) {
            pileLimites.add((Limite) c);
        } else if (c instanceof Bataille) {
            pileBatailles.add((Bataille) c);
        }
    }

    /* ===================== PARTIE 3 ===================== */

    public boolean peutAvancer() {
        if (pileBatailles.isEmpty()) return false;
        Bataille sommet = pileBatailles.get(pileBatailles.size() - 1);
        return (sommet instanceof Parade)
                && ((Parade) sommet).getType() == Type.FEU;
    }

    public boolean estDepotFeuVertAutorise() {
        if (pileBatailles.isEmpty()) return true;
        Bataille sommet = pileBatailles.get(pileBatailles.size() - 1);
        return (sommet instanceof Attaque && ((Attaque) sommet).getType() == Type.FEU)
                || (sommet instanceof Parade && ((Parade) sommet).getType() != Type.FEU);
    }

    public boolean estDepotBorneAutorise(Borne borne) {
        if (!peutAvancer()) return false;
        if (borne.getKm() > donnerLimitationVitesse()) return false;
        if (donnerKmParcourus() + borne.getKm() > 1000) return false;
        return true;
    }

    public boolean estDepotLimiteAutorise(Limite limite) {
        if (limite instanceof DebutLimite) {
            return pileLimites.isEmpty() ||
                   pileLimites.get(pileLimites.size() - 1) instanceof FinLimite;
        } else if (limite instanceof FinLimite) {
            return !pileLimites.isEmpty() &&
                   pileLimites.get(pileLimites.size() - 1) instanceof DebutLimite;
        }
        return false;
    }

    public boolean estDepotBatailleAutorise(Bataille bataille) {
        if (bataille instanceof Attaque) {
            return peutAvancer();
        } else if (bataille instanceof Parade) {
            Parade p = (Parade) bataille;
            if (p.getType() == Type.FEU) {
                return estDepotFeuVertAutorise();
            } else {
                if (pileBatailles.isEmpty()) return false;
                Bataille sommet = pileBatailles.get(pileBatailles.size() - 1);
                return (sommet instanceof Attaque)
                        && ((Attaque) sommet).getType() == p.getType();
            }
        }
        return false;
    }

    public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Borne) {
            return estDepotBorneAutorise((Borne) carte);
        } else if (carte instanceof Limite) {
            return estDepotLimiteAutorise((Limite) carte);
        } else if (carte instanceof Bataille) {
            return estDepotBatailleAutorise((Bataille) carte);
        }
        return false;
    }

    @Override
    public String toString() {
        return "ZoneDeJeu{" +
                "Limites=" + pileLimites +
                ", Batailles=" + pileBatailles +
                ", Bornes=" + collectionBornes +
                '}';
    }
}

