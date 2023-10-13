import java.util.concurrent.Callable;

class ColumnSumCalculator implements Callable<Integer> {
    private int[][] matrix;

    public ColumnSumCalculator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}