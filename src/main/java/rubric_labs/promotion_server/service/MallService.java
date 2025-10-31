package rubric_labs.promotion_server.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rubric_labs.promotion_server.api.request.MallRequest;
import rubric_labs.promotion_server.domain.mall.Mall;
import rubric_labs.promotion_server.domain.mall.MallRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MallService {
    private final MallRepository mallRepository;

    @Transactional
    public Long createMall(MallRequest.Create request) {
        Mall mall = Mall.builder()
                .companyId(request.getCompanyId())
                .name(request.getName())
                .mallId(request.getMallId())
                .clientId(request.getClientId())
                .clientSecret(request.getClientSecret())
                .apiKey(request.getApiKey())
                .build();

        Mall savedMall = mallRepository.save(mall);
        return savedMall.getId();
    }

    @Transactional
    public Long updateMall(Long mallId, MallRequest.Update request) {
        Mall mall = mallRepository.findById(mallId)
                .orElseThrow(() -> new IllegalArgumentException("Mall not found with id: " + mallId));

        // Mall 엔티티에 update 메서드가 필요합니다
        mall.update(
                request.getName(),
                request.getMallId(),
                request.getClientId(),
                request.getClientSecret(),
                request.getApiKey()
        );

        return mall.getId();
    }

    public Mall getMall(Long mallId) {
        return mallRepository.findById(mallId)
                .orElseThrow(() -> new IllegalArgumentException("Mall not found with id: " + mallId));
    }
}
