import java.util.Iterator;
import java.util.NoSuchElementException;

class TwoDArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int row, col;
    private final Direction direction;

    public TwoDArrayIterator(T[][] array, Direction direction) {
        this.array = array;
        this.direction = direction;
        row = 0;
        col = 0;
    }

    @Override
    public boolean hasNext() {
        if (direction == Direction.ROW) {
            return row < array.length && col < array[row].length;
        } else {
            return col < array[0].length && row < array.length;
        }
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T element;
        if (direction == Direction.ROW) {
            element = array[row][col];
            col++;
            if (col >= array[row].length) {
                col = 0;
                row++;
            }
        } else {
            element = array[row][col];
            row++;
            if (row >= array.length) {
                row = 0;
                col++;
            }
        }

        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}