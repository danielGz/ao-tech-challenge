// JPA Annotations Processed
package com.agileengine.ecomm.openapi.model;
import jakarta.persistence.*;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * OrderItem
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.7.0")
@Entity
public class OrderItem extends RepresentationModel<OrderItem>  implements Serializable {

  private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private String purchaseOrderId;

  private String productId;

  private Integer quantity;

  private Float price;

  public OrderItem id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderItem purchaseOrderId(String purchaseOrderId) {
    this.purchaseOrderId = purchaseOrderId;
    return this;
  }

  /**
   * Get purchaseOrderId
   * @return purchaseOrderId
   */
  
  @Schema(name = "purchaseOrderId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("purchaseOrderId")
  public String getPurchaseOrderId() {
    return purchaseOrderId;
  }

  public void setPurchaseOrderId(String purchaseOrderId) {
    this.purchaseOrderId = purchaseOrderId;
  }

  public OrderItem productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
   */
  
  @Schema(name = "productId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productId")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public OrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItem price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   */
  
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.id, orderItem.id) &&
        Objects.equals(this.purchaseOrderId, orderItem.purchaseOrderId) &&
        Objects.equals(this.productId, orderItem.productId) &&
        Objects.equals(this.quantity, orderItem.quantity) &&
        Objects.equals(this.price, orderItem.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, purchaseOrderId, productId, quantity, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    purchaseOrderId: ").append(toIndentedString(purchaseOrderId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

