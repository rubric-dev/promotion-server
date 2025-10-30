package rubric_labs.promotion_server.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rubric_labs.promotion_server.api.request.Cafe24CreateProductRequest;
import rubric_labs.promotion_server.dto.Cafe24RequestWrapper;

@Component
@RequiredArgsConstructor
public class Cafe24ProductClient {

    private final RestTemplate restTemplate;

    @Value("${app.cafe24.mall-id}")
    private String mallId;

    @Value("${app.cafe24.api-version:2025-09-01}")
    private String apiVersion;

    private static final String BASE_URL_TEMPLATE = "https://%s.cafe24api.com/api/v2/admin/products";

    /**
     * 상품 목록 조회
     */
    public ResponseEntity<String> getProducts(String accessToken,
                                              Integer limit,
                                              Integer offset,
                                              String productName) {
        String baseUrl = String.format(BASE_URL_TEMPLATE, mallId);

        // 쿼리 파라미터 구성
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("limit", limit != null ? limit : 10)
                .queryParam("offset", offset != null ? offset : 0);

        if (productName != null && !productName.isEmpty()) {
            builder.queryParam("product_name", productName);
        }

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Content-Type", "application/json");
        headers.set("X-Cafe24-Api-Version", apiVersion);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class
        );
    }

    /**
     * 상품 등록
     */
    public ResponseEntity<String> createProduct(String accessToken, Cafe24CreateProductRequest requestDto) {
        String url = String.format(BASE_URL_TEMPLATE, mallId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("X-Cafe24-Api-Version", apiVersion);

        Cafe24RequestWrapper<Cafe24CreateProductRequest> wrapper = new Cafe24RequestWrapper<>(requestDto);

        HttpEntity<Cafe24RequestWrapper<Cafe24CreateProductRequest>> entity =
                new HttpEntity<>(wrapper, headers);

        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}