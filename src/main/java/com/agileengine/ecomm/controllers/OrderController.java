package com.agileengine.ecomm.controllers;

import com.agileengine.ecomm.openapi.OrderApi;
import com.agileengine.ecomm.service.OrderService;
import com.agileengine.ecomm.openapi.model.PurchaseOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController implements OrderApi {


 private OrderService orderService;

 public OrderController(OrderService orderService) {
  this.orderService = orderService;
 }

 @Override
 public ResponseEntity<List<PurchaseOrder>> ordersGet() {
  List<PurchaseOrder> orders = orderService.findAll();
  return ResponseEntity.ok(orders);
 }

 @Override
 public ResponseEntity<Void> ordersIdDelete(String id) {
  orderService.delete(Long.parseLong(id));
  return ResponseEntity.noContent().build();
 }

 @Override
 public ResponseEntity<PurchaseOrder> ordersIdGet(String id) {
  PurchaseOrder order = orderService.findById(Long.parseLong(id));
  return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
 }

 @Override
 public ResponseEntity<Void> ordersIdPut(String id, PurchaseOrder purchaseOrder) {
  purchaseOrder.setId(Long.parseLong(id));
  PurchaseOrder updatedOrder = orderService.update(purchaseOrder);
  return updatedOrder != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
 }

 @Override
 public ResponseEntity<Void> ordersPost(PurchaseOrder purchaseOrder) {
  PurchaseOrder createdOrder = orderService.create(purchaseOrder);
  return ResponseEntity.created(URI.create("/api/orders/" + createdOrder.getId())).build();
 }
}