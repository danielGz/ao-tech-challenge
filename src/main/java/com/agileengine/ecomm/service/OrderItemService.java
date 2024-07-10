package com.agileengine.ecomm.service;

import com.agileengine.ecomm.openapi.model.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemService {

 private final OrderItemRepository orderItemRepository;

 public OrderItemService(OrderItemRepository orderItemRepository) {
  this.orderItemRepository = orderItemRepository;
 }

 @Transactional(readOnly = true)
 public List<OrderItem> findAll() {
  return orderItemRepository.findAll();
 }

 @Transactional(readOnly = true)
 public OrderItem findById(Long id) {
  return orderItemRepository.findById(id).orElse(null);
 }

 @Transactional
 public OrderItem create(OrderItem orderItem) {
  return orderItemRepository.save(orderItem);
 }

 @Transactional
 public OrderItem update(OrderItem orderItem) {
  return orderItemRepository.save(orderItem);
 }

 @Transactional
 public void delete(Long id) {
  orderItemRepository.deleteById(id);
 }
}
