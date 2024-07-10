// JPA Annotations Processed
package com.agileengine.ecomm.openapi.model;
import jakarta.persistence.*;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * PurchaseOrder
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.7.0")
@Entity
public class PurchaseOrder extends RepresentationModel<PurchaseOrder>  implements Serializable {

  private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    COMPLETED("completed"),
    
    CANCELLED("cancelled");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastUpdated;

  @Valid
  private List<Long> orderItemIds = new ArrayList<>();

  public PurchaseOrder id(Long id) {
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

  public PurchaseOrder status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public PurchaseOrder lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The date and time when the order was last updated.
   * @return lastUpdated
   */
  @Valid 
  @Schema(name = "last_updated", description = "The date and time when the order was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last_updated")
  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public PurchaseOrder orderItemIds(List<Long> orderItemIds) {
    this.orderItemIds = orderItemIds;
    return this;
  }

  public PurchaseOrder addOrderItemIdsItem(Long orderItemIdsItem) {
    if (this.orderItemIds == null) {
      this.orderItemIds = new ArrayList<>();
    }
    this.orderItemIds.add(orderItemIdsItem);
    return this;
  }

  /**
   * IDs of order items associated with this purchase order.
   * @return orderItemIds
   */
  
  @Schema(name = "orderItemIds", description = "IDs of order items associated with this purchase order.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderItemIds")
  public List<Long> getOrderItemIds() {
    return orderItemIds;
  }

  public void setOrderItemIds(List<Long> orderItemIds) {
    this.orderItemIds = orderItemIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseOrder purchaseOrder = (PurchaseOrder) o;
    return Objects.equals(this.id, purchaseOrder.id) &&
        Objects.equals(this.status, purchaseOrder.status) &&
        Objects.equals(this.lastUpdated, purchaseOrder.lastUpdated) &&
        Objects.equals(this.orderItemIds, purchaseOrder.orderItemIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, lastUpdated, orderItemIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseOrder {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    orderItemIds: ").append(toIndentedString(orderItemIds)).append("\n");
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

