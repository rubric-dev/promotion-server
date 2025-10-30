package rubric_labs.promotion_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rubric_labs.promotion_server.client.Cafe24AuthClient;
import rubric_labs.promotion_server.dto.Cafe24Token;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class Cafe24TokenProvider {

    private final Cafe24AuthClient authClient;
    private Cafe24Token currentToken; // 간단히 메모리 보관

    /**
     * 외부에서 code를 받아 accessToken 반환
     * - 최초 요청이면 새 발급
     * - 기존 토큰이 유효하면 재사용
     * - 만료 시 refresh
     */
    public synchronized String getOrRefreshAccessToken(String code) {
        // 최초 발급
        if (currentToken == null) {
            currentToken = authClient.getAccessTokenObject(code);
            return currentToken.getAccessToken();
        }

        // 아직 유효하면 그대로 사용
        LocalDateTime expiresAt = LocalDateTime.parse(currentToken.getExpiresAt());
        if (isTokenValid(expiresAt)) {
            return currentToken.getAccessToken();
        }

        // 만료 시 refresh
        Cafe24Token refreshed = authClient.refreshAccessToken(currentToken.getRefreshToken());
        currentToken = refreshed;
        return refreshed.getAccessToken();
    }

    private boolean isTokenValid(LocalDateTime expiresAt) {
        return expiresAt != null && expiresAt.isAfter(LocalDateTime.now().plusMinutes(2));
    }
}