import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");

        myList = myList.stream().filter(str -> !str.contains("3")).sorted((s1, s2) -> {
                    int numComparison = Character.compare(s1.charAt(1), s2.charAt(1));
                    if (numComparison == 0) {
                        return s2.compareTo(s1);
                    }
                    return numComparison;
                })
                .skip(1).limit(myList.size() - 2).map(String::toUpperCase).toList();

        myList.forEach(System.out::println);

        int count = myList.size();
        System.out.println("Количество оставшихся элементов: " + count);
    }
}