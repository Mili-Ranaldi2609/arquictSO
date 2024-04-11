package ejBuffer;

public class Main2 {
    public static void main(String[] args) {
        FixedSemaforoBuffer buffer = new FixedSemaforoBuffer(5); // Creamos un buffer de tamaño 5

        // Hilo para poner elementos en el buffer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
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
                for (int i = 0; i < 5; i++) {
                    Object obj = buffer.get();
                    System.out.println("Consumidor obtuvo: " + obj);
                    Thread.sleep(1500); // Simulamos un proceso que tarda tiempo
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Iniciamos los hilos
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Aquí puedes agregar código que se ejecute después de que los hilos hayan terminado
        System.out.println("Ejecución de los hilos finalizada");
    }
}
