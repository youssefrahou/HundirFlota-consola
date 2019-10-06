import java.util.Random;

public class Tablero {
    static int columnas = 10;
    static int filas = 10;
    static Casilla[][] tablero = new Casilla[filas][columnas];



public void  crearTablero(){

    for (int i = 0; i < tablero.length; i++){
        for (int k = 0; k < tablero[0].length;  k++){

            tablero[i][k] = new Casilla(" [ ] ", i, k, false);

        }
    }

}

public void imprimirTablero(){
    System.out.println("1  2 3  4  5 6 7  8  9 10");

    for (int i = 0; i < tablero.length; i++){

        for (int k = 0; k < tablero[0].length; k++){

            System.out.print(tablero[i][k].getDibujo() + " ");

        }
        System.out.println((i+1));
    }
}


    public void ponerBarcosCerca(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (!tablero[i][j].isAgua()){
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if ((i - k >= 0) && (i - k < tablero.length) && (j - l >= 0) && (j - l < tablero[0].length) && tablero[i - k][j - l].isAgua()){
                                tablero[i - k][j - l].setBarcoCerca();
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean comprobarSiCabeBarco(int numPartes, int fila, int columna, int direccion){


        if (direccion==0){ //horizontal

            for (int i = 0; i < numPartes; i++){

                if (((fila) > tablero.length - 1) || ((columna + i) > tablero[0].length - 1) || !tablero[fila][columna + i].isAgua() || tablero[fila][columna+i].isBarcoCerca()){
                    return true;
                }

            }

        }else{ //vertical

            for (int i = 0; i < numPartes; i++){

                if (((fila + i) > tablero.length - 1) || ((columna) > tablero[0].length - 1) || !tablero[fila + i][columna].isAgua() || tablero[fila + i][columna].isBarcoCerca()){
                    return true;
                }

            }

        }
        return false;
    }

    public void ponerBarco(int numPartes){

        Random ran = new Random();
        int fila;
        int columna;
        int direccion;


        do{
            fila = ran.nextInt(filas-1);
            columna = ran.nextInt(columnas-1);
            direccion = ran.nextInt(2);

        } while (comprobarSiCabeBarco(numPartes, fila, columna, direccion));

        Barco b = new Barco(numPartes, fila, columna, direccion);
        ponerBarcosCerca();
    }

    public void jugar(){

        crearTablero();
        ponerBarco(4);
        ponerBarco(3);
        ponerBarco(2);
        imprimirTablero();

    }





}
