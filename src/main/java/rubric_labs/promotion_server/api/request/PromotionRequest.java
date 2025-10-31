package rubric_labs.promotion_server.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PromotionRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Create {
        // 기본 정보
        private String name;                 // 프로모션 이름
        private String description;          // 설명
        private String imageUrl;             // 대표 이미지
        private String bannerImageUrl;       // 배너 이미지
        private String thumbnailUrl;         // 썸네일 이미지

        // 기간
        private LocalDate startDate;         // 시작일
        private LocalDate endDate;           // 종료일
        private LocalDateTime displayStartDateTime; // 노출 시작
        private LocalDateTime displayEndDateTime;   // 노출 종료

        // 상태
        private Boolean isVisible;           // 노출 여부
        private Integer priority;            // 우선순위

        // SEO / 링크
        private String slug;                 // 고유 slug
        private String metaTitle;            // SEO 타이틀
        private String metaDescription;      // SEO 설명
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Update {
        private String name;
        private String description;
        private String imageUrl;
        private String bannerImageUrl;
        private String thumbnailUrl;

        private LocalDate startDate;
        private LocalDate endDate;
        private LocalDateTime displayStartDateTime;
        private LocalDateTime displayEndDateTime;

        private Boolean isVisible;
        private Integer priority;

        private String slug;
        private String metaTitle;
        private String metaDescription;
    }
}