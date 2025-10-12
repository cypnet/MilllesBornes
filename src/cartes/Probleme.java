package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte {
    private Type type;

    protected Probleme(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Probleme other = (Probleme) obj;
        return type == other.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}


