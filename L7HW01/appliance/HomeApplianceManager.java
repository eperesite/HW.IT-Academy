package Appliance;

import bathroomappliance.Boiler;
import bathroomappliance.WashingMachine;
import kitchenappliance.Fridge;
import kitchenappliance.Kettle;

import java.util.ArrayList;
import java.util.List;

public class HomeApplianceManager {
    public static void main(String[] args) {

        List<HomeAppliance> appliances = new ArrayList<>();

        Boiler boiler = new Boiler("Boiler", "BrandA", 3.5, false, 220);
        boiler.calculatePower();
        boiler.changeState();
        appliances.add(boiler);
        boiler.setTemperature(60);
        System.out.println("Текущая температура бойлера: " + boiler.getTemperature() + " градусов");

        WashingMachine washingMachine = new WashingMachine("WashingMachine", "BrandB", 2.5, false, 220);
        appliances.add(washingMachine);
        washingMachine.changeState();
        washingMachine.calculatePower();
        washingMachine.setWaterLevel(10);
        washingMachine.startWashing();

        Fridge fridge = new Fridge("Холодильник", "Samsung", 2.5, false, 220);
        appliances.add(fridge);
        fridge.changeState();
        fridge.calculatePower();
        fridge.setCoolingMode("экономия энергии");
        System.out.println("Режим охлаждения холодильника: " + fridge.getCoolingMode());

        Kettle kettle = new Kettle("Чайник", "Philips", 1.2, false, 220);
        appliances.add(kettle);
        kettle.changeState();
        kettle.calculatePower();
        kettle.checkWaterLevel();
        int currentWaterLevel = kettle.getWaterLevel();
        System.out.println("Текущий уровень воды: " + currentWaterLevel + " мл.");

        double totalPowerConsumption = HomeAppliance.calculateTotalPowerConsumption(appliances);
        System.out.println("Потребляемая мощность: " + totalPowerConsumption + " Вт");

        System.out.println("Сортировка по току: ");
        List<HomeAppliance> sortedAppliances = HomeAppliance.bubbleSortByCurrent(appliances);
        System.out.println(sortedAppliances);

        double minCurrent = 1.0;
        double maxCurrent = 2.0;

        HomeAppliance kitchenApplianceInCurrentRange = appliances.get(0).findKitchenApplianceInCurrentRange(appliances, minCurrent, maxCurrent);

        if (kitchenApplianceInCurrentRange != null) {
            System.out.println("Найден кухонный прибор в заданном диапазоне параметров: " + kitchenApplianceInCurrentRange);
        } else {
            System.out.println("Кухонный прибор в заданном диапазоне параметров не найден.");
        }


    }
}
