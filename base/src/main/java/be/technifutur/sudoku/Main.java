package be.technifutur.sudoku;

import be.technifutur.sudoku.sudoku4x4.Sudoku4x4Factory;
import be.technifutur.sudoku.sudoku4x4.Sudoku4x4Vue;
import be.technifutur.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.sudoku.sudoku9x9.Sudoku9x9Factory;
import be.technifutur.sudoku.sudoku9x9.Sudoku9x9Vue;

public class Main {
    public static void main(String[] args) {
        /*
        test1();
        test2();
        testEmpty();
        testAffiche();
        testFichier();*/
        testControleur9x9();
        //testControleur4x4();

    }

    private static void testControleur9x9() {
        Sudoku9x9Factory factory = new Sudoku9x9Factory();
        Sudoku sudoku = factory.createSudoku("sudokuExemple\\toto.txt");
        SudokuVue vue = new Sudoku9x9Vue();
/*
        SudokuControler controler = new SudokuControler()
                .setSudoku(sudoku)
                .setVue(vue);
*/
        SudokuControler controler = new SudokuControler();
        controler.setSudoku(sudoku);
        controler.setVue(vue);
        controler.start();
    }

    private static void testControleur4x4() {
        Sudoku4x4Factory factory = new Sudoku4x4Factory();
        Sudoku sudoku = factory.createSudoku("sudokuExemple\\dede.txt");
        SudokuVue vue = new Sudoku4x4Vue();
/*
        SudokuControler controler = new SudokuControler()
                .setSudoku(sudoku)
                .setVue(vue);
*/
        SudokuControler controler = new SudokuControler();
        controler.setSudoku(sudoku);
        controler.setVue(vue);
        controler.start();
    }

    private static void testFichier() {
        Sudoku9x9Factory factory = new Sudoku9x9Factory();
        Sudoku9x9 sudoku = factory.createSudoku("toto.txt");
        Sudoku9x9Vue vue = new Sudoku9x9Vue();
        vue.affiche(sudoku);
    }

    private static void testAffiche() {
        char val = '0';
        Sudoku9x9 sudo = new Sudoku9x9();
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                try {
                    sudo.setValue(l,c,val++);
                } catch (SudokuException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Sudoku9x9Vue vue = new Sudoku9x9Vue();
        //vue.autreTechnique(sudo);
    }

    private static void testEmpty() {
        Sudoku9x9 sudo = new Sudoku9x9();
        boolean test = true;
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                try {
                    test = test && sudo.getValue(l,c) == Sudoku9x9.EMPTY;
                } catch (SudokuException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("test empty :"+test);
        Sudoku9x9Vue vue = new Sudoku9x9Vue();
        vue.affiche(sudo);
    }

    private static void test1() {
        Sudoku9x9 sudo = new Sudoku9x9();
        try {
            sudo.setValue(0,1,'4');
        boolean test1 = sudo.getValue(0, 1) == '4';
        System.out.println("test 1 : "+ test1);
        Sudoku9x9Vue vue = new Sudoku9x9Vue();
        vue.affiche(sudo);
        } catch (SudokuException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test2() {
        Sudoku9x9 sudo = new Sudoku9x9();
        try {
            sudo.setValue(3,1,'2');

        boolean test2 = sudo.getValue(3, 1) == '2';
        System.out.println("test 2 : "+ test2);
        Sudoku9x9Vue vue = new Sudoku9x9Vue();
        vue.affiche(sudo);
        } catch (SudokuException e) {
            throw new RuntimeException(e);
        }
    }
}
