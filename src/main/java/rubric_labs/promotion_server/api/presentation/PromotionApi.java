package rubric_labs.promotion_server.api.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rubric_labs.promotion_server.api.request.PromotionRequest;
import rubric_labs.promotion_server.common.dto.response.CommonResponse;
import rubric_labs.promotion_server.service.PromotionService;

@RequestMapping("/api/v1/company/{companyCode}/promotion")
@RequiredArgsConstructor
@RestController
public class PromotionApi {

    private final PromotionService promotionService;

    @PostMapping
    public CommonResponse createPromotion(
            @PathVariable String companyCode,
            @RequestBody PromotionRequest.Create request
    ) {
        promotionService.createPromotion(companyCode, request);
        return CommonResponse.ok();
    }

    @PatchMapping("/{promotionId}")
    public CommonResponse updatePromotion(
            @PathVariable String companyCode,
            @PathVariable Long promotionId,
            @RequestBody PromotionRequest.Update request
    ) {
        promotionService.updatePromotion(promotionId, request);
        return CommonResponse.ok();
    }
}