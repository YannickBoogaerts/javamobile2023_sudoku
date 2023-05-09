package be.technifutur.sudoku;

public interface Sudoku {
    public static final char EMPTY = ' ';

    public abstract void setValue(int lig, int col, char val) throws SudokuLockException, SudokuPositionException, SudokuValueException, SudokuDoublonException;
    public abstract boolean isValid(int lig, int col);
    char getValue(int lig, int col)throws SudokuPositionException;
    void lock();
}
