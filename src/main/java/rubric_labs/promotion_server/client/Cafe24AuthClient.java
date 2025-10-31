package rubric_labs.promotion_server.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import rubric_labs.promotion_server.domain.mall.Mall;
import rubric_labs.promotion_server.dto.Cafe24Token;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Component
@RequiredArgsConstructor
public class Cafe24AuthClient {

    private final RestTemplate restTemplate;

    @Value("${app.cafe24.redirect-uri}")
    private String redirectUri;

    private static final String TOKEN_URL_TEMPLATE = "https://%s.cafe24api.com/api/v2/oauth/token";

    /**
     * Authorization Code를 사용하여 Access Token 발급 (Mall 정보 사용)
     */
    public Cafe24Token getAccessTokenObject(Mall mall, String code) {
        String url = String.format(TOKEN_URL_TEMPLATE, mall.getMallId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = mall.getClientId() + ":" + mall.getClientSecret();
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("code", code);
        params.add("redirect_uri", redirectUri);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Cafe24Token> result = restTemplate.exchange(url, HttpMethod.POST, request, Cafe24Token.class);

        return result.getBody();
    }

    /**
     * Refresh Token을 사용하여 Access Token 갱신 (Mall 정보 사용)
     */
    public Cafe24Token refreshAccessToken(Mall mall) {
        String url = String.format(TOKEN_URL_TEMPLATE, mall.getMallId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = mall.getClientId() + ":" + mall.getClientSecret();
        String encodedAuth = Base64.getEncoder()
                .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("refresh_token", mall.getRefreshToken());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Cafe24Token> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                Cafe24Token.class
        );

        return response.getBody();
    }

    /**
     * Access / Refresh Token 폐기 (Revoke)
     */
    public ResponseEntity<String> revokeToken(Mall mall, String token, String tokenHint) {
        String url = String.format("https://%s.cafe24api.com/api/v2/oauth/revoke", mall.getMallId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = mall.getClientId() + ":" + mall.getClientSecret();
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