public class TwoDimArrayIterator<T> {
    private T[][] matrix;
    private int iIndex = 0;
    private int jIndex = 0;

    public TwoDimArrayIterator(T[][] matrix) {
        this.matrix = matrix;
    }

    public boolean hasNext() {
        if (iIndex < matrix.length) {
            if (jIndex < matrix[iIndex].length) {
                return true;
            } else {
                iIndex++;
                jIndex = 0;
                return hasNext();
            }
        }
        return false;
    }

    public T next() {
        if (this.jIndex == matrix[iIndex].length) {
            iIndex++;
            jIndex = 0;
        } else {
            jIndex++;
        }
        return matrix[iIndex][jIndex - 1];
    }
}


