package be.technifutur.sudoku.sudokuSamourail;

import be.technifutur.sudoku.AbstractSudoku;
import be.technifutur.sudoku.Sudoku;

public class SudokuSamourail extends AbstractSudoku{

    public SudokuSamourail(){
        super(21,21);
    }
    @Override
    public boolean isValid(int lig, int col) {
        return isValid(0,0  , lig, col)
                ||isValid(0,12  , lig, col)
                ||isValid(6,6  , lig, col)
                ||isValid(12,0  , lig, col)
                ||isValid(12,12  , lig, col)
                ;
    }

    private boolean isValid(int l0, int c0, int lig, int col) {
        return lig >= l0+ 0 && lig < l0+9 && col >= c0+0 && col < c0+9;
    }
    @Override
    protected boolean isValueValid(char val) {
        return "123456789".indexOf(val)>=0;
    }

}
