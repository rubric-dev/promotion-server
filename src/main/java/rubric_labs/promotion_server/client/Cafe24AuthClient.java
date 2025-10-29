package rubric_labs.promotion_server.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class Cafe24AuthClient {

    private final RestTemplate restTemplate;

    @Value("${cafe24.mall-id}")
    private String mallId;

    @Value("${cafe24.client-id}")
    private String clientId;

    @Value("${cafe24.client-secret}")
    private String clientSecret;

    @Value("${cafe24.redirect-uri}")
    private String redirectUri;

    private static final String TOKEN_URL_TEMPLATE = "https://%s.cafe24api.com/api/v2/oauth/token";

    /**
     * Authorization Code를 사용하여 Access Token 발급
     */
    public ResponseEntity<String> getAccessToken(String code) {
        String url = String.format(TOKEN_URL_TEMPLATE, mallId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder()
                .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("code", code);
        params.add("redirect_uri", redirectUri);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }

    /**
     * Refresh Token을 사용하여 Access Token 갱신
     */
    public ResponseEntity<String> refreshAccessToken(String refreshToken) {
        String url = String.format(TOKEN_URL_TEMPLATE, mallId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder()
                .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("refresh_token", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }

    /**
     * Access / Refresh Token 폐기 (Revoke)
     */
    public ResponseEntity<String> revokeToken(String token, String tokenHint) {
        String url = String.format("https://%s.cafe24api.com/api/v2/oauth/revoke", mallId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder()
                .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("token", token);
        params.add("token_hint", tokenHint);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }
}