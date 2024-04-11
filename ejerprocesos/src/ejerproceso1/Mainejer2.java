package ejerproceso1;

public class Mainejer2 {
    public static void main(String[] args) {
        /*se crea un array para cuando son muchos procesos*/
        Proceso[] procesos=new Proceso[5];
        for (int i = 0; i < 5; i++) {
            procesos[i]=new Proceso(" Proceso "+i,i);
            procesos[i].start();
            try{//sigue apareciendo no ordenado
                procesos[1].join();
            }
            catch(Exception E){}
        /*la cantidad de procesadores es la cantidad de nucleos que tiene */
            //cada hilo ejecuta una actividad
            //dependiendo de lo que tnegmaos usamos un procesador virtul o fisico
            //la programacion concurrnte los mando al mismo tiempo
            //la programacion ordenada los manda en orden al terminar cada proceso
            //hay una inicialixzacion y terminancion de los procesos
            //tipo de procesos
            //procesos estaticos se declaran al comienzodel programa
            //dinamicos hay determinados datos que hay hay que llamarlos para ejecutarlos
            //sistema ceerrado es cuando todo es estatico
            //sistema abierto varia ,
            //se pueden organizar procesos en forma idnependietne
            //forma jerarquizada dependientes entre si7
            //diferentes inicializaciones inicializar un proceso es darle informacion para que se ejecute
            //en java se inicializan en el main con el new, se crea<n metodos y el constructor
            //un proceso puede terminar por una interrupcion o una falla del programa, puede haber un problema con otro proceso
            //finaliza en forma coordinada con otro proceso
            //puede haber un bl¡ucle infinito no termina nunca
            //programacion treads son porcesos ligeros que se comparten en un mismo programa
            //clase trehad tiene un metodo run()puedo poner la ejecucion que yo quiera dentro de run
            //se inicia con start()
            //si saletodo bien termina normalmente
            //creacion por un trhead por herencia
            //yo creo un proceso con la clase trhead
            //yo utilizaria otra forma que no sea trhead, se crea una interface runnable, voy a tener que crear un trehad
            //ejemplo que debemos hacer
            //metodos run, start() se inicia, metodo para parar stop(), metodo current(thread)opara saber que se esta ejecutando, metodo slep()para que un programa se suspenda durnte cierto tiempo
            //si yo quiero que se ejecuten puedo darle yo el orden en que se deben ejecutar puedo dar setPriority()
            //ususertrhead
        }
        /*try{se usan cuando hay errores
            procesos[1].join();
        }
        catch(Exception E){}*/
    }
}
