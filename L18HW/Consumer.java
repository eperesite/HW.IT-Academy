class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int item = store.get();
            try {
                Thread.sleep(1000); // Simulate consumption time
            }  catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}