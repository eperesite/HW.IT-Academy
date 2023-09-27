public class Main {
    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>("Hello", "World");
        System.out.println("Original Pair: " + stringPair.first() + ", " + stringPair.last());

        stringPair.swap();
        System.out.println("After Swap: " + stringPair.first() + ", " + stringPair.last());

        stringPair.replaceFirst("Hi");
        stringPair.replaceLast("Java");
        System.out.println("After Replacements: " + stringPair.first() + ", " + stringPair.last());
    }
}
