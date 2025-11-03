package ua.edu.ucu.apps.lab8.decorator;
import ua.edu.ucu.apps.lab8.model.Item;

public abstract class AbstractItemDecorator extends Item {
    protected Item item;

    public AbstractItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public abstract double price();

    @Override
    public abstract String getDescription();
} 
