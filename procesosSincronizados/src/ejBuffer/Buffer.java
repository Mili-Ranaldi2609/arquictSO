package ejBuffer;

public interface Buffer {
    public void put(Object obj)

            throws InterruptedException;

    public Object get()

            throws InterruptedException;
}
