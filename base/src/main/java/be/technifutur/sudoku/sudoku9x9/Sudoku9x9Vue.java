package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.Sudoku;
import be.technifutur.sudoku.SudokuPositionException;
import be.technifutur.sudoku.SudokuVue;

public class Sudoku9x9Vue implements SudokuVue {
    private static String format = """
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            | . . . | . . . | . . . |
            +-------+-------+-------+
            """.replaceAll("\\.", "%s");


    public void affiche(Sudoku9x9 sudo) {
        try {
            Character[] val = new Character[81];
            for (int lig = 0; lig < 9; lig++) {
                for (int col = 0; col < 9; col++) {
                    char value = sudo.getValue(lig, col);
                    val[lig * 9 + col] = value == Sudoku9x9.EMPTY ? '.' : value;
                }
            }
            System.out.printf(format, (Object[])val);
        } catch (SudokuPositionException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void affiche(Sudoku sudo) {
        affiche((Sudoku9x9) sudo);
    }
}
