public class MinFinderRunnable implements Runnable {
    private final int[] array;
    private int mix;

    public MinFinderRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {

        mix = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < mix) {
                mix = array[i];
            }
        }
    }

    public int getMin() {
        return mix;
    }
}
