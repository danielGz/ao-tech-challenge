package com.agileengine.ecomm.service;

import com.agileengine.ecomm.openapi.model.PurchaseOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

 private OrderRepository orderRepository;

 public OrderService(OrderRepository orderRepository) {
  this.orderRepository = orderRepository;
 }

 @Transactional(readOnly = true)
 public List<PurchaseOrder> findAll() {
  return orderRepository.findAll();
 }

 @Transactional(readOnly = true)
 public PurchaseOrder findById(Long id) {
  return orderRepository.findById(id).orElse(null);
 }

 @Transactional
 public PurchaseOrder create(PurchaseOrder order) {
  return orderRepository.save(order);
 }

 @Transactional
 public PurchaseOrder update(PurchaseOrder order) {
  return orderRepository.save(order);
 }

 @Transactional
 public void delete(Long id) {
  orderRepository.deleteById(id);
 }
}
