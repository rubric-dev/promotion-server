package rubric_labs.promotion_server.config;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectTimeout(5_000);  // 연결 타임아웃 (ms)
        factory.setReadTimeout(5_000);     // 응답 대기 타임아웃 (ms)
        factory.setConnectionRequestTimeout(2_000); // 커넥션 풀에서 커넥션 가져올 때 타임아웃 (ms)

        // 4️⃣ RestTemplate 생성
        return new RestTemplate(factory);
    }
}
