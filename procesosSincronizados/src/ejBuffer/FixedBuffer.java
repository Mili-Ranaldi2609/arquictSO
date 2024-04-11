package ejBuffer;

public class FixedBuffer implements Buffer{
    Object[] buf;
    int in = 0;
    int out = 0;
    int count= 0;
    int size;
    public FixedBuffer(int size){
        this.size= size;
        buf = new Object[size];
    }

    public synchronized void put(Object obj)
            throws InterruptedException{

        while (count == size) wait();
        buf[in]=obj;
        count= count +1;
        in=(in+1)%size;
        notifyAll();
    }
    public synchronized Object get()
            throws InterruptedException{

        while (count == 0) wait();
        Object obj= buf[out];
        buf[out]=null;
        count= count -1;
        out= (out+1) % size;
        notifyAll();
        return (obj);
    }
}
