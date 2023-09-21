package L9HW02;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public Map<Character, Integer> getCharsCount(String s) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        return charCountMap;
    }

    public static void main(String[] args) {
        Main counter = new Main();
        String inputString = "baaccc";
        Map<Character, Integer> charCountResult = counter.getCharsCount(inputString);

        for (Map.Entry<Character, Integer> entry : charCountResult.entrySet()) {
            System.out.println("'" + entry.getKey() + "' - " + entry.getValue());
        }
    }
}