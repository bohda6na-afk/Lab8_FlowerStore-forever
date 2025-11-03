package ua.edu.ucu.apps.lab8.strategy.delivery;

import ua.edu.ucu.apps.lab8.model.Item;
import java.util.List;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public void deliver(List<Item> items) {
        System.out.println("Delivering " + items.size() + " items via post");
        
    }
}
