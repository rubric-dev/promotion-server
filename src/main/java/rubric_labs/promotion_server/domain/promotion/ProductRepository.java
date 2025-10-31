package rubric_labs.promotion_server.domain.promotion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCompanyId(Long companyId);

    List<Product> findByMallId(Long mallId);

    List<Product> findByCompanyIdAndMallId(Long companyId, Long mallId);
}
