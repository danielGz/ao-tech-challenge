// JPA Annotations Processed
package com.agileengine.ecomm.openapi.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.net.URI;
import java.util.Objects;
import com.agileengine.ecomm.openapi.model.Product;
import com.agileengine.ecomm.openapi.model.PurchaseOrder;
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

  @ManyToOne
  private PurchaseOrder purchaseOrder;

  @ManyToOne
  private Product product;

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

  public OrderItem purchaseOrder(PurchaseOrder purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
    return this;
  }

  /**
   * Get purchaseOrder
   * @return purchaseOrder
   */
  @Valid 
  @Schema(name = "purchaseOrder", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("purchaseOrder")
  public PurchaseOrder getPurchaseOrder() {
    return purchaseOrder;
  }

  public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  public OrderItem product(Product product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
   */
  @Valid 
  @Schema(name = "product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("product")
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
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
        Objects.equals(this.purchaseOrder, orderItem.purchaseOrder) &&
        Objects.equals(this.product, orderItem.product) &&
        Objects.equals(this.quantity, orderItem.quantity) &&
        Objects.equals(this.price, orderItem.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, purchaseOrder, product, quantity, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    purchaseOrder: ").append(toIndentedString(purchaseOrder)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

