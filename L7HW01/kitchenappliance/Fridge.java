package kitchenappliance;

public class Fridge extends KitchenAppliance {
    private String coolingMode;

    public Fridge(String type, String brand, double current, boolean isOn, double voltage) {
        super(type, brand, current, isOn, voltage);
        this.coolingMode = "обычный";
    }

    public void setCoolingMode(String mode) {
        if (getState()) {
            if (mode.equals("обычный")) {
                coolingMode = "обычный";

            } else if (mode.equals("экономия энергии")) {
                coolingMode = "экономия энергии";

            } else {
                System.out.println("Ошибка: Неизвестный режим охлаждения.");
            }
        } else {
            System.out.println("Ошибка: Холодильник выключен. Включите его перед изменением режима охлаждения.");
        }
    }

    public String getCoolingMode() {
        return coolingMode;
    }
}
