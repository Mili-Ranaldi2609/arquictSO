package ejBuffer;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new FixedBuffer(5); // Creamos un buffer de tamaño 5
        // Hilo para poner elementos en el buffer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.put(i);
                    System.out.println("Productor puso: " + i);
                    Thread.sleep(1000); // Simulamos un proceso que tarda tiempo
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Hilo para obtener elementos del buffer
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Object obj = buffer.get();
                    System.out.println("Consumidor obtuvo: " + obj);
                    Thread.sleep(1500); // Simulamos un proceso que tarda tiempo
                }
            } catch (InterruptedException e) {
                e.printStackTrace();//printStackTrace() se llama para imprimir la pila de llamadas de la excepción en la consola, ayuda a identificar dónde ocurrió la excepción en el código y qué métodos estaban involucrados en el momento.
            }
        });

        // Iniciamos los hilos
        producer.start();
        consumer.start();

    }
}
