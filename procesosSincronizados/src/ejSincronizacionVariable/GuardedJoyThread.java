package ejSincronizacionVariable;

public class GuardedJoyThread extends Thread{
    private SincronizacionEjemplo sincronizacion;

    public GuardedJoyThread(SincronizacionEjemplo sincronizacion) {
        this.sincronizacion = sincronizacion;
    }


    public void run() {
        synchronized (sincronizacion) {
            sincronizacion.guardedJoy();
        }
    }
}
