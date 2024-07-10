package com.agileengine.ecomm.service;

import com.agileengine.ecomm.openapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

 @Autowired
 private ProductRepository productRepository;

 @Transactional(readOnly = true)
 public List<Product> findAll() {
  return productRepository.findAll();
 }

 @Transactional(readOnly = true)
 public Product findById(Long id) {
  return productRepository.findById(id).orElse(null);
 }

 @Transactional
 public Product create(Product product) {
  return productRepository.save(product);
 }

 @Transactional
 public Product update(Product product) {
  return productRepository.save(product);
 }

 @Transactional
 public void delete(Long id) {
  productRepository.deleteById(id);
 }
}
