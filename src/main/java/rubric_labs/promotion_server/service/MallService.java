package rubric_labs.promotion_server.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rubric_labs.promotion_server.api.request.MallRequest;
import rubric_labs.promotion_server.domain.mall.Mall;
import rubric_labs.promotion_server.domain.mall.MallRepository;
import rubric_labs.promotion_server.response.MallResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MallService {
    private final MallRepository mallRepository;

    @Transactional
    public Long createMall(MallRequest.Create request) {
        Mall mall = Mall.of(
                request.getCompanyId(),
                request.getName(),
                request.getMallId(),
                request.getClientId(),
                request.getClientSecret()
        );

        Mall savedMall = mallRepository.save(mall);
        return savedMall.getId();
    }

    @Transactional
    public Long updateMall(Long mallId, MallRequest.Update request) {
        Mall mall = mallRepository.findOneById(mallId);

        // Mall 엔티티에 update 메서드가 필요합니다
        mall.update(
                request.getName(),
                request.getMallId(),
                request.getClientId(),
                request.getClientSecret()
        );

        return mall.getId();
    }

    public MallResponse.Detail getMall(Long mallId) {
        Mall mall = mallRepository.findOneById(mallId);
        return MallResponse.Detail.from(mall);
    }
}
