import java.io.*;
import java.util.Arrays;

public class MergeSortFiles {
    public static void main(String[] args) {

        generateInputFiles("in1.txt", "in2.txt");

        int[] numbers1 = readFromFile("in1.txt");
        int[] numbers2 = readFromFile("in2.txt");

        Arrays.sort(numbers1);
        Arrays.sort(numbers2);

        int[] mergedNumbers = mergeArrays(numbers1, numbers2);

        writeToFile("out.txt", mergedNumbers);

        System.out.println("Отсортированные числа записаны в файл out.txt.");
    }

    private static void generateInputFiles(String file1, String file2) {
        try (PrintWriter writer1 = new PrintWriter(file1);
             PrintWriter writer2 = new PrintWriter(file2)) {
            for (int i = 0; i < 1000; i++) {
                int randomNumber1 = (int) (Math.random() * 100000) + 1;
                int randomNumber2 = (int) (Math.random() * 100000) + 1;
                writer1.println(randomNumber1);
                writer2.println(randomNumber2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] readFromFile(String fileName) {
        int[] numbers = new int[1000];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                numbers[index] = Integer.parseInt(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    private static void writeToFile(String fileName, int[] numbers) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int number : numbers) {
                writer.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}