package ejer3;

public class Proceso extends Thread {
    private int id;
    static int cont=0;//la variable estatica me sirve para todas las instancias de la misma clase, un valor para todas las instancias

    public Proceso(String name, int id){
        super(name);
        this.id=id;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            cont ++;
        }
    }
}
