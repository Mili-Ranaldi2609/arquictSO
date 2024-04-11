package ejerprocesosincronizacion;

public class CompartirInf {
    public static void main(String[] args) {
        Contador cont= new Contador(100);
        HiloA cont2= new HiloA(" CONTADOR A",cont);

        HiloB cont1=new HiloB("CONTADOR B", cont);
        cont2.start();
        cont1.start();
    }
}
