import java.io.FileWriter;
import java.io.IOException;

class SaveAsThread extends Thread {
    private int[] array;
    private String filename;

    public SaveAsThread(int[] array, String filename) {
        this.array = array;
        this.filename = filename;
    }

    @Override
    public void run() {
        synchronized (SaveAsThread.class) {
            try (FileWriter writer = new FileWriter(filename)) {
                for (int value : array) {
                    writer.write(value + " ");
                }
                writer.flush();
                System.out.println("Массив записан в файл: " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
