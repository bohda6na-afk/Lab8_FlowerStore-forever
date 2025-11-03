package ua.edu.ucu.apps.lab8.model;

import ua.edu.ucu.apps.lab8.strategy.delivery.Delivery;
import ua.edu.ucu.apps.lab8.strategy.payment.Payment;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(Item::price)
                .sum();
    }

    public void processOrder() {
        if (payment == null || delivery == null) {
            throw new IllegalStateException("Payment and delivery strategies must be set");
        }
        
        double totalPrice = calculateTotalPrice();
        payment.pay(totalPrice);
        delivery.deliver(items);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
