package ejercicio2;
//se utilizan wait() y notify()
// dentro de bloques synchronized en ambos métodos para
// tener una comunicación segura entre los dos hilos
public class ThreadCommunication {
    private boolean hasMessage = false;

    public static void main(String[] args) {
        ThreadCommunication communication = new ThreadCommunication();

        Thread threadA = new Thread(() -> communication.waitForMessage());
        Thread threadB = new Thread(() -> communication.setMessage("Mensaje de prueba"));

        threadA.start();
        threadB.start();
    }

    public synchronized void waitForMessage() {
        try {
            while (!hasMessage) {
                wait();
            }
            System.out.println("Mensaje recibido en Thread A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setMessage(String message) {
        hasMessage = true;
        notify();
        System.out.println("Mensaje enviado desde Thread B");
    }
}
