package rubric_labs.promotion_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rubric_labs.promotion_server.client.Cafe24AuthClient;
import rubric_labs.promotion_server.domain.mall.Mall;
import rubric_labs.promotion_server.domain.mall.MallRepository;
import rubric_labs.promotion_server.dto.Cafe24Token;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class Cafe24TokenProvider {

    private final Cafe24AuthClient authClient;
    private final MallRepository mallRepository;

    /**
     * 외부에서 code를 받아 accessToken 반환
     * - 최초 요청이면 새 발급
     * - 기존 토큰이 유효하면 재사용
     * - 만료 시 refresh
     */
    public synchronized String getOrRefreshAccessToken(String code, Long mallId) {
        Mall mall = mallRepository.findOneById(mallId);

        // 최초 발급
        if (!mall.hasAccessToken()) {
            Cafe24Token tokenRes = authClient.getAccessTokenObject(mall, code);
            return tokenRes.getAccessToken();
        }

        // 아직 유효하면 그대로 사용
        if (!mall.isTokenExpired()) {
            return mall.getAccessToken();
        }

        // 만료 시 refresh
        Cafe24Token refreshed = authClient.refreshAccessToken(mall);
        return refreshed.getAccessToken();
    }

    private boolean isTokenValid(LocalDateTime expiresAt) {
        return expiresAt != null && expiresAt.isAfter(LocalDateTime.now().plusMinutes(2));
    }
}