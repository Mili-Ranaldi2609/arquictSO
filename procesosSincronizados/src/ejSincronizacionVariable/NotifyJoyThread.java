package ejSincronizacionVariable;

public class NotifyJoyThread extends Thread{
    private SincronizacionEjemplo sincronizacion;

    public NotifyJoyThread(SincronizacionEjemplo sincronizacion) {
        this.sincronizacion = sincronizacion;
    }


    public void run() {
        synchronized (sincronizacion) {
            sincronizacion.notifyJoy();
        }
    }
}
