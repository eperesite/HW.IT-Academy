package bathroomappliance;

import Appliance.HomeAppliance;

public abstract class BathroomAppliance extends HomeAppliance {
    public BathroomAppliance(String type, String brand, double current, boolean isOn, double voltage) {
        super(type, brand, current, isOn, voltage);
    }
}
