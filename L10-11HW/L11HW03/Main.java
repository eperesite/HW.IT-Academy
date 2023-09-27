
public class Main {
    public static void main(String[] args) {

        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 7};
        Integer[][] matrix = {{0, 1, 2, 3}, {0, 7}, {0, 1, 2, 3, 4, 5, 6, 7, 7}};

        ArrayIterator<Integer> iterator = new ArrayIterator<>(numbers);
        TwoDimArrayIterator<Integer> matrixIterator = new TwoDimArrayIterator<>(matrix);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        while (matrixIterator.hasNext()) {
            System.out.println(matrixIterator.next());
        }

    }
}