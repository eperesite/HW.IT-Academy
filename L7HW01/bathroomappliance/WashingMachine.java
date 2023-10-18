package bathroomappliance;

public class WashingMachine extends BathroomAppliance {
    private int waterLevel;

    public WashingMachine(String type, String brand, double current, boolean isOn, double voltage) {
        super(type, brand, current, isOn, voltage);
        this.waterLevel = 0;
    }

    public void setWaterLevel(int level) {
        waterLevel = level;
        System.out.println("Уровень воды в стиральной машине установлен на " + level + " литров.");
    }

    public void startWashing() {
        if (getState() && waterLevel > 0) {
            System.out.println("Стирка началась.");
        } else {
            System.out.println("Ошибка: Проверьте, что стиральная машина включена и уровень воды установлен.");
        }
    }

}
