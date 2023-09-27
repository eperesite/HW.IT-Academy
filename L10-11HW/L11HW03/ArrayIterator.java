public class ArrayIterator<T> {

    private T[] array;
    private int index = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return this.index < array.length;
    }

    public T next() {
        this.index++;
        return this.array[index - 1];
    }

}
