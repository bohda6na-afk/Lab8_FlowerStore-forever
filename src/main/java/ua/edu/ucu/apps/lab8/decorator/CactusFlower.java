package ua.edu.ucu.apps.lab8.decorator;

import ua.edu.ucu.apps.lab8.model.Item;

public class CactusFlower extends Item {
    @Override
    public double price() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Cactus flower";
    }
}
