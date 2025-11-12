package utils;

import java.util.*;


public class GestionCartes {

    public static final Random random = new Random();
    public static <T> T extraire(List<T> liste) {
        if (liste.isEmpty()) throw new IllegalArgumentException("Liste vide !");
        int index = random.nextInt(liste.size());
        return liste.remove(index);
    }

    
    public static <T> T extraire(ListIterator<T> it, List<T> liste) {
        if (!it.hasNext()) throw new IllegalArgumentException("Liste vide !");
        int index = new Random().nextInt(liste.size());
        T elem = liste.get(index);
        liste.remove(index);
        return elem;
    }

    
    public static <T> List<T> melanger(List<T> liste) {
        List<T> copie = new ArrayList<>();
        while (!liste.isEmpty()) {
            copie.add(extraire(liste));
        }
        return copie;
    }

    
    public static <T> boolean verifierMelange(List<T> original, List<T> melange) {
        Set<T> elements = new HashSet<>(original);
        for (T elem : elements) {
            if (Collections.frequency(original, elem) != Collections.frequency(melange, elem))
                return false;
        }
        return true;
    }

    
    public static <T> List<T> rassembler(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        for (T elem : liste) {
            if (!resultat.contains(elem))
                resultat.add(elem);
        }
        for (T elem : liste) {
            if (resultat.contains(elem) && !resultat.get(resultat.size() - 1).equals(elem))
                resultat.add(elem);
        }
        return resultat;
    }

    
    public static <T> boolean verifierRassemblement(List<T> liste) {
        ListIterator<T> it1 = liste.listIterator();
        while (it1.hasNext()) {
            T courant = it1.next();
            ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
            while (it2.hasNext()) {
                if (courant.equals(it2.next()))
                    return false; 
            }
        }
        return true;
    }
}

