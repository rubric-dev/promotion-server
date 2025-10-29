package rubric_labs.promotion_server.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import rubric_labs.promotion_server.domain.promotion.Product;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
