package cartes;

import java.util.*;

public class JeuDeCartes {

    public static class Configuration {
        private Carte carte;
        private int nbExemplaires;

        public Configuration(Carte carte, int nbExemplaires) {
            this.carte = carte;
            this.nbExemplaires = nbExemplaires;
        }

        public Carte getCarte() {
            return carte;
        }

        public int getNbExemplaires() {
            return nbExemplaires;
        }
    }

    private Configuration[] configurations;

    public JeuDeCartes() {
        configurations = new Configuration[] {
            new Configuration(new Borne(25), 10),
            new Configuration(new Borne(50), 10),
            new Configuration(new Borne(75), 10),
            new Configuration(new Borne(100), 12),
            new Configuration(new Borne(200), 4),
            new Configuration(new Parade(Type.FEU), 14),
            new Configuration(new FinLimite(), 6),
            new Configuration(new Parade(Type.ESSENCE), 6),
            new Configuration(new Parade(Type.CREVAISON), 6),
            new Configuration(new Parade(Type.ACCIDENT), 6),
            new Configuration(new Attaque(Type.FEU), 5),
            new Configuration(new DebutLimite(), 4),
            new Configuration(new Attaque(Type.ESSENCE), 3),
            new Configuration(new Attaque(Type.CREVAISON), 3),
            new Configuration(new Attaque(Type.ACCIDENT), 3),
            new Configuration(new Botte(Type.FEU), 1),
            new Configuration(new Botte(Type.ESSENCE), 1),
            new Configuration(new Botte(Type.CREVAISON), 1),
            new Configuration(new Botte(Type.ACCIDENT), 1)
        };
    }

    public void affichageJeuDeCartes() {
        System.out.println("JEU :");
        for (Configuration c : configurations)
            System.out.println(c.getNbExemplaires() + " " + c.getCarte());
    }

    public Carte[] donnerCartes() {
        List<Carte> liste = new ArrayList<>();
        for (Configuration c : configurations) {
            for (int i = 0; i < c.getNbExemplaires(); i++) {
                liste.add(c.getCarte());
            }
        }
        return liste.toArray(new Carte[0]);
    }

    // ✅ Vérifie que le nombre de chaque carte correspond à la configuration
    public boolean checkCount() {
        Carte[] cartes = donnerCartes();
        for (Configuration config : configurations) {
            int count = 0;
            for (Carte c : cartes) {
                if (c.equals(config.getCarte())) {
                    count++;
                }
            }
            if (count != config.getNbExemplaires()) {
                return false;
            }
        }
        return true;
    }
}




