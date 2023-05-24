package Concurrency;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final Random random;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {//specifies 5 iterations
                int value = random.nextInt(100);//generates random number
                buffer.produce(value);//adds random number to buffer
                System.out.println("Producer produced: " + value);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
