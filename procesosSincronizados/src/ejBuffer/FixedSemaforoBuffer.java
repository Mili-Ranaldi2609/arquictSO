package ejBuffer;

public class FixedSemaforoBuffer {
    protected Object[] buf;
    protected int in = 0;
    protected int out = 0;
    protected int count = 0;
    protected int size;
    ejemploSemaforo.Semaforo full = new ejemploSemaforo.Semaforo(0);
    ejemploSemaforo.Semaforo empty;

    public FixedSemaforoBuffer(int size) {
        this.size = size;
        buf = new Object[size];
        empty = new ejemploSemaforo.Semaforo(size);
    }

    public void put(Object obj) throws InterruptedException {
        empty.await();
        synchronized (this) {
            buf[in] = obj;
            count = count + 1;
            in = (in + 1) % size;
        }
        full.signal();
    }

    public Object get() throws InterruptedException {
        full.await();
        synchronized (this) {
            Object obj = buf[out];
            buf[out] = null;
            count = count - 1;
            out = (out + 1) % size;
            return obj;
        }
    }
}
