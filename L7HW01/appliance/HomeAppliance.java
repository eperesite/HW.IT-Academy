package Appliance;

import kitchenappliance.KitchenAppliance;

import java.util.ArrayList;
import java.util.List;

public abstract class HomeAppliance {
    List<HomeAppliance> appliances = new ArrayList<>();

    private final String type;
    private final String brand;
    private final double current;
    private boolean isOn;
    private double power = 0;
    private double voltage;

    public HomeAppliance(String type, String brand, double current, boolean isOn, double voltage) {
        this.type = type;
        this.brand = brand;
        this.current = current;
        this.isOn = isOn;
        this.voltage = voltage;
    }

    public void changeState() {
        this.isOn = !this.isOn;
        if (isOn) {
            calculatePower();
        } else {
            power = 0;
        }
    }

    public double calculatePower() {

        power = voltage * current;
        return power;
    }

    public static double calculateTotalPowerConsumption(List<HomeAppliance> appliances) {
        double totalPowerConsumption = 0;
        for (HomeAppliance appliance : appliances) {
            appliance.changeState();
            double powerConsumption = appliance.calculatePower();
            totalPowerConsumption += powerConsumption;
        }
        return totalPowerConsumption;
    }

    public static List<HomeAppliance> bubbleSortByCurrent(List<HomeAppliance> appliances) {
        int n = appliances.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (appliances.get(i - 1).getCurrent() > appliances.get(i).getCurrent()) {
                    HomeAppliance temp = appliances.get(i - 1);
                    appliances.set(i - 1, appliances.get(i));
                    appliances.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
        return appliances;
    }

    public HomeAppliance findKitchenApplianceInCurrentRange(List<HomeAppliance> appliances, double minCurrent, double maxCurrent) {
        for (HomeAppliance appliance : appliances) {
            if (appliance instanceof KitchenAppliance) {
                double current = appliance.getCurrent();
                if (current >= minCurrent && current <= maxCurrent) {
                    return appliance;
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "{" +
                "type " + type +
                ", brand " + brand +
                ", current " + current +
                ", power " + power +
                "}" + "\n";
    }

    public double getCurrent() {
        return current;
    }

    public boolean getState() {
        return isOn;
    }
}

