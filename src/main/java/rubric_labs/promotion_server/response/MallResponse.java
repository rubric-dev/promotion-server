package rubric_labs.promotion_server.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rubric_labs.promotion_server.domain.mall.Mall;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MallResponse {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail {
        private Long id;
        private Long companyId;
        private String name;
        private String mallId;
        private String clientId;
        private String clientSecret;
        private String apiKey;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public static Detail from(Mall mall) {
            return Detail.builder()
                    .id(mall.getId())
                    .companyId(mall.getCompanyId())
                    .name(mall.getName())
                    .mallId(mall.getMallId())
                    .clientId(mall.getClientId())
                    .clientSecret(mall.getClientSecret())
                    .createdAt(mall.getCreatedAt())
                    .updatedAt(mall.getUpdatedAt())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Summary {
        private Long id;
        private Long companyId;
        private String name;
        private String mallId;
        private LocalDateTime createdAt;

        public static Summary from(Mall mall) {
            return Summary.builder()
                    .id(mall.getId())
                    .companyId(mall.getCompanyId())
                    .name(mall.getName())
                    .mallId(mall.getMallId())
                    .createdAt(mall.getCreatedAt())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ListResponse {
        private List<Summary> malls;
        private int totalCount;

        public static ListResponse from(List<Mall> malls) {
            return ListResponse.builder()
                    .malls(malls.stream()
                            .map(Summary::from)
                            .collect(Collectors.toList()))
                    .totalCount(malls.size())
                    .build();
        }
    }
}
