package ua.edu.ucu.apps.lab8.decorator;

import ua.edu.ucu.apps.lab8.model.Item;

public class PaperDecorator extends AbstractItemDecorator {
    private static final double PAPER_COST = 13.0;

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return item.price() + PAPER_COST;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", wrapped in paper";
    }
}