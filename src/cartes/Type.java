package cartes;

public enum Type {
	FEU("Feu rouge", "Feu vert"),
	ESSENCE("Panne d'essence", "Essence"),
	CREVAISON("Crevaison",  "Roue de secours"),
	ACCIDENT("Accident","Réparation");
	private String attaque;
	private String parade;
	private String botte;
	private String debutlimite;
	private String borne;
	private String finlimite;
	public String getAttaque() {
		return attaque;
	}
	public String getParade() {
		return parade;
	}
	public String getBotte() {
		return botte;
	}
	public String getDebutlimite() {
		return debutlimite;
	}
	public String getBorne() {
		return borne;
	}
	public String getFinlimite() {
		return finlimite;
	}
	private Type(String attaque, String parade, String botte, String debutlimite, String borne, String finlimite) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
		this.debutlimite = debutlimite;
		this.borne = borne;
		this.finlimite = finlimite;
	}
	
	

}
