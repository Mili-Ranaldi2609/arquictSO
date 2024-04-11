package ejercicio1;
//Si se ejecuta la clase WaNot se producirá un error en tiempo de ejecución.
// Se esta llamando al método wait() dentro de un método (amethod())
// que no está sincronizado con ningún objeto en particular.
//
//Cuando se llama a wait() sin una declaración synchronized,
// se lanza una excepción IllegalMonitorStateException.
// Para utilizar wait(), notify(), o notifyAll(),
//se  debe hacer dentro de un bloque synchronized en Java.
public class WaNot extends Thread{
    int i=0;
    public static void main(String argv[]){
        WaNot w = new WaNot();
        w.amethod();


    }
    public synchronized void amethod() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Manejar la interrupción de forma adecuada
                e.printStackTrace();
            }
            i++;
        }//End of while
    /*public void amethod(){
        while(true){
            try{
                wait();
            }catch (InterruptedException e) {}
            i++;
        }*///End of while
    }//End of amethod
}//End of class

