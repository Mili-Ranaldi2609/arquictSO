package ejMetodoSincronizacion;

public class CuentaBancaria {

    private Deposito elDeposito = new Deposito();
        public CuentaBancaria(double initialDeposito,String moneda){
            elDeposito.cantidad= initialDeposito;
            elDeposito.moneda=moneda; }

    public Deposito getElDeposito() {
        return elDeposito;
    }

    public void setElDeposito(Deposito elDeposito) {
        this.elDeposito = elDeposito;
    }

    public synchronized double saldo(){
            return elDeposito.cantidad;
        }
    public synchronized void ingresa(double cantidad){
            elDeposito.cantidad=elDeposito.cantidad + cantidad;
        }

}
