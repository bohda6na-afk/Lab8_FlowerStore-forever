package ua.edu.ucu.apps.lab8.decorator;

import ua.edu.ucu.apps.lab8.model.Item;

public class RibbonDecorator extends AbstractItemDecorator {
    private static final double RIBBON_COST = 40.0;

    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return item.price() + RIBBON_COST;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", decorated with ribbon";
    }
}
