package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.AbstractSudoku;
import be.technifutur.sudoku.Sudoku;

public class Sudoku4x4 extends AbstractSudoku{
    public Sudoku4x4() {
        super(4,4);
    }
    @Override
    public boolean isValid(int lig, int col) {
        return lig >= 0 && lig < 9 && col >= 0 && col < 9;
    }

    @Override
    protected boolean isValueValid(char val) {
        return "1234".indexOf(val )>=0;
    }

}

