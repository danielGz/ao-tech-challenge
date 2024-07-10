package com.agileengine.ecomm.controllers;

import com.agileengine.ecomm.openapi.OrderItemApi;
import com.agileengine.ecomm.openapi.model.OrderItem;
import com.agileengine.ecomm.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController implements OrderItemApi {

 private final OrderItemService orderItemService;

 public OrderItemController(OrderItemService orderItemService) {
  this.orderItemService = orderItemService;
 }

 @Override
 public ResponseEntity<List<OrderItem>> orderItemsGet() {
  List<OrderItem> orderItems = orderItemService.findAll();
  return ResponseEntity.ok(orderItems);
 }

 @Override
 public ResponseEntity<Void> orderItemsIdDelete(String id) {
  orderItemService.delete(Long.parseLong(id));
  return ResponseEntity.noContent().build();
 }

 @Override
 public ResponseEntity<OrderItem> orderItemsIdGet(String id) {
  OrderItem orderItem = orderItemService.findById(Long.parseLong(id));
  return orderItem != null ? ResponseEntity.ok(orderItem) : ResponseEntity.notFound().build();
 }

 @Override
 public ResponseEntity<Void> orderItemsIdPut(String id, OrderItem orderItem) {
  orderItem.setId(Long.parseLong(id));
  OrderItem updatedOrderItem = orderItemService.update(orderItem);
  return updatedOrderItem != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
 }

 @Override
 public ResponseEntity<Void> orderItemsPost(OrderItem orderItem) {
  OrderItem createdOrderItem = orderItemService.create(orderItem);
  return ResponseEntity.created(URI.create("/api/order-items/" + createdOrderItem.getId())).build();
 }
}
