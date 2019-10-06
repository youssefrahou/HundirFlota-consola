import java.util.Random;

public class Barco {

    int numPartes;
    public int direccion;
    int fila;
    int columna;
    ParteBarco[] barco;

    public Barco (int numPartes, int fila, int columna, int direccion){
        this.numPartes = numPartes;
        this.fila = fila;
        this.columna = columna;
        this.direccion = direccion;
        barco = new ParteBarco[numPartes];


        if (direccion==0){ //horizontal filas

            for (int i = 0; i < numPartes; i++){

                barco[i] = new ParteBarco(fila, (columna+i), this);
                Tablero.tablero[fila][columna+i].setParteBarco(barco[i]);

            }

        }else{ //vertical columnas

            for (int i = 0; i < numPartes; i++){

                barco[i] = new ParteBarco((fila+1), columna, this);
                Tablero.tablero[fila+i][columna].setParteBarco(barco[i]);

            }

        }


    }

    public boolean hundido(){
        for (int i = 0; i < barco.length; i++) {
            if (!barco[i].isTocado()) {
                return false;
            }
        }
        return true;
    }








}
