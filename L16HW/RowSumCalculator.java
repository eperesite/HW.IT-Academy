import java.util.concurrent.Callable;

class RowSumCalculator implements Callable<Integer> {
    private int[][] matrix;

    public RowSumCalculator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}