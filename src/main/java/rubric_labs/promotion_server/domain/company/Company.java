package rubric_labs.promotion_server.domain.company;

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
public class Company extends BaseEntity {
    //일단 루브릭 랩스가 슈퍼 어드민이고 다른 회사들 추가해준다고 가정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String apiKey;
}
