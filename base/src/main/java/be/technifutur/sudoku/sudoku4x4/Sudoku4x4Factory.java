package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.SudokuException;
import be.technifutur.sudoku.SudokuLockException;
import be.technifutur.sudoku.SudokuPositionException;
import be.technifutur.sudoku.SudokuValueException;
import be.technifutur.sudoku.sudoku9x9.Sudoku9x9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku4x4Factory {

    public Sudoku4x4 createSudoku(String filename) {
        Sudoku4x4 sudo = new Sudoku4x4();
        File file = new File(filename);
        try (Scanner scan = new Scanner(file)) {
            int lig = 0;
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                for (int col = 0; col < s.length(); col++) {
                    char val = s.charAt(col);
                    if (val != ' ') {
                        sudo.setValue(lig, col, val);
                    }
                }
                lig++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("le fichier n'existe pas");
        } catch (SudokuException e) {
            throw new RuntimeException(e);
        }
        return sudo;
    }


}
