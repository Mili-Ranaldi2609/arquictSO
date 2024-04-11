package Ejemplos.bloquesincronizacion;

public class Main {
    public static void main(String[] args) {
        int[] valores = {-1, 2, -3, 4, -5};

        System.out.println("Valores originales:");
        imprimirArray(valores);

        BloqueArray.abs(valores);

        System.out.println("Valores después de aplicar abs:");
        imprimirArray(valores);
    }

    public static void imprimirArray(int[] valores) {
        for (int valor : valores) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}

