package ua.edu.ucu.apps.lab8.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import ua.edu.ucu.apps.lab8.decorator.*;
import ua.edu.ucu.apps.lab8.strategy.delivery.PostDeliveryStrategy;
import ua.edu.ucu.apps.lab8.strategy.delivery.DHLDeliveryStrategy;
import ua.edu.ucu.apps.lab8.strategy.payment.CreditCardPaymentStrategy;
import ua.edu.ucu.apps.lab8.strategy.payment.PayPalPaymentStrategy;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testAddItem() {
        Item flower = new CactusFlower();
        order.addItem(flower);
        
        assertEquals(1, order.getItems().size());
        assertEquals(50.0, order.calculateTotalPrice());
    }

    @Test
    void testAddMultipleItems() {
        order.addItem(new CactusFlower());
        order.addItem(new RomashkaFlower());
        order.addItem(new PaperDecorator(new CactusFlower()));
        
        assertEquals(3, order.getItems().size());
        assertEquals(213.0, order.calculateTotalPrice());
    }

    @Test
    void testRemoveItem() {
        Item flower = new CactusFlower();
        order.addItem(flower);
        order.addItem(new RomashkaFlower());
        
        order.removeItem(flower);
        
        assertEquals(1, order.getItems().size());
        assertEquals(100.0, order.calculateTotalPrice());
    }

    @Test
    void testProcessOrderWithCreditCardAndPost() {
        order.addItem(new CactusFlower());
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        
        assertDoesNotThrow(() -> order.processOrder());
    }

    @Test
    void testProcessOrderWithPayPalAndDHL() {
        order.addItem(new RomashkaFlower());
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        order.setDeliveryStrategy(new DHLDeliveryStrategy());
        
        assertDoesNotThrow(() -> order.processOrder());
    }

    @Test
    void testProcessOrderWithoutPaymentStrategy() {
        order.addItem(new CactusFlower());
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            order.processOrder();
        });
        
        assertTrue(exception.getMessage().contains("Payment and delivery strategies must be set"));
    }

    @Test
    void testProcessOrderWithoutDeliveryStrategy() {
        order.addItem(new CactusFlower());
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            order.processOrder();
        });
        
        assertTrue(exception.getMessage().contains("Payment and delivery strategies must be set"));
    }

    @Test
    void testCalculateTotalPriceWithDecorators() {
        Item decoratedFlower = new RibbonDecorator(
            new BasketDecorator(
                new PaperDecorator(new CactusFlower())
            )
        );
        
        order.addItem(decoratedFlower);
        order.addItem(new RomashkaFlower());
        
        assertEquals(207.0, order.calculateTotalPrice());
    }
}
