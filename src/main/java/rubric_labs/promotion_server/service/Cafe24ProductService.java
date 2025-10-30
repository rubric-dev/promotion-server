package rubric_labs.promotion_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rubric_labs.promotion_server.client.Cafe24ProductClient;

@Service
@RequiredArgsConstructor
public class Cafe24ProductService {

    private final Cafe24TokenProvider tokenProvider;
    private final Cafe24ProductClient productClient;

    public void fetchProducts(String code) {
        // ✅ Provider에서 토큰 관리 & 자동 refresh
        String accessToken = tokenProvider.getOrRefreshAccessToken(code);

        // 2️⃣ 상품 목록 조회
        ResponseEntity<String> response = productClient.getProducts(accessToken, 20, 0, "iPhone");

        System.out.println("Products: " + response.getBody());
    }
}