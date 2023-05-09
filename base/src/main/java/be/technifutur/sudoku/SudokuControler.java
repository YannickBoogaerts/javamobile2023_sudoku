package be.technifutur.sudoku;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuControler {
    private static Pattern INPUT_VALID = Pattern.compile("([1-9][0-9]*)\\.([1-9][0-9]*)\\.(\\S)");//");
    private static final String MESSAGE = "entrez une valeur (lig.col.val) ('q' quitter): ";
    private SudokuVue vue;
    private Sudoku sudoku;
    private Scanner scanner = new Scanner(System.in);

    public SudokuControler setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
        return this;
    }

    public SudokuControler setVue(SudokuVue vue) {
        this.vue = vue;
        return this;
    }

    public void start() {
        String input = saisir(MESSAGE, Optional.empty());
        while (!input.equalsIgnoreCase("q")) {
            String messageError = null;
            Matcher matcher = INPUT_VALID.matcher(input);
            if (matcher.matches()) {
                int line = Integer.parseInt(matcher.group(1)) - 1;
                int column = Integer.parseInt(matcher.group(2)) - 1;
                char val = matcher.group(3).charAt(0);
                try {
                    sudoku.setValue(line, column, val);
                } catch (SudokuLockException e) {
                    messageError =" cette cellule n'est pas modifiable";
                } catch (SudokuPositionException e) {
                    messageError ="la position n'est pas valide";
                } catch (SudokuValueException e) {
                    messageError =String.format("la valeur '%s' n'est pas valide pour le sudoku", val);
                } catch (SudokuDoublonException e) {
                    messageError = e.getMessage();
                }
            } else {
                messageError = "l'entrée ne repecte pas le format ligne.colonne.valeur";
            }
           input = saisir(MESSAGE, Optional.ofNullable(messageError));
        }

    }

    private String saisir(String prompt, Optional<String> erreur) {
        vue.affiche(sudoku);
        if(erreur.isPresent()){
            System.out.println(erreur.get());
        }
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
