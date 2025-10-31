package rubric_labs.promotion_server.domain.mall;

import org.springframework.data.jpa.repository.JpaRepository;
import rubric_labs.promotion_server.domain.company.Company;

public interface MallRepository extends JpaRepository<Mall, Long> {
}
