package jeu;

import cartes.Carte;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {
    private Carte[] cartes;
    private int nbCartes;
    private int modCount = 0; // Pour détecter les modifications concurrentes

    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(Carte carte) {
        if (nbCartes >= cartes.length)
            throw new IllegalStateException("Sabot plein !");
        cartes[nbCartes++] = carte;
        modCount++;
    }

    public Carte piocher() {
        if (estVide())
            throw new IllegalStateException("Le sabot est vide !");
        Carte c = cartes[0];
        // Décaler les cartes restantes
        System.arraycopy(cartes, 1, cartes, 0, nbCartes - 1);
        nbCartes--;
        modCount++;
        return c;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new IterateurSabot();
    }

    private class IterateurSabot implements Iterator<Carte> {
        private int position = 0;
        private boolean peutSupprimer = false;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return position < nbCartes;
        }

        @Override
        public Carte next() {
            if (expectedModCount != modCount)
                throw new IllegalStateException("Modification concurrente détectée !");
            if (!hasNext())
                throw new NoSuchElementException();
            peutSupprimer = true;
            return cartes[position++];
        }

        @Override
        public void remove() {
            if (!peutSupprimer)
                throw new IllegalStateException("Impossible de supprimer !");
            if (expectedModCount != modCount)
                throw new IllegalStateException("Modification concurrente détectée !");
            System.arraycopy(cartes, position, cartes, position - 1, nbCartes - position);
            nbCartes--;
            position--;
            modCount++;
            expectedModCount++;
            peutSupprimer = false;
        }
    }
}

