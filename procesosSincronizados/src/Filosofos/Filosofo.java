package Filosofos;
import java.util.Random;
//cada filósofo es un hilo (Thread) que intenta adquirir los cubiertos
// izquierdo y derecho de manera secuencial. Si un cubierto no está disponible,
// el filósofo espera hasta que ambos cubiertos estén disponibles para poder comer.
// Después de comer, el filósofo espera un tiempo aleatorio antes de volver a pensar.
public class Filosofo implements Runnable{
    private int id;
    private Object izquierdo;
    private Object derecho;
    private Random rnd;

    public Filosofo(int id, Object izquierdo, Object derecho) {
        this.id = id;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.rnd = new Random();
    }

    private void comer() throws InterruptedException {
        synchronized (izquierdo) {
            synchronized (derecho) {
                System.out.println("Filósofo " + id + " comiendo");
                Thread.sleep(rnd.nextInt(4000) + 1000); // Tiempo aleatorio entre 1000 y 5000 ms
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando");
        Thread.sleep(rnd.nextInt(4000) + 1000); // Tiempo aleatorio entre 1000 y 5000 ms
    }

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                comer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        final int numFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        Object[] tenedores = new Object[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Object();
        }

        for (int i = 0; i < numFilosofos; i++) {
            Object izquierdo = tenedores[i];
            Object derecho = tenedores[(i + 1) % numFilosofos];

            // Para evitar el deadlock, el filósofo con id par toma primero el tenedor derecho
            if (i % 2 == 0) {
                filosofos[i] = new Filosofo(i, derecho, izquierdo);
            } else {
                filosofos[i] = new Filosofo(i, izquierdo, derecho);
            }

            Thread thread = new Thread(filosofos[i]);
            thread.start();
        }
    }

}
