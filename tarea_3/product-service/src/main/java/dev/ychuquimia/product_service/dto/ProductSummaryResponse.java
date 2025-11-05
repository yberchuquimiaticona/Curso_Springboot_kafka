package dev.ychuquimia.product_service.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


public record ProductSummaryResponse(
    Long id,
    String name,
    BigDecimal price
) {

}
