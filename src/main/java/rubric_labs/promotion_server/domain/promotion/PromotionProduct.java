package rubric_labs.promotion_server.domain.promotion;


import jakarta.persistence.*;
import lombok.*;
import rubric_labs.promotion_server.common.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class PromotionProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long promotionId;
    private Long productId;

    @Builder.Default
    private int targetSales = 0;


}
