package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {

    private List<Carte> cartesMain;

    public MainJoueur() {
        cartesMain = new ArrayList<>();
    }

    public void prendre(Carte c) {
        cartesMain.add(c);
    }

    public void jouer(Carte c) {
        assert cartesMain.contains(c) : "La carte n’est pas dans la main";
        cartesMain.remove(c);
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartesMain.iterator();
    }

    @Override
    public String toString() {
        return "Main : " + cartesMain;
    }
}
