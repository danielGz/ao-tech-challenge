package com.agileengine.ecomm;

import com.agileengine.ecomm.openapi.model.PurchaseOrder;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<PurchaseOrder.StatusEnum, Integer> {

 @Override
 public Integer convertToDatabaseColumn(PurchaseOrder.StatusEnum status) {
  if (status == null) {
   return null;
  }
  switch (status) {
   case PENDING:
    return 0;
   case COMPLETED:
    return 1;
   case CANCELLED:
    return 2;
   default:
    throw new IllegalArgumentException("Unknown status: " + status);
  }
 }

 @Override
 public PurchaseOrder.StatusEnum convertToEntityAttribute(Integer dbData) {
  if (dbData == null) {
   return null;
  }
  switch (dbData) {
   case 0:
    return PurchaseOrder.StatusEnum.PENDING;
   case 1:
    return PurchaseOrder.StatusEnum.COMPLETED;
   case 2:
    return PurchaseOrder.StatusEnum.CANCELLED;
   default:
    throw new IllegalArgumentException("Unknown database value: " + dbData);
  }
 }
}
