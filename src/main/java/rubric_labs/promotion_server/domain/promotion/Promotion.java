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
public class Promotion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기본 정보
    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 500)
    private String imageUrl;

    @Column(length = 500)
    private String bannerImageUrl;

    @Column(length = 500)
    private String thumbnailUrl;

    // 기간 관리
    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private LocalDateTime displayStartDateTime;

    private LocalDateTime displayEndDateTime;

    // 상태 관리
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private PromotionStatus status = PromotionStatus.DRAFT;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isVisible = false;

    @Column(nullable = false)
    @Builder.Default
    private Integer priority = 0;

//    // 할인/혜택 정보
//    @Enumerated(EnumType.STRING)
//    @Column(length = 20)
//    private DiscountType discountType;

    @Column(precision = 10, scale = 2)
    private BigDecimal discountValue;

    @Column(precision = 10, scale = 2)
    private BigDecimal maxDiscountAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal minPurchaseAmount;

    // 통계 정보
    @Column(nullable = false)
    @Builder.Default
    private Long viewCount = 0L;

    @Column(nullable = false)
    @Builder.Default
    private Long participantCount = 0L;

    @Column(nullable = false)
    @Builder.Default
    private Long clickCount = 0L;

    // 분류/태그
    @Column(length = 100)
    private String category;

    @Column(length = 500)
    private String tags;

    // SEO/링크
    @Column(unique = true, length = 200)
    private String slug;

    @Column(length = 200)
    private String metaTitle;

    @Column(length = 500)
    private String metaDescription;

    // 비즈니스 메서드
    public void incrementViewCount() {
        this.viewCount++;
    }

    public void incrementClickCount() {
        this.clickCount++;
    }

    public void incrementParticipantCount() {
        this.participantCount++;
    }
}
