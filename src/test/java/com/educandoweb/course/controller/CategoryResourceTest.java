package com.educandoweb.course.controller;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.service.CategoryService;
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
public class CategoryResourceTest {

    @InjectMocks
    private CategoryResource resource;

    @Mock
    private CategoryService service;

    @Test
    public void testFindAll() {
        Category c1 = new Category("Electronics", 1L);
        when(service.findAll()).thenReturn(Arrays.asList(c1));

        ResponseEntity<List<Category>> response = resource.findAll();
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void testFindById() {
        Category c1 = new Category("Electronics", 1L);
        when(service.findById(1L)).thenReturn(c1);

        ResponseEntity<Category> response = resource.findById(1L);
        assertEquals(200, response.getStatusCode().value());
    }
}
