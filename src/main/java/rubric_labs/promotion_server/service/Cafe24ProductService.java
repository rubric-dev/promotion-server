package rubric_labs.promotion_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rubric_labs.promotion_server.api.request.Cafe24CreateProductRequest;
import rubric_labs.promotion_server.client.Cafe24ProductClient;

@Service
@RequiredArgsConstructor
public class Cafe24ProductService {
    private final Cafe24TokenProvider tokenProvider;
    private final Cafe24ProductClient productClient;

    public void fetchProducts(String code, Long mallId) {
        // ✅ Provider에서 토큰 관리 & 자동 refresh
        String accessToken = tokenProvider.getOrRefreshAccessToken(code, mallId);

        // 2️⃣ 상품 목록 조회
        ResponseEntity<String> response = productClient.getProducts(accessToken, 20, 0, "iPhone");

        System.out.println("Products: " + response.getBody());
    }

    public String createSampleProduct(String code, Long mallId) {
        // 1️⃣ 유효 access token 확보
        String accessToken = tokenProvider.getOrRefreshAccessToken(code, mallId);

        // 2️⃣ 상품 등록 요청 DTO
        Cafe24CreateProductRequest request = Cafe24CreateProductRequest.builder()
                .productName("Cafe24 YouTube Hoodie")
                .supplyPrice(30000)
                .price(59000)
                .display("T")
                .selling("T")
                .productCondition("N")
                .description("Official Cafe24 YouTube Edition Hoodie!")
                .summaryDescription("Limited edition hoodie for fans.")
                .shippingScope("A") // 국내배송
                .taxType("A")       // 과세상품
                .build();

        // 3️⃣ API 호출
        ResponseEntity<String> response = productClient.createProduct(accessToken, request);
        System.out.println("상품 등록 결과: " + response.getBody());

        // 4️⃣ 상품명 반환
        return request.getProductName();
    }
}