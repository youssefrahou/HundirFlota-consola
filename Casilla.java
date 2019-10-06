public class Casilla {

    public String dibujo;
    public int fila;
    public int columna;
    ParteBarco parteBarco;
    public boolean agua = true;
    public boolean tapada = false;
    public boolean barcoCerca ;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Casilla(String dibujo, int fila, int columna, boolean barcoCerca) {
        this.dibujo = dibujo;
        this.fila = fila;
        this.columna = columna;
        this.barcoCerca = barcoCerca;
    }
    public void setParteBarco(ParteBarco parte){
        this.parteBarco = parte;
        agua = false;
    }
    public boolean isAgua(){
        return agua;
    }

    public boolean isBarcoCerca(){
        return barcoCerca;
    }


    public void destapar(){
        tapada = false;
    }

    public boolean isTapada(){
        return tapada;
    }
    public void setDibujo(String dibujoNuevo){
        dibujo = dibujoNuevo;
    }

    public String getDibujo() {

        if (tapada) return "▇";
        if (agua) return ANSI_BLUE + "▇" + ANSI_RESET;
        if (parteBarco.isTocado()) return ANSI_RED + "▇" + ANSI_RESET;
        return ANSI_YELLOW + "▇" +  ANSI_RESET;

    }

    public void setBarcoCerca(){
        barcoCerca = true;
    }



}
