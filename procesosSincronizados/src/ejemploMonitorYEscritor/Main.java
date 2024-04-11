package ejemploMonitorYEscritor;

public class Main {
    public static void main(String[] args) {
        ReadWriteController controller = new ReadWriteController();

        // Escribir un recurso
        Recurso recurso1 = new Recurso(1, "Contenido del recurso 1");
        controller.write(recurso1);
        System.out.println("Recurso escrito: " + recurso1);

        // Leer el recurso
        Recurso recursoLeido = controller.get();
        System.out.println("Recurso leído: " + recursoLeido);

        // Intentar escribir mientras un lector está dentro
        Recurso recurso2 = new Recurso(2, "Contenido del recurso 2");
        Thread writerThread = new Thread(() -> {
            controller.write(recurso2);
            System.out.println("Recurso escrito: " + recurso2);
        });

        // Intentar leer mientras un escritor está dentro
        Thread readerThread = new Thread(() -> {
            Recurso recursoLeido2 = controller.get();
            System.out.println("Recurso leído: " + recursoLeido2);
        });

        // Iniciar el hilo del escritor primero
        writerThread.start();

        // Esperar a que el hilo del escritor termine antes de iniciar el hilo del lector
        try {
            writerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Iniciar el hilo del lector después de que el escritor haya terminado
        readerThread.start();

    }
}
