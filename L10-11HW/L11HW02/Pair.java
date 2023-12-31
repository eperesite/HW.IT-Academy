public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T first() {
        return first;
    }

    public T last() {
        return last;
    }

    public void swap() {
        T temp = first;
        first = last;
        last = temp;
    }

    public void replaceFirst(T newFirst) {
        first = newFirst;
    }

    public void replaceLast(T newLast) {
        last = newLast;
    }


}