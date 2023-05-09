package be.technifutur.sudoku;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Zone {

    private String nom;
    private Set<Character> values = new HashSet<>();

    public Zone(String nom) {
        Objects.requireNonNull(nom);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public boolean contains(Object o) {
        return values.contains(o);
    }

    public boolean add(Character character) {
        return values.add(character);
    }

    public boolean remove(Object o) {
        return values.remove(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zone zone = (Zone) o;

        return nom.equals(zone.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return "Zone{" +
                "nom='" + nom + '\'' +
                ", values=" + values +
                '}';
    }
}
