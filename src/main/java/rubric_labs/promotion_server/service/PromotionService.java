package rubric_labs.promotion_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rubric_labs.promotion_server.api.request.PromotionRequest;
import rubric_labs.promotion_server.domain.promotion.Promotion;
import rubric_labs.promotion_server.domain.promotion.PromotionRepository;
import rubric_labs.promotion_server.domain.promotion.PromotionStatus;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;

    @Transactional
    public void createPromotion(String companyCode, PromotionRequest.Create request) {
        Promotion promotion = Promotion.of(request);
        promotionRepository.save(promotion);
    }

    @Transactional
    public void updatePromotion(Long promotionId, PromotionRequest.Update request) {
        Promotion promotion = promotionRepository.findById(promotionId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 프로모션입니다."));
        promotion.update(request);
    }
}