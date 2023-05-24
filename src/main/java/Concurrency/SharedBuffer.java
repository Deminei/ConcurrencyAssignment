package Concurrency;

public class SharedBuffer {
    private final int[] buffer;//integer array to store the elements
    private final int size;
    private int count;
    private int in;
    private int out;

    public SharedBuffer(int size) {
        buffer = new int[size];
        this.size = size;
        count = 0;
        in = 0;
        out = 0;
    }

    public synchronized void produce(int value) {
        while (count == size) {//buffer is full
            try {
                wait(); //waits for consumer to consume elements
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer[in] = value;
        in = (in + 1) % size;
        count++;

        notifyAll(); //notifies consumer that new element is available
    }

    public synchronized int consume() {
        while (count == 0) {//buffer is empty
            try {
                wait(); //waits for producer to produce elements
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int value = buffer[out];
        out = (out + 1) % size;
        count--;

        notifyAll(); //notifies producer that space is available

        return value;
    }
}
