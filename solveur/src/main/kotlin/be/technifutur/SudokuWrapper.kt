package be.technifutur

import be.technifutur.sudoku.sudoku9x9.Sudoku9x9
import be.technifutur.sudoku.sudoku9x9.Sudoku9x9Factory

class SudokuWrapper(val fileName:String) {
    val sudoku : Sudoku9x9 = Sudoku9x9Factory().createSudoku(fileName)
}


fun main() {
    val sudo = SudokuWrapper("sudokuExemple\\toto.txt")
}