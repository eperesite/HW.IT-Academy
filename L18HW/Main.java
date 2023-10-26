public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Thread producerThread = new Thread(new Producer(store));
        Thread consumerThread = new Thread(new Consumer(store));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        }  catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}