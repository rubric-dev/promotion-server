package rubric_labs.promotion_server.domain.mall;

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
public class Mall extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    private String name;
    private String mallId;
    private String clientId;
    private String clientSecret;

    public static Mall of(Long companyId, String name, String mallId,
                          String clientId, String clientSecret) {
        return Mall.builder()
                .companyId(companyId)
                .name(name)
                .mallId(mallId)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }

    public void update(String name, String mallId, String clientId, String clientSecret) {
        if (name != null) {
            this.name = name;
        }
        if (mallId != null) {
            this.mallId = mallId;
        }
        if (clientId != null) {
            this.clientId = clientId;
        }
        if (clientSecret != null) {
            this.clientSecret = clientSecret;
        }
    }
}
