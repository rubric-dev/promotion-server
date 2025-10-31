package rubric_labs.promotion_server.domain.mall;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import rubric_labs.promotion_server.common.BaseEntity;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Mall extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    private String name;
    private String mallId;
    private String clientId;
    private String clientSecret;

    //cafe 24 accessToken
    private String accessToken;
    //cafe 24 refreshToken
    private String refreshToken;
    //cafe 24 accessToken 만료시간
    private LocalDateTime tokenExpiresAt;

    public static Mall of(Long companyId, String name, String mallId,
                          String clientId, String clientSecret) {
        return Mall.builder()
                .companyId(companyId)
                .name(name)
                .mallId(mallId)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }

    public void update(String name, String mallId, String clientId, String clientSecret) {
        if (name != null) {
            this.name = name;
        }
        if (mallId != null) {
            this.mallId = mallId;
        }
        if (clientId != null) {
            this.clientId = clientId;
        }
        if (clientSecret != null) {
            this.clientSecret = clientSecret;
        }
    }

    public void updateTokens(String accessToken, String refreshToken, LocalDateTime expiresAt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenExpiresAt = expiresAt;
    }

    public boolean isTokenExpired() {
        if (tokenExpiresAt == null) {
            return true;
        }
        // 2분 버퍼를 두고 만료 체크
        return tokenExpiresAt.isBefore(LocalDateTime.now().plusMinutes(2));
    }

    public boolean hasRefreshToken() {
        return refreshToken != null && !refreshToken.isEmpty();
    }

    public boolean hasAccessToken() {
        return accessToken != null && !accessToken.isEmpty();
    }
}
