import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>(Arrays.asList(5, 8, 12, 3, 17, 6, 9));

        Integer min = col.stream().min(Integer::compareTo).orElse(null);

        Integer max = col.stream().max(Integer::compareTo).orElse(null);

        double average = col.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        int product = col.stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);

        int sum = col.stream().mapToInt(Integer::intValue).sum();

        int sumOfDigits = col.stream().flatMapToInt(num -> String.valueOf(num).chars()).map(Character::getNumericValue).sum();

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
        System.out.println("Среднее арифметическое: " + average);
        System.out.println("Произведение всех чисел: " + product);
        System.out.println("Сумма всех чисел: " + sum);
        System.out.println("Сумма всех цифр: " + sumOfDigits);
    }
}