package ejemploSemaforo;

public class Main {
    public static void main(String[] args) {
        Semaforo semaphore = new Semaforo(0);

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Thread 1 - Antes de signal");
                semaphore.signal();
                System.out.println("Thread 1 - Después de signal");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread 2 - Antes de await");
                semaphore.await();
                System.out.println("Thread 2 - Después de await");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
