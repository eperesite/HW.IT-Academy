import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        Generator generator = new Generator(myList);
        generator.start();

        try {
            generator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
