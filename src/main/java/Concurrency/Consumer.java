package Concurrency;

public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int sum = 0;
            for (int i = 0; i < 5; i++) {//specifies 5 iterations
                int value = buffer.consume();//retrieve number from buffer
                sum += value;//calculates the sum
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(500);
            }
            System.out.println("Sum of consumed numbers: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
