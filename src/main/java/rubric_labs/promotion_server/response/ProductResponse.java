package rubric_labs.promotion_server.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rubric_labs.promotion_server.domain.promotion.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail {
        private Long id;
        private Long companyId;
        private Long mallId;
        private String name;
        private String code;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public static Detail from(Product product) {
            return Detail.builder()
                    .id(product.getId())
                    .companyId(product.getCompanyId())
                    .mallId(product.getMallId())
                    .name(product.getName())
                    .code(product.getCode())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
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
        private Long mallId;
        private String name;
        private String code;
        private LocalDateTime createdAt;

        public static Summary from(Product product) {
            return Summary.builder()
                    .id(product.getId())
                    .companyId(product.getCompanyId())
                    .mallId(product.getMallId())
                    .name(product.getName())
                    .code(product.getCode())
                    .createdAt(product.getCreatedAt())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ListResponse {
        private List<Summary> products;
        private int totalCount;

        public static ListResponse from(List<Product> products) {
            return ListResponse.builder()
                    .products(products.stream()
                            .map(Summary::from)
                            .collect(Collectors.toList()))
                    .totalCount(products.size())
                    .build();
        }
    }
}
