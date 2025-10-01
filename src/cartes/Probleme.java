package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public Type getType() {
		return type;
	}

	protected Probleme(Type type) {
		super();
		this.type = type;
	}

}
