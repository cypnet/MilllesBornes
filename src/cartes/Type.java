package cartes;

public enum Type {
    FEU("Feu rouge", "Feu vert", "Prioritaire"),
    ESSENCE("Panne d'essence", "Essence", "Camion citerne"),
    CREVAISON("Crevaison", "Roue de secours", "Increvable"),
    ACCIDENT("Accident", "Réparation", "Increvable");

    private String attaque;
    private String parade;
    private String botte;

    // Constructeur
    private Type(String attaque, String parade, String botte) {
        this.attaque = attaque;
        this.parade = parade;
        this.botte = botte;
    }

    // Getters
    public String getAttaque() { return attaque; }
    public String getParade() { return parade; }
    public String getBotte() { return botte; }
}

