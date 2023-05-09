package be.technifutur.sudoku;

import java.util.ArrayList;
import java.util.List;

import static be.technifutur.sudoku.Sudoku.EMPTY;

public class Cellule {
    private char value = EMPTY;
    private boolean lock = false;
    private List<Zone> zoneList = new ArrayList<>();

    public char getValue() {
        return value;
    }

    public void setValue(char newValue) throws SudokuLockException, SudokuDoublonException {
        if (lock) throw new SudokuLockException("cette cellule n'est pas modifiable");
        if (newValue != value) {
            if (newValue != EMPTY) {
                // vérifier doublon
                for (Zone z : zoneList) {
                    if (z.contains(newValue))
                        throw new SudokuDoublonException(
                                String.format("la valeur %s existe déjà dans la %s", newValue, z.getNom())
                        );
                }
            }
            if (value != EMPTY) {
                // supprimer l'ancienne valeur des zones
                for (Zone z : zoneList) {
                    z.remove(value);
                }
            }
            if (newValue != EMPTY) {
                // ajouter la nouvelle valeur dans les zones
                for (Zone z : zoneList) {
                    z.add(newValue);
                }
            }
            value = newValue;
        }
    }

    public boolean isLock() {
        return lock;
    }

    public void lock() {
        if (value != EMPTY) this.lock = true;
    }

    public boolean add(Zone zone) {
        return zoneList.add(zone);
    }
}
