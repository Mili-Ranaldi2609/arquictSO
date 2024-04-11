package ejerHERENCIA;

public class ThreadHerencia extends Thread{
    private String word;
    private int delay;

    public ThreadHerencia(String queDecir,int cadaCuantosMs) {
        word = queDecir;
        delay = cadaCuantosMs;
    }
    public void run(){ //Se sobrescribe run() de Thread
        while(true){
            System.out.print(word + " ");
            try{
                sleep(delay);
            } catch(InterruptedException e){ return; }
        }
}}
