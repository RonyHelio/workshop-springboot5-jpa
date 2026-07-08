package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderStatusTest {

    @Test
    public void testOrderStatus() {
        assertEquals(OrderStatus.Waiting_Payment, OrderStatus.valueOf(1));
        assertEquals(OrderStatus.Paid, OrderStatus.valueOf(2));
        assertEquals(OrderStatus.Shipped, OrderStatus.valueOf(3));
        assertEquals(OrderStatus.Delivered, OrderStatus.valueOf(4));
        assertEquals(OrderStatus.Cancelled, OrderStatus.valueOf(5));

        assertThrows(IllegalArgumentException.class, () -> {
            OrderStatus.valueOf(99);
        });
    }
}
