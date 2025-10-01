package cartes;

public class JeuDeCartes {

    // Classe interne représentant une configuration : carte + nombre d'exemplaires
    public static class Configuration {
        private Carte carte;       // La carte elle-même
        private int nbExemplaires; // Nombre de cartes identiques

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

    // Tableau contenant toutes les configurations du jeu
    private Configuration[] configurations;

    // Constructeur : initialise le tableau de configurations
    public JeuDeCartes() {
        configurations = new Configuration[] {
            // Bornes
            new Configuration(new Borne(25), 10),
            new Configuration(new Borne(50), 10),
            new Configuration(new Borne(75), 10),
            new Configuration(new Borne(100), 12),
            new Configuration(new Borne(200), 4),

            // Parades
            new Configuration(new Parade(Type.FEU), 14),       // Feu vert
            new Configuration(new FinLimite(), 6),             // Fin Limite
            new Configuration(new Parade(Type.ESSENCE), 6),    // Bidon d'essence
            new Configuration(new Parade(Type.CREVAISON), 6),  // Roue de secours
            new Configuration(new Parade(Type.ACCIDENT), 6),   // Réparation

            // Attaques
            new Configuration(new Attaque(Type.FEU), 5),       // Feu rouge
            new Configuration(new DebutLimite(), 4),           // Limite 50
            new Configuration(new Attaque(Type.ESSENCE), 3),   // Panne d'essence
            new Configuration(new Attaque(Type.CREVAISON), 3), // Crevaison
            new Configuration(new Attaque(Type.ACCIDENT), 3),  // Accident

            // Bottes
            new Configuration(new Botte(Type.FEU), 1),         // Prioritaire
            new Configuration(new Botte(Type.ESSENCE), 1),     // Citerne
            new Configuration(new Botte(Type.CREVAISON), 1),   // Increvable
            new Configuration(new Botte(Type.ACCIDENT), 1)     // As du volant
        };
    }

    // Méthode pour afficher le jeu avec nombre d'exemplaires
    public void affichageJeuDeCartes() {
        System.out.println("JEU :");
        for (Configuration config : configurations) {
            System.out.println(config.getNbExemplaires() + " " + config.getCarte());
        }
    }

    // Getter pour récupérer les configurations si besoin
    public Configuration[] getConfigurations() {
        return configurations;
    }
}


