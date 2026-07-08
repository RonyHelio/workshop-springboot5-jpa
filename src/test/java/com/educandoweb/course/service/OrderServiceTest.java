package com.educandoweb.course.service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService service;

    @Mock
    private OrderRepository repository;

    @Test
    public void testFindAll() {
        Order o = new Order();
        when(repository.findAll()).thenReturn(Arrays.asList(o));
        List<Order> result = service.findAll();
        assertEquals(1, result.size());
    }

    @Test
    public void testFindById() {
        Order o = new Order();
        when(repository.findById(1L)).thenReturn(Optional.of(o));
        Order result = service.findById(1L);
        assertEquals(o, result);
    }
}
