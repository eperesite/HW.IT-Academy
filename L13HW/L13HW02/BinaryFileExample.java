import java.io.*;
import java.util.Random;

public class BinaryFileExample {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("numbers.dat")) {
            Random random = new Random();
            for (int i = 0; i < 30; i++) {
                int randomNumber = random.nextInt(100) + 1;
                fileOutputStream.write(randomNumber);
            }
            System.out.println("Файл numbers.dat успешно создан и заполнен случайными числами.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("numbers.dat")) {
            int sum = 0;
            for (int i = 0; i < 30; i++) {
                int number = fileInputStream.read();
                System.out.println("Прочитано число: " + number);
                sum += number;
            }
            double average = (double) sum / 30;
            System.out.println("Среднее арифметическое: " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}