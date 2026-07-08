package com.educandoweb.course.service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.service.exceptions.DatabaseException;
import com.educandoweb.course.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    public void testFindAll() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(repository.findAll()).thenReturn(Arrays.asList(u1));

        List<User> result = service.findAll();
        assertEquals(1, result.size());
    }

    @Test
    public void testFindById() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(repository.findById(1L)).thenReturn(Optional.of(u1));

        User result = service.findById(1L);
        assertEquals(u1, result);
    }

    @Test
    public void testFindByIdNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(1L);
        });
    }

    @Test
    public void testInsert() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(repository.save(any(User.class))).thenReturn(u1);

        User result = service.insert(u1);
        assertEquals(u1, result);
    }

    @Test
    public void testDelete() {
        doNothing().when(repository).deleteById(1L);
        service.delete(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteNotFound() {
        doThrow(new org.springframework.dao.EmptyResultDataAccessException(1)).when(repository).deleteById(1L);
        assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(1L);
        });
    }

    @Test
    public void testUpdate() {
        User existing = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        User updated = new User(1L, "Maria Updated", "maria@gmail.com", "9999999", "12345");
        when(repository.getReferenceById(1L)).thenReturn(existing);
        when(repository.save(any(User.class))).thenReturn(existing);

        User result = service.update(1L, updated);
        assertEquals("Maria Updated", result.getName());
    }

    @Test
    public void testUpdateNotFound() {
        User updated = new User(1L, "Maria Updated", "maria@gmail.com", "9999999", "12345");
        when(repository.getReferenceById(1L)).thenThrow(new jakarta.persistence.EntityNotFoundException());

        assertThrows(ResourceNotFoundException.class, () -> {
            service.update(1L, updated);
        });
    }
}
