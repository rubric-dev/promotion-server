package rubric_labs.promotion_server.api.presentation;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rubric_labs.promotion_server.api.request.MallRequest;
import rubric_labs.promotion_server.common.dto.response.CommonResponse;
import rubric_labs.promotion_server.domain.mall.Mall;
import rubric_labs.promotion_server.service.MallService;

@RequestMapping("/api/v1/malls")
@RequiredArgsConstructor
@RestController
public class MallApi {

    private final MallService mallService;

    @PostMapping
    public CommonResponse<Long> createMall(@RequestBody MallRequest.Create request) {
        return new CommonResponse<>(mallService.createMall(request));
    }

    @PutMapping("/{mallId}")
    public CommonResponse<Long> updateMall(@PathVariable Long mallId,
                                           @RequestBody MallRequest.Update request) {
        return new CommonResponse<>(mallService.updateMall(mallId, request));
    }

    @GetMapping("/{mallId}")
    public CommonResponse<Mall> getMall(@PathVariable Long mallId) {
        Mall mall = mallService.getMall(mallId);
        return null;
    }
}
