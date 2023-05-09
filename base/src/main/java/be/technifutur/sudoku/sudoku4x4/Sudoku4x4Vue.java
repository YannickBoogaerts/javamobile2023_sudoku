package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.Sudoku;
import be.technifutur.sudoku.SudokuPositionException;
import be.technifutur.sudoku.SudokuVue;
import be.technifutur.sudoku.sudoku9x9.Sudoku9x9;

public class Sudoku4x4Vue implements SudokuVue {
    private static String format = """
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+
            """.replaceAll("\\.", "%s");


    public void affiche(Sudoku4x4 sudo) {
        try {
            Character[] val = new Character[4*4];
            for (int lig = 0; lig < 4; lig++) {
                for (int col = 0; col < 4; col++) {
                    char value = sudo.getValue(lig, col);
                    val[lig * 4 + col] = value == Sudoku.EMPTY ? '.' : value;
                }
            }
            System.out.printf(format, (Object[])val);
        } catch (SudokuPositionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void affiche(Sudoku sudo) {
        affiche((Sudoku4x4) sudo);
    }
}
