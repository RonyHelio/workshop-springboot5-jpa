package com.educandoweb.course.entities;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserEntity() {
        User user = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        
        assertEquals(1L, user.getId());
        assertEquals("Maria Brown", user.getName());
        assertEquals("maria@gmail.com", user.getEmail());
        assertEquals("988888888", user.getPhone());
        assertEquals("123456", user.getPassword());
        
        user.setId(2L);
        user.setName("Alex Green");
        user.setEmail("alex@gmail.com");
        user.setPhone("977777777");
        user.setPassword("654321");
        
        assertEquals(2L, user.getId());
        assertEquals("Alex Green", user.getName());
        assertEquals("alex@gmail.com", user.getEmail());
        assertEquals("977777777", user.getPhone());
        assertEquals("654321", user.getPassword());
        
        assertNotNull(user.getOrders());
        
        User user2 = new User();
        user2.setId(2L);
        assertEquals(user, user2);
        assertEquals(user.hashCode(), user2.hashCode());
        
        User user3 = new User();
        user3.setId(3L);
        assertNotEquals(user, user3);
        assertNotEquals(user, null);
        assertNotEquals(user, new Object());
    }
}
