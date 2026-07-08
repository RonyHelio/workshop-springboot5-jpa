package com.educandoweb.course.controller;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductResourceTest {

    @InjectMocks
    private ProductResource resource;

    @Mock
    private ProductService service;

    @Test
    public void testFindAll() {
        Product p1 = new Product("", "TV 4K", "TV", 1, 2500.0);
        when(service.findAll()).thenReturn(Arrays.asList(p1));

        ResponseEntity<List<Product>> response = resource.findAll();
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void testFindById() {
        Product p1 = new Product("", "TV 4K", "TV", 1, 2500.0);
        when(service.findById(1L)).thenReturn(p1);

        ResponseEntity<Product> response = resource.findById(1L);
        assertEquals(200, response.getStatusCode().value());
    }
}
