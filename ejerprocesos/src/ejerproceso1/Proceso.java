package ejerproceso1;
/*modelo de proceso*/
public class Proceso extends Thread {
    public int id;

    public Proceso(String name, int id) {
        super(name);
        this.id = id;
    }
    /*metodo para ejecutarse*/
    public void run(){
        System.out.println("Soy el proceso"+this.getName()+" "+id);
    }
}
