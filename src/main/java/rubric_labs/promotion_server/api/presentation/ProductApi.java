package rubric_labs.promotion_server.api.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import rubric_labs.promotion_server.common.dto.response.CommonResponse;


@RequiredArgsConstructor
@RestController
public class ProductApi {

    @PostMapping
    public CommonResponse syncProductInfo(){
        return null;
    }
}
