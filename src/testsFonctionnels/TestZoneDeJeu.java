package testsFonctionnels;

import cartes.*;
import jeu.*;

/**
 * Tests de la classe ZoneDeJeu (TP3 - Partie 3)
 * 
 * Résultats attendus :
 * Deposer carte 25 km
 * Deposer carte 50 km
 * Deposer carte 75 km
 * Total des bornes : 150
 * Limite : 200
 * Limite : 50
 * Limite : 200
 * ...
 * Et tests des dépôts autorisés (feux, attaques, bornes, limites)
 */
public class TestZoneDeJeu {

    public static void main(String[] args) {

        System.out.println("=== TEST ZONE DE JEU ===\n");

        Joueur joueur = new Joueur("Alice");
        ZoneDeJeu zone = joueur.getZone();

        /* --- Dépôt de bornes --- */
        Borne b25 = new Borne(25);
        Borne b50 = new Borne(50);
        Borne b75 = new Borne(75);

        zone.deposer(b25);
        zone.deposer(b50);
        zone.deposer(b75);

        System.out.println("Total des bornes : " + zone.donnerKmParcourus());
        System.out.println("Limite actuelle : " + zone.donnerLimitationVitesse());
        System.out.println();

        /* --- Test limitation / fin de limitation --- */
        DebutLimite debutLimite = new DebutLimite();
        FinLimite finLimite = new FinLimite();

        zone.deposer(debutLimite);
        System.out.println("Limite après début limite : " + zone.donnerLimitationVitesse());

        zone.deposer(finLimite);
        System.out.println("Limite après fin de limite : " + zone.donnerLimitationVitesse());
        System.out.println();

        /* --- Test des batailles (feux, attaques, parades) --- */
        Attaque feuRouge = new Attaque(Type.FEU);
        Parade feuVert = new Parade(Type.FEU);

        System.out.println("Est dépôt Feu Vert autorisé ? " + zone.estDepotFeuVertAutorise());
        zone.deposer(feuRouge);
        System.out.println("Feu Rouge déposé !");
        System.out.println("Peut avancer ? " + zone.peutAvancer());

        if (zone.estDepotAutorise(feuVert)) {
            zone.deposer(feuVert);
            System.out.println("Feu Vert déposé !");
        }

        System.out.println("Peut avancer maintenant ? " + zone.peutAvancer());
        System.out.println();

        /* --- Test des bornes après feu vert --- */
        Borne b100 = new Borne(100);
        System.out.println("Est dépôt borne 100 autorisé ? " + zone.estDepotAutorise(b100));
        if (zone.estDepotAutorise(b100)) {
            zone.deposer(b100);
        }
        System.out.println("Total des bornes : " + zone.donnerKmParcourus());
        System.out.println();

        /* --- Test d’un dépôt non autorisé (exemple) --- */
        Attaque accident = new Attaque(Type.ACCIDENT);
        System.out.println("Est dépôt Accident autorisé ? " + zone.estDepotAutorise(accident));

        System.out.println("\n=== FIN TEST ZONE DE JEU ===");
    }
}

