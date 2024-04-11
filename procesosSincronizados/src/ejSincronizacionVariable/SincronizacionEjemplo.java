package ejSincronizacionVariable;

public class SincronizacionEjemplo {
    private boolean joy = false;

    public synchronized void guardedJoy() {
        while (!joy) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Manejar la interrupción
            }
        }
        System.out.println("¡Se ha logrado la alegría y la eficiencia!");
    }

    public synchronized void notifyJoy() {
        joy = true;
        notifyAll();
    }

    public static void main(String[] args) {
        SincronizacionEjemplo sincronizacion = new SincronizacionEjemplo();
        Thread thread1 = new Thread(new GuardedJoyThread(sincronizacion));
        Thread thread2 = new Thread(new NotifyJoyThread(sincronizacion));

        thread1.start();
        thread2.start();
    }
}


