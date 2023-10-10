import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ведите размер массива");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Введите элементы массива");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        MaxFinderRunnable maxFinderRunnable = new MaxFinderRunnable(array);
        MinFinderRunnable minFinderRunnable = new MinFinderRunnable(array);

        Thread maxThread = new Thread(maxFinderRunnable);
        Thread minThread = new Thread(minFinderRunnable);

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int maxResult = maxFinderRunnable.getMax();
        int minResult = minFinderRunnable.getMin();

        System.out.println("Минимальный: " + minResult);
        System.out.println("Максимальный: " + maxResult);
    }
}