package rubric_labs.promotion_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rubric_labs.promotion_server.client.Cafe24AuthClient;
import rubric_labs.promotion_server.client.Cafe24ProductClient;

@Service
@RequiredArgsConstructor
public class Cafe24ProductService {

    private final Cafe24AuthClient authClient;
    private final Cafe24ProductClient productClient;

    public void fetchProducts() {
        // 1️⃣ Access Token 가져오기 (DB나 Redis에 저장된 토큰 or AuthClient 통해 발급)
        String accessToken = authClient.getAccessToken("code").getBody();

        // 2️⃣ 상품 목록 조회
        ResponseEntity<String> response = productClient.getProducts(accessToken, 20, 0, "iPhone");

        System.out.println("Products: " + response.getBody());
    }
}
