import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMultiplier {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int m = 4;

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> rowSumFuture = executor.submit(new RowSumCalculator(matrix));
        Future<Integer> columnSumFuture = executor.submit(new ColumnSumCalculator(matrix));

        int rowSum = rowSumFuture.get();
        int columnSum = columnSumFuture.get();

        System.out.println("Сумма значений в строках: " + rowSum);
        System.out.println("Сумма значений в столбцах: " + columnSum);

        if (rowSum > columnSum) {
            System.out.println("Сумма значений в строках больше.");
        } else if (rowSum < columnSum) {
            System.out.println("Сумма значений в столбцах больше.");
        } else {
            System.out.println("Суммы значений в строках и столбцах равны.");
        }

        executor.shutdown();
    }
}