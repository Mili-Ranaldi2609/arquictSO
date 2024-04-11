package ejer3;

public class Ejercicio3 {
    public static void main(String[] args) {
        Proceso[] procesos=new Proceso[10];
        for (int i = 0; i < procesos.length; i++) {
            procesos[i]= new Proceso("PROCESO "+i,i);
            procesos[i].start();
            try{
                procesos[i].join();
            }catch(Exception E){}}
        System.out.println(Proceso.cont);

    }
}//todos los objetos tienen un bloqueo asociado, se puede liberar a ese hilo con un metodo,
//puedo usar la sincronizacion para un bloque de codigo o un metodo usando la palabra synchronized
//la clase object tiene asicoada el temade la sincronizacion, object seria la clase padre
//bloques synchronized
//encerramos el coidigo en una instruccion synchronized, la programacion concurrente se
//metodos synchronized,
//los metodos de clase son metodos estaticos , metodo que me sirva para varios ibjetos
//se lo llama como nombre de la clase . variable o metodo
//los metodos abstractos se sobreescriben en la clase hija, en la clase hija la puedo poner como sincronizado y no hace falta que lo tenga en la clase padre
//wait (esperar), y notify trabajan juntos.
//el wait lo puedo poner con un tiempo de espera por las dudas de que no le llegue el notify
//el wait debe usare siemrpe de un mertodo synchronized
//