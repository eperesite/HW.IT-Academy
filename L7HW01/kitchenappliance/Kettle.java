package kitchenappliance;

public class Kettle extends KitchenAppliance {
    private final int waterLevel;

    public Kettle(String type, String brand, double current, boolean isOn, double voltage) {
        super(type, brand, current, isOn, voltage);
        this.waterLevel = 2;
    }

    public void checkWaterLevel() {
        if (getState()) {
            if (waterLevel > 0) {
                System.out.println("Уровень воды в чайнике: " + waterLevel + " мл.");
            } else {
                System.out.println("Внимание: Уровень воды в чайнике недостаточен.");
            }
        } else {
            System.out.println("Ошибка: Чайник выключен. Включите его перед проверкой уровня воды.");
        }
    }

    public int getWaterLevel() {
        return waterLevel;
    }

}
