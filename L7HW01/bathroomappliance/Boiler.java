package bathroomappliance;

public class Boiler extends BathroomAppliance {
    private int temperature;

    public Boiler(String type, String brand, double current, boolean isOn, double voltage) {
        super(type, brand, current, isOn, voltage);
        this.temperature = 0;
    }

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Температура бойлера установлена на " + temp + " градусов.");
    }

    public int getTemperature() {
        return temperature;
    }
}
