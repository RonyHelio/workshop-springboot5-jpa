package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductEntity() {
        Product p1 = new Product("img.jpg", "Great product", "TV", 1, 2500.0);
        assertEquals(1, p1.getId());
        assertEquals("TV", p1.getName());
        assertEquals("Great product", p1.getDescription());
        assertEquals(2500.0, p1.getPrice());
        assertEquals("img.jpg", p1.getImgUrl());

        p1.setId(2);
        p1.setName("PC");
        p1.setDescription("Nice PC");
        p1.setPrice(3000.0);
        p1.setImgUrl("pc.jpg");
        
        assertEquals(2, p1.getId());
        assertEquals("PC", p1.getName());
        assertEquals("Nice PC", p1.getDescription());
        assertEquals(3000.0, p1.getPrice());
        assertEquals("pc.jpg", p1.getImgUrl());

        Product p2 = new Product();
        p2.setId(2);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());

        Product p3 = new Product();
        p3.setId(3);
        assertNotEquals(p1, p3);
        assertNotEquals(p1, null);
        assertNotEquals(p1, new Object());

        assertNotNull(p1.getCategories());
        assertNotNull(p1.getOrders());
    }
}
