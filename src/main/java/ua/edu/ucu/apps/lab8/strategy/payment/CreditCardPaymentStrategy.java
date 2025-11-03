package ua.edu.ucu.apps.lab8.strategy.payment;

public class CreditCardPaymentStrategy implements Payment {
    @Override
    public void pay(double price) {
        System.out.println("Paying " + price + " via credit card");
    }
}