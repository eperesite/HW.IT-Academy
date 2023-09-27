class Fruit extends Food {
    public Fruit(String name) {
        super(name);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.FRUIT;
    }
}