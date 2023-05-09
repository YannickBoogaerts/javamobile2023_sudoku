package be.technifutur.sudoku;

public abstract class AbstractSudoku implements Sudoku{
    private Cellule[][] grille;

    public AbstractSudoku(int nbLigne, int nbColonne){
        this.grille = new Cellule[nbLigne][nbColonne];
        for (int lig = 0; lig < nbLigne; lig++) {
            for (int col = 0; col < nbColonne; col++) {
                if (isValid(lig,col))
                this.grille[lig][col] = new Cellule();
            }
        }
    }

    public abstract boolean isValid(int lig, int col);

    @Override
    public void setValue(int lig, int col, char val) throws SudokuLockException, SudokuPositionException, SudokuValueException, SudokuDoublonException {
        checkPosition(lig,col);
        if(!isValueValid(val)){
            throw new SudokuValueException(String.format("la valeur %s n'est pas valide",val));
        }
        this.grille[lig][col].setValue(val);
    }

    protected abstract boolean isValueValid(char val);

    public void lock() {
        for(Cellule[] tab : grille){
            for(Cellule c : tab){
                if(c!=null)
                    c.lock();
            }
        }
    }

    protected Cellule getCellule(int lig,int col){
        return grille[lig][col];
    }

    public char getValue(int lig, int col) throws SudokuPositionException {
        char result;
        checkPosition(lig,col);
        result = this.grille[lig][col].getValue();
        return result;
    }

    private void checkPosition(int lig, int col) throws SudokuPositionException {
        if(! isValid(lig,col)){
            throw new SudokuPositionException( String.format("La position [%s,%s] n'est pas valide",lig,col));
        }
    }

}
