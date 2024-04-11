package metodoIsAlive;

public class Main {
    public static void main(String[] args) {
        Obrera agente =new Obrera();
        agente.start();
// Hace algo durante el cálculo.
//Espera que agente haya terminado
        /*while (agente.isAlive()){
            //espera activa
        }*/
        try {
            agente.join(); // Espera a que el hilo agente termine.
        } catch (InterruptedException e) {
            // Manejo de excepciones si es necesario.
        }
// Utiliza el resultado.
        System.out.println(agente.getResultado());

}}
