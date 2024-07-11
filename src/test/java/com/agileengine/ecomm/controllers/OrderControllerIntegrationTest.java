package com.agileengine.ecomm.controllers;

import com.agileengine.ecomm.EcommApplication;
import com.agileengine.ecomm.openapi.model.PurchaseOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EcommApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAddAndGetOrder() {
        PurchaseOrder order = new PurchaseOrder();
        order.setStatus(PurchaseOrder.StatusEnum.PENDING);

        // POST a new order
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", order, Void.class);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        // GET the order
        ResponseEntity<PurchaseOrder[]> getResponse = restTemplate.getForEntity("http://localhost:" + port + "/api/orders", PurchaseOrder[].class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        PurchaseOrder[] orders = getResponse.getBody();
        assertEquals(1, orders.length);
        assertEquals(PurchaseOrder.StatusEnum.PENDING, orders[0].getStatus());
    }

    @Test
    public void testUpdateOrder() {
        // First, create an order
        PurchaseOrder order = new PurchaseOrder();
        order.setStatus(PurchaseOrder.StatusEnum.PENDING);
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", order, Void.class);
        URI location = postResponse.getHeaders().getLocation();

        // Update the order
        order.setStatus(PurchaseOrder.StatusEnum.COMPLETED);
        restTemplate.put(location, order);

        // Retrieve and verify the updated order
        ResponseEntity<PurchaseOrder> response = restTemplate.getForEntity(location, PurchaseOrder.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(PurchaseOrder.StatusEnum.COMPLETED, response.getBody().getStatus());
    }

    @Test
    public void testDeleteOrder() {
        // First, create an order
        PurchaseOrder order = new PurchaseOrder();
        order.setStatus(PurchaseOrder.StatusEnum.PENDING);
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", order, Void.class);
        URI location = postResponse.getHeaders().getLocation();

        // Delete the order
        restTemplate.delete(location);

        // Try to fetch the deleted order
        ResponseEntity<String> response = restTemplate.exchange(location, HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
