package Ejemplos.bloquesincronizacion;

public class BloqueArray {
    public static void abs(int[] valores) {
        synchronized (valores) {
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] < 0) valores[i] = -valores[i];
            }
        }
    }
}
