
public class Main {
    public static void main(String[] args) {
        Integer[][] twoDArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        TwoDArrayIterator<Integer> rowIterator = new TwoDArrayIterator<>(twoDArray, Direction.ROW);
        TwoDArrayIterator<Integer> colIterator = new TwoDArrayIterator<>(twoDArray, Direction.COLUMN);

        System.out.println("Итерация по строкам:");
        while (rowIterator.hasNext()) {
            System.out.print(rowIterator.next() + " ");
        }
        System.out.println();

        System.out.println("Итерация по столбцам:");
        while (colIterator.hasNext()) {
            System.out.print(colIterator.next() + " ");
        }
        System.out.println();
    }
}