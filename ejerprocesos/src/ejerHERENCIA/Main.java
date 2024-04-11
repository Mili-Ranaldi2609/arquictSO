package ejerHERENCIA;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args){
// Declaración de 2 threads
        ThreadHerencia t1 =new ThreadHerencia("PING",33);
        ThreadHerencia t2= new ThreadHerencia("PONG",10);
// Activación
        t1.start();
        t2.start();
// Espera 2 segundos
        try{ sleep(5000);
        }catch (InterruptedException e){};
// Finaliza la ejecución de los threads
        t1.stop();
        t2.stop();
    }
}
