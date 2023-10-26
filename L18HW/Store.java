import java.util.concurrent.Semaphore;

class Store {
    private int item;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty = new Semaphore(1);
    private Semaphore full = new Semaphore(0);

    public void put(int item) {
        try {
            empty.acquire();
            mutex.acquire();
            this.item = item;
            System.out.println("Producer produced item: " + item);
            mutex.release();
            full.release();
        }  catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public int get() {
        int item = 0;
        try {
            full.acquire();
            mutex.acquire();
            item = this.item;
            System.out.println("Consumer consumed item: " + item);
            mutex.release();
            empty.release();
        } catch  (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }
}
