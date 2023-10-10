import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator extends Thread {
    private List<Integer> list;

    public Generator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(1000); 
        
            synchronized (list) {
                list.add(randomNumber);
                System.out.println(randomNumber);
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
