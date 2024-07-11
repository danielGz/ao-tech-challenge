package com.agileengine.ecomm.controllers;

import com.agileengine.ecomm.EcommApplication;
import com.agileengine.ecomm.openapi.model.Product;
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
public class ProductControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAddAndGetProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(99.99F);
        product.setDescription("A test product");

        // POST a new product
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/products", product, Void.class);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        // GET the product
        ResponseEntity<Product[]> getResponse = restTemplate.getForEntity("http://localhost:" + port + "/api/products", Product[].class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        Product[] products = getResponse.getBody();
        assertEquals(1, products.length);
        assertEquals("Test Product", products[0].getName());
    }

    @Test
    public void testUpdateProduct() {
        // First, create a product
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(99.99F);
        product.setDescription("A test product");
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/products", product, Void.class);
        URI location = postResponse.getHeaders().getLocation();

        // Update the product
        product.setPrice(89.99F);
        restTemplate.put(location, product);

        // Retrieve and verify the updated product
        ResponseEntity<Product> response = restTemplate.getForEntity(location, Product.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(89.99F, response.getBody().getPrice());
    }

    @Test
    public void testDeleteProduct() {
        // First, create a product
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(99.99F);
        product.setDescription("A test product");
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/products", product, Void.class);
        URI location = postResponse.getHeaders().getLocation();

        // Delete the product
        restTemplate.delete(location);

        // Try to fetch the deleted product
        ResponseEntity<Product> response = restTemplate.getForEntity(location, Product.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
