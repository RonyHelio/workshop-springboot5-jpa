package com.educandoweb.course.service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
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
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Test
    public void testFindAll() {
        Product p = new Product();
        when(repository.findAll()).thenReturn(Arrays.asList(p));
        List<Product> result = service.findAll();
        assertEquals(1, result.size());
    }

    @Test
    public void testFindById() {
        Product p = new Product();
        when(repository.findById(1L)).thenReturn(Optional.of(p));
        Product result = service.findById(1L);
        assertEquals(p, result);
    }
}
