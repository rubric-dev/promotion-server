package rubric_labs.promotion_server.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cafe24CreateProductRequest {

    @JsonProperty("product_name")
    private String productName;          // Required

    @JsonProperty("supply_price")
    private Integer supplyPrice;         // Required

    @JsonProperty("price")
    private Integer price;               // Optional

    @JsonProperty("display")
    private String display;              // "T" or "F"

    @JsonProperty("selling")
    private String selling;              // "T" or "F"

    @JsonProperty("product_condition")
    private String productCondition;     // Default "N"

    @JsonProperty("custom_product_code")
    private String customProductCode;    // Optional

    @JsonProperty("description")
    private String description;          // Optional

    @JsonProperty("summary_description")
    private String summaryDescription;   // Optional

    @JsonProperty("product_tag")
    private String productTag;           // Optional

    @JsonProperty("brand_code")
    private String brandCode;            // Default "B0000000"

    @JsonProperty("supplier_code")
    private String supplierCode;         // Default "S0000000"

    @JsonProperty("shipping_scope")
    private String shippingScope;        // "A", "B", "C"

    @JsonProperty("tax_type")
    private String taxType;              // "A", "B", "C"

    @JsonProperty("tax_rate")
    private Double taxRate;              // Optional
}
