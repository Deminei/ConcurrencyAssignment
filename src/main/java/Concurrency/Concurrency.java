package Concurrency;
public class Concurrency {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(1);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

