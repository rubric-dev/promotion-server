package rubric_labs.promotion_server.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MallRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Create {
        private Long companyId;
        private String name;
        private String mallId;
        private String clientId;
        private String clientSecret;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Update {
        private String name;
        private String mallId;
        private String clientId;
        private String clientSecret;
    }
}
