package rubric_labs.promotion_server.domain.mall;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import rubric_labs.promotion_server.domain.company.Company;
import rubric_labs.promotion_server.exception.NotFoundException;

import java.util.List;

public interface MallRepository extends JpaRepository<Mall, Long> {
    @Nonnull
    default Mall findOneById(@Nonnull Long id) {
        return this.findById(id).orElseThrow(() -> new NotFoundException("mall not found. id : " + id));
    }

    List<Mall> findByCompanyId(Long companyId);
}
