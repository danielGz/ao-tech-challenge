package com.agileengine.ecomm.controllers;

import com.agileengine.ecomm.openapi.ProductApi;
import com.agileengine.ecomm.openapi.model.Product;
import com.agileengine.ecomm.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController implements ProductApi {

 private ProductService productService;

 public ProductController(ProductService productService) {
  this.productService = productService;
 }

 @Override
 public ResponseEntity<List<Product>> productsGet() {
  List<Product> products = productService.findAll();
  return ResponseEntity.ok(products);
 }

 @Override
 public ResponseEntity<Void> productsIdDelete(String id) {
  productService.delete(Long.parseLong(id));
  return ResponseEntity.noContent().build();
 }

 @Override
 public ResponseEntity<Product> productsIdGet(String id) {
  Product product = productService.findById(Long.parseLong(id));
  return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
 }

 @Override
 public ResponseEntity<Product> productsIdPut(String id, Product product) {
  product.setId(Long.parseLong(id));
  Product updatedProduct = productService.update(product);
  return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
 }

 @Override
 public ResponseEntity<Product> productsPost(Product product) {
  Product createdProduct = productService.create(product);
  URI location = URI.create("/api/products/" + createdProduct.getId());
  return ResponseEntity.created(location).body(createdProduct);
 }
}
