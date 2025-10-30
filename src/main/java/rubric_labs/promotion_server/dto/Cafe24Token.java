package rubric_labs.promotion_server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Cafe24Token {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("expires_in")
    private Long expiresIn; // 초 단위 (예: 86400)

    @JsonProperty("refresh_token_expires_in")
    private Long refreshTokenExpiresIn; // 6개월짜리

    @JsonProperty("issued_at")
    private String issuedAt; // ISO 8601 문자열

    @JsonProperty("expires_at")
    private String expiresAt; // ISO 8601 문자열

    @JsonProperty("mall_id")
    private String mallId;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("token_type")
    private String tokenType;
}
