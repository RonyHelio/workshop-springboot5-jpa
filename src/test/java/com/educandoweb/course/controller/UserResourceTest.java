package com.educandoweb.course.controller;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserResourceTest {

    @InjectMocks
    private UserResource resource;

    @Mock
    private UserService service;

    @Test
    public void testFindAll() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(service.findAll()).thenReturn(Arrays.asList(u1));

        ResponseEntity<List<User>> response = resource.findAll();
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testFindById() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(service.findById(1L)).thenReturn(u1);

        ResponseEntity<User> response = resource.findById(1L);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Maria", response.getBody().getName());
    }

    @Test
    public void testInsert() {
        org.springframework.mock.web.MockHttpServletRequest request = new org.springframework.mock.web.MockHttpServletRequest();
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));

        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(service.insert(any(User.class))).thenReturn(u1);

        ResponseEntity<User> response = resource.insert(u1, org.springframework.web.util.UriComponentsBuilder.newInstance());
        assertEquals(201, response.getStatusCode().value());
        
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
    }

    @Test
    public void testDelete() {
        doNothing().when(service).delete(1L);
        ResponseEntity<Void> response = resource.delete(1L);
        assertEquals(204, response.getStatusCode().value());
    }

    @Test
    public void testUpdate() {
        User u1 = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        when(service.update(eq(1L), any(User.class))).thenReturn(u1);

        ResponseEntity<User> response = resource.update(1L, u1);
        assertEquals(200, response.getStatusCode().value());
    }
}
