package ejemploMonitorYEscritor;

public class Recurso {
    private int id;
    private String contenido;

    public Recurso(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
