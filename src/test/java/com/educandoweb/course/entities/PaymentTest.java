package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testPaymentEntity() {
        Order o = new Order();
        o.setId(1L);
        Instant now = Instant.now();
        
        Payment p = new Payment(1L, now, o);
        assertEquals(1L, p.getId());
        assertEquals(now, p.getMoment());
        assertEquals(o, p.getOrder());

        p.setId(2L);
        Instant later = Instant.now().plusSeconds(100);
        p.setMoment(later);
        
        Order o2 = new Order();
        o2.setId(2L);
        p.setOrder(o2);

        assertEquals(2L, p.getId());
        assertEquals(later, p.getMoment());
        assertEquals(o2, p.getOrder());
        
        Payment p2 = new Payment();
        p2.setId(2L);
        assertEquals(p, p2);
        assertEquals(p.hashCode(), p2.hashCode());

        Payment p3 = new Payment();
        p3.setId(3L);
        assertNotEquals(p, p3);
        assertNotEquals(p, null);
        assertNotEquals(p, new Object());
    }
}
