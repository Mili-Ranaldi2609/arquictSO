package ejMetodoSincronizacion;

public class Deposito {
    protected double cantidad;
    protected String moneda = "Euro";

    public Deposito() {
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
