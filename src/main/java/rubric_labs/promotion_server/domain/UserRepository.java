package rubric_labs.promotion_server.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import rubric_labs.promotion_server.domain.company.Company;

public interface UserRepository extends JpaRepository<User, Long> {
}
