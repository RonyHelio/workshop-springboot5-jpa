package com.educandoweb.course.controller;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderStatus;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderResourceTest {

    @InjectMocks
    private OrderResource resource;

    @Mock
    private OrderService service;

    @Test
    public void testFindAll() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        Order o1 = new Order(1L, Instant.now(), u1, OrderStatus.Waiting_Payment);
        when(service.findAll()).thenReturn(Arrays.asList(o1));

        ResponseEntity<List<Order>> response = resource.findAll();
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void testFindById() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        Order o1 = new Order(1L, Instant.now(), u1, OrderStatus.Waiting_Payment);
        when(service.findById(1L)).thenReturn(o1);

        ResponseEntity<Order> response = resource.findById(1L);
        assertEquals(200, response.getStatusCode().value());
    }
}
