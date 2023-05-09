package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.AbstractSudoku;
import be.technifutur.sudoku.Cellule;
import be.technifutur.sudoku.Sudoku;
import be.technifutur.sudoku.Zone;

public class Sudoku9x9 extends AbstractSudoku {
    public Sudoku9x9() {
        super(9, 9);
        Zone[] ligneTab = new Zone[9];
        Zone[] colonneTab = new Zone[9];
        Zone[] carre = new Zone[9];
        for (int i = 0; i < 9; i++) {
            ligneTab[i] = new Zone("ligne " + (i + 1));
            colonneTab[i] = new Zone("colonne " + (i + 1));
            carre[i] = new Zone("carré " + (i + 1));
        }
        for (int lig = 0; lig < 9; lig++) {
            for (int col = 0; col < 9; col++) {
                Cellule cellule = getCellule(lig, col);
                cellule.add(ligneTab[lig]);
                cellule.add(colonneTab[col]);
                cellule.add(carre[col / 3 + lig / 3 * 3]);
            }

        }
        // TODO
    }

    @Override
    public boolean isValid(int lig, int col) {
        return lig >= 0 && lig < 9 && col >= 0 && col < 9;
    }

    @Override
    protected boolean isValueValid(char val) {
        return "123456789".indexOf(val) >= 0;
    }

}
