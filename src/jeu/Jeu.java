package jeu;

import cartes.*;
import utils.GestionCartes;
import java.util.*;


public class Jeu {

    private Sabot sabot;
    private List<Joueur> joueurs = new ArrayList<>();
    private Iterator<Joueur> itJoueurs;
    private static final int NBCARTES = 6;

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] cartes = jeuDeCartes.donnerCartes();
        List<Carte> listeCartes = new ArrayList<>(Arrays.asList(cartes));
        listeCartes = GestionCartes.melanger(listeCartes);
        this.sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }

    public void inscrire(Joueur... nouveaux) {
        joueurs.addAll(Arrays.asList(nouveaux));
    }

    public void distribuerCartes() {
        for (int i = 0; i < NBCARTES; i++) {
            for (Joueur j : joueurs) {
                if (!sabot.estVide()) {
                    j.donner(sabot.piocher());
                }
            }
        }
    }

    public Joueur donnerJoueurSuivant() {
        if (itJoueurs == null || !itJoueurs.hasNext()) {
            itJoueurs = joueurs.iterator();
        }
        return itJoueurs.next();
    }

    public String jouerTour(Joueur joueur) {
        String texte = "";

        if (sabot.estVide()) return "Sabot vide.\n";

        Carte pioche = sabot.piocher();
        joueur.donner(pioche);

        texte += "Le joueur " + joueur.getNom() + " a pioché " + pioche + "\n";
        texte += "Il a dans sa main : " + joueur.getMain() + "\n";

        Set<Joueur> participants = new HashSet<>(joueurs);
        Coup coup = joueur.choisirCoup(participants);
        joueur.retirerDeLaMain(coup.getCarte());

        if (coup.getCible() == null) {
            texte += coup.getJoueur().getNom() + " défausse la carte " + coup.getCarte() + "\n";
            sabot.ajouterCarte(coup.getCarte());
        } else {
            texte += coup.getJoueur().getNom() + " dépose la carte " + coup.getCarte()
                    + " dans la zone de jeu de " + coup.getCible().getNom() + "\n";
            coup.getCible().getZone().deposer(coup.getCarte());
        }

        return texte;
    }

    public String lancer() {
        StringBuilder res = new StringBuilder();
        boolean fini = false;

        while (!sabot.estVide() && !fini) {
            Joueur j = donnerJoueurSuivant();
            res.append(jouerTour(j)).append("\n");

            if (j.donnerKmParcourus() >= 1000) {
                res.append(j.getNom()).append(" a gagné la partie !\n");
                fini = true;
            }
        }

        if (sabot.estVide()) res.append("Le sabot est vide.\n");
        return res.toString();
    }
}


