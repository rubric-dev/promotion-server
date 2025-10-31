package rubric_labs.promotion_server.api.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rubric_labs.promotion_server.common.dto.response.CommonResponse;
import rubric_labs.promotion_server.response.ProductResponse;
import rubric_labs.promotion_server.service.Cafe24ProductService;
import rubric_labs.promotion_server.service.ProductService;


@RequestMapping("/api/v1/company/{companyCode}/products")
@RequiredArgsConstructor
@RestController
public class ProductApi {
    private final Cafe24ProductService cafe24ProductService;
    private final ProductService productService;

    //todo 신규 가입사면 걔네 이미등록되어잇는 상품도 받아올수 잇어야함.

    @PostMapping("/sync")
    public CommonResponse syncProductInfo(@PathVariable String companyCode,
                                          @RequestParam String code,
                                          @RequestParam Long mallId) {
        cafe24ProductService.fetchProducts(code, mallId);
        return CommonResponse.ok();
    }

    @PostMapping
    public CommonResponse addProduct(@PathVariable String companyCode,
                                     @RequestParam String code,
                                     @RequestParam Long companyId,    // 추가
                                     @RequestParam Long mallId) {
        String productName = cafe24ProductService.createSampleProduct(code, mallId);
        Long productId = productService.saveProduct(companyId, mallId, productName, companyCode);
        return new CommonResponse(productId);
    }

    @GetMapping("/{productId}")
    public CommonResponse<ProductResponse.Detail> getProductDetail(@PathVariable Long productId,
                                                                   @PathVariable String companyCode) {
        return new CommonResponse<>(productService.getProduct(productId));
    }

    @GetMapping
    public CommonResponse<ProductResponse.ListResponse> getList(@RequestParam(required = false) Long companyId,
                                                                @RequestParam(required = false) Long mallId,
                                                                @PathVariable String companyCode) {
        if (companyId != null && mallId != null) {
            return new CommonResponse<>(productService.getProductsByCompanyIdAndMallId(companyId, mallId));
        } else if (companyId != null) {
            return new CommonResponse<>(productService.getProductsByCompanyId(companyId));
        } else if (mallId != null) {
            return new CommonResponse<>(productService.getProductsByMallId(mallId));
        } else {
            throw new IllegalArgumentException("companyId or mallId is required");
        }
    }
}
