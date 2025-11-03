package ua.edu.ucu.apps.lab8.decorator;

import ua.edu.ucu.apps.lab8.model.Item;

public class RomashkaFlower extends Item {
    @Override
    public double price() {
        return 100.0;
    }

    @Override
    public String getDescription() {
        return "Romashka flower";
    }
}
