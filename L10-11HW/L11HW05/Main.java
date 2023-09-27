public class Main {
    public static void main(String[] args) {
        Food[] ingredients = {
                new Vegetable("Broccoli"),
                new Fruit("Apple"),
                new Meat("Chicken")
        };

        boolean isAllVegetarian = FoodChecker.isVegetarian(ingredients);
        System.out.println("Are all ingredients vegetarian? " + isAllVegetarian);
    }
}