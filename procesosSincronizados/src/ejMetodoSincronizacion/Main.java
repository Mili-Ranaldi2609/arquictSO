package ejMetodoSincronizacion;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000, "USD");
        System.out.println("Saldo inicial: " + cuenta.saldo());

        cuenta.ingresa(500);
        System.out.println("Saldo después del ingreso: " + cuenta.saldo());
    }
}
