public class MaxFinderRunnable implements Runnable {
    private final int[] array;
    private int max;

    public MaxFinderRunnable(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {

        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }

    public int getMax() {
        return max;

    }
}
