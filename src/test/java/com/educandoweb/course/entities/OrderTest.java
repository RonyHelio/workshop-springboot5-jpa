package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderEntity() {
        User u = new User(1L, "Maria", "maria@gmail.com", "9999", "1234");
        Instant now = Instant.now();
        Order o1 = new Order(1L, now, u, OrderStatus.Waiting_Payment);

        assertEquals(1L, o1.getId());
        assertEquals(now, o1.getMoment());
        assertEquals(u, o1.getClient());
        assertEquals(OrderStatus.Waiting_Payment, o1.getStatus());

        o1.setId(2L);
        Instant later = Instant.now().plusSeconds(100);
        o1.setMoment(later);
        
        User u2 = new User();
        o1.setClient(u2);
        o1.setStatus(OrderStatus.Paid);

        assertEquals(2L, o1.getId());
        assertEquals(later, o1.getMoment());
        assertEquals(u2, o1.getClient());
        assertEquals(OrderStatus.Paid, o1.getStatus());

        Order o2 = new Order();
        o2.setId(2L);
        assertEquals(o1, o2);
        assertEquals(o1.hashCode(), o2.hashCode());

        Order o3 = new Order();
        o3.setId(3L);
        assertNotEquals(o1, o3);
        assertNotEquals(o1, null);
        assertNotEquals(o1, new Object());

        assertNotNull(o1.getItems());
        
        Payment p = new Payment(1L, now, o1);
        o1.setPayment(p);
        assertEquals(p, o1.getPayment());
        
        assertEquals(0.0, o1.GetTotal());
        
        o1.setStatus(null);
        assertEquals(OrderStatus.Paid, o1.getStatus()); // setStatus check null logic
    }
}
