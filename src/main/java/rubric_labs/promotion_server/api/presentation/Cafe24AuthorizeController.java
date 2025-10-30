package rubric_labs.promotion_server.api.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class Cafe24AuthorizeController {

    @Value("${app.cafe24.mall-id}")
    private String mallId;

    @Value("${app.cafe24.client-id}")
    private String clientId;

    @Value("${app.cafe24.redirect-uri}")
    private String redirectUri;

    @GetMapping("/api/v1/cafe24/authorize")
    public void redirectToAuthorize(HttpServletResponse response) throws IOException {
        String encodedRedirectUri = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
        String state = "rubric-labs-auth-test";
        String scope = URLEncoder.encode("mall.read_product mall.write_product", StandardCharsets.UTF_8);

        String authorizeUrl = String.format(
                "https://%s.cafe24api.com/api/v2/oauth/authorize?response_type=code&client_id=%s&state=%s&redirect_uri=%s&scope=%s",
                mallId, clientId, state, encodedRedirectUri, scope
        );

        response.sendRedirect(authorizeUrl);
    }
}