package ejemploSemaforo;

public class Semaforo extends Exception{
    int value;
    public Semaforo(int initialValue){
        value = initialValue;
    }
    synchronized public void signal(){
        value= value+1;
        notify();
    }
    synchronized public void await() throws  InterruptedException {
        while (value == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Volvemos a lanzar InterruptedException
                throw e;
            }
        }
        value = value - 1;
    }
}
