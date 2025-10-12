package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {
    public static void main(String[] args) {
        Borne b1 = new Borne(25);
        Borne b2 = new Borne(25);
        System.out.println("Deux cartes de 25km sont identiques ? " + b1.equals(b2));

        Attaque feuRouge1 = new Attaque(Type.FEU);
        Attaque feuRouge2 = new Attaque(Type.FEU);
        System.out.println("Deux cartes de feux rouge sont identiques ? " + feuRouge1.equals(feuRouge2));

        Attaque feuVert = new Attaque(Type.ESSENCE);
        System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + feuRouge1.equals(feuVert));
    }
}

