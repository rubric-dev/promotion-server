package rubric_labs.promotion_server.api.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rubric_labs.promotion_server.common.dto.response.CommonResponse;
import rubric_labs.promotion_server.service.Cafe24ProductService;


@RequestMapping("/api/v1/company/{companyCode}/products")
@RequiredArgsConstructor
@RestController
public class ProductApi {
    private final Cafe24ProductService cafe24ProductService;

    //todo 신규 가입사면 걔네 이미등록되어잇는 상품도 받아올수 잇어야함.

    @PostMapping
    public CommonResponse syncProductInfo(@PathVariable String companyCode){
        cafe24ProductService.fetchProducts();
        return null;
    }

    @GetMapping
    public CommonResponse getList(@RequestParam String name){
        return null;
    }
}
