package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void testOrderItemEntity() {
        Order o = new Order();
        o.setId(1L);
        Product p = new Product();
        p.setId(1);
        
        OrderItem item = new OrderItem(o, p, 2, 50.0);
        
        assertEquals(o, item.getOrder());
        assertEquals(p, item.getProduct());
        assertEquals(2, item.getQuantity());
        assertEquals(50.0, item.getPrice());
        assertEquals(100.0, item.getSubTotal());

        Order o2 = new Order();
        o2.setId(2L);
        item.setOrder(o2);
        
        Product p2 = new Product();
        p2.setId(2);
        item.setProduct(p2);
        
        item.setQuantity(3);
        item.setPrice(60.0);

        assertEquals(o2, item.getOrder());
        assertEquals(p2, item.getProduct());
        assertEquals(3, item.getQuantity());
        assertEquals(60.0, item.getPrice());
        assertEquals(180.0, item.getSubTotal());

        OrderItem item2 = new OrderItem();
        item2.setOrder(o2);
        item2.setProduct(p2);
        
        assertEquals(item, item2);
        assertEquals(item.hashCode(), item2.hashCode());
        
        OrderItem item3 = new OrderItem();
        item3.setOrder(o);
        item3.setProduct(p);
        assertNotEquals(item, item3);
        assertNotEquals(item, null);
        assertNotEquals(item, new Object());
    }
}
