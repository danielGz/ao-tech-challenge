/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.7.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.agileengine.ecomm.openapi;

import com.agileengine.ecomm.openapi.model.PurchaseOrder;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.7.0")
@Validated
@Tag(name = "Order", description = "the Order API")
public interface OrderApi {

    /**
     * GET /orders : Get a list of all orders
     *
     * @return A list of orders. (status code 200)
     */
    @Operation(
        operationId = "ordersGet",
        summary = "Get a list of all orders",
        tags = { "Order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of orders.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PurchaseOrder.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/orders",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<PurchaseOrder>> ordersGet(
        
    ) throws Exception;


    /**
     * DELETE /orders/{id} : Delete an order by ID
     *
     * @param id  (required)
     * @return Order deleted. (status code 204)
     */
    @Operation(
        operationId = "ordersIdDelete",
        summary = "Delete an order by ID",
        tags = { "Order" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Order deleted.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/orders/{id}"
    )
    
    ResponseEntity<Void> ordersIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) throws Exception;


    /**
     * GET /orders/{id} : Get an order by ID
     *
     * @param id  (required)
     * @return A single order. (status code 200)
     */
    @Operation(
        operationId = "ordersIdGet",
        summary = "Get an order by ID",
        tags = { "Order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A single order.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PurchaseOrder.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/orders/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<PurchaseOrder> ordersIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) throws Exception;


    /**
     * PUT /orders/{id} : Update an existing order
     *
     * @param id  (required)
     * @param purchaseOrder  (required)
     * @return Order updated. (status code 200)
     */
    @Operation(
        operationId = "ordersIdPut",
        summary = "Update an existing order",
        tags = { "Order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Order updated.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PurchaseOrder.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/orders/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<PurchaseOrder> ordersIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "PurchaseOrder", description = "", required = true) @Valid @RequestBody PurchaseOrder purchaseOrder
    ) throws Exception;


    /**
     * POST /orders : Create a new order
     *
     * @param purchaseOrder  (required)
     * @return Order created. (status code 201)
     */
    @Operation(
        operationId = "ordersPost",
        summary = "Create a new order",
        tags = { "Order" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Order created.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PurchaseOrder.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/orders",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<PurchaseOrder> ordersPost(
        @Parameter(name = "PurchaseOrder", description = "", required = true) @Valid @RequestBody PurchaseOrder purchaseOrder
    ) throws Exception;

}
