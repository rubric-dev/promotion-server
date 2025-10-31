package rubric_labs.promotion_server.domain.promotion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import rubric_labs.promotion_server.common.BaseEntity;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;
    private Long mallId;
    private String name;
    private String code;

    public static Product of(Long companyId, Long mallId, String name, String code) {
        return Product.builder()
                .companyId(companyId)
                .mallId(mallId)
                .name(name)
                .code(code)
                .build();
    }
}
