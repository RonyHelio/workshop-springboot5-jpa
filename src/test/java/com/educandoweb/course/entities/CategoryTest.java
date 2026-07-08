package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testCategoryEntity() {
        Category c1 = new Category("Electronics", 1L);
        assertEquals(1L, c1.getId());
        assertEquals("Electronics", c1.getName());

        c1.setId(2L);
        c1.setName("Computers");
        assertEquals(2L, c1.getId());
        assertEquals("Computers", c1.getName());

        Category c2 = new Category();
        c2.setId(2L);
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());

        Category c3 = new Category();
        c3.setId(3L);
        assertNotEquals(c1, c3);
        assertNotEquals(c1, null);
        assertNotEquals(c1, new Object());

        assertNotNull(c1.getProducts());
    }
}
