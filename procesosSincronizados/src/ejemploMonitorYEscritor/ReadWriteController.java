package ejemploMonitorYEscritor;

public class ReadWriteController extends Thread{

    private Recurso elRecurso;
    private int writerWaiting = 0;
    private int readerInside = 0;
    private int writerInside = 0;

    public Recurso get() {
        goInReader(); //obtiene acceso
        return elRecurso;
    }

    public void write(Recurso newValue) {
        goInWriter(); //obtiene acceso
        elRecurso = newValue;
        goOutWriter(); //libera recurso
    }

    public synchronized void goInReader() {
        try {
            while ((writerWaiting + writerInside) != 0) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readerInside = readerInside + 1;
    }

    public synchronized void goOutReader() {
        readerInside = readerInside - 1;
        notifyAll();
    }

    public synchronized void goInWriter() {
        writerWaiting = writerWaiting + 1;
        try {
            while ((writerInside + readerInside) != 0) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writerWaiting = writerWaiting - 1;
        writerInside = writerInside + 1;
    }

    public synchronized void goOutWriter() {
        writerInside = writerInside - 1;
        notifyAll();
    }
}
