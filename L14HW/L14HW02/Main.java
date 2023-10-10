public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] array3 = {11, 12, 13, 14, 15};

        SaveAsThread thread1 = new SaveAsThread(array1, "array1.txt");
        SaveAsThread thread2 = new SaveAsThread(array2, "array2.txt");
        SaveAsThread thread3 = new SaveAsThread(array3, "array3.txt");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}