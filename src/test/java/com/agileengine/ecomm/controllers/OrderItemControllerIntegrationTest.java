package com.agileengine.ecomm.controllers;

import com.agileengine.ecomm.EcommApplication;
import com.agileengine.ecomm.openapi.model.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EcommApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAddAndGetOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(10);
        orderItem.setPrice(19.99F);

        // POST a new order item
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/order-items", orderItem, Void.class);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        // GET the order item
        ResponseEntity<OrderItem[]> getResponse = restTemplate.getForEntity("http://localhost:" + port + "/api/order-items", OrderItem[].class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        OrderItem[] orderItems = getResponse.getBody();
        assertEquals(1, orderItems.length);
        assertEquals(10, orderItems[0].getQuantity());
    }

    @Test
    public void testUpdateOrderItem() {
        // First, create an order item
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(10);
        orderItem.setPrice(19.99F);
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/order-items", orderItem, Void.class);
        URI location = postResponse.getHeaders().getLocation();

        // Update the order item
        orderItem.setQuantity(20);
        restTemplate.put(location, orderItem);

        // Retrieve and verify the updated order item
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(location, OrderItem.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(20, response.getBody().getQuantity());
    }

    @Test
    public void testDeleteOrderItem() {
        // First, create an order item
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(10);
        orderItem.setPrice(19.99F);
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/order-items", orderItem, Void.class);
        URI location = postResponse.getHeaders().getLocation();

        // Delete the order item
        restTemplate.delete(location);

        // Try to fetch the deleted order item
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(location, OrderItem.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


}
