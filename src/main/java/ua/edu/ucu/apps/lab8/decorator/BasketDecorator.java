package ua.edu.ucu.apps.lab8.decorator;

import ua.edu.ucu.apps.lab8.model.Item;

public class BasketDecorator extends AbstractItemDecorator {
    private static final double BASKET_COST = 4.0;

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return item.price() + BASKET_COST;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", placed in a basket";
    }
}
