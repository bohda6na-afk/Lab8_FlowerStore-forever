package ua.edu.ucu.apps.lab8.strategy.delivery;

import ua.edu.ucu.apps.lab8.model.Item;
import java.util.List;

public interface Delivery {
    void deliver(List<Item> items);
}
