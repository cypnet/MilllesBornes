package cartes;

import java.util.Objects;

public abstract class Carte {
    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}


