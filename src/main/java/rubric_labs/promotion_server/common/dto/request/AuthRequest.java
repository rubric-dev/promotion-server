package rubric_labs.promotion_server.common.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

public class AuthRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Login {

        @NotNull
        private String username;

        @NotNull
        private String password;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Refresh {

        @NotBlank
        private String refreshToken;

        public String getRefreshToken() {
            return refreshToken.trim();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Create {
        @NotBlank(message = "이름이 없습니다.")
        private String name;

        @NotBlank(message = "사용자명이 없습니다.")
        private String username;

        @Email
        @NotBlank(message = "이메일이 없습니다.")
        private String email;

        @NotEmpty(message = "브랜드가 없습니다.")
        private List<String> brandLineCodes;

        public String getEmail() {
            return email.trim().toLowerCase();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class updateRole {
        @NotNull
        private Long userId;

//        @NotNull
//        private RoleType role;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class PasswordEmailSend {

        @NotNull
        private String username;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class UpdatePassword {

        @NotBlank
        private String token;

        @NotNull
        private String password;

        public String getToken() {
            return token.trim();
        }
    }
}
