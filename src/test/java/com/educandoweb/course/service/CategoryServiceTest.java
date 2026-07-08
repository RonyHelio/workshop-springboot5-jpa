package com.educandoweb.course.service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
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
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository repository;

    @Test
    public void testFindAll() {
        Category c = new Category("Test", 1L);
        when(repository.findAll()).thenReturn(Arrays.asList(c));
        List<Category> result = service.findAll();
        assertEquals(1, result.size());
    }

    @Test
    public void testFindById() {
        Category c = new Category("Test", 1L);
        when(repository.findById(1L)).thenReturn(Optional.of(c));
        Category result = service.findById(1L);
        assertEquals(c, result);
    }
}
