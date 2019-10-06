public class ParteBarco {

    public int fila;
    public int columna;
    public Barco barco;
    private boolean tocado = false;

    public ParteBarco(int fila, int columna, Barco b){
        this.fila = fila;
        this.columna = columna;
        barco = b;
        Tablero.tablero[fila][columna].setParteBarco(this);

    }

    public boolean hundir(){

        if (barco.hundido()){
            tocado = true;
        }
        return false;
    }
    public void atacar(){
        tocado = true;
    }

    public boolean isTocado(){
        return tocado;
    }

}
