package rubric_labs.promotion_server.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.StringUtils;
import rubric_labs.promotion_server.common.BaseEntity;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAuth auth;

    private Long companyId;
    private String name;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    public boolean isSystemAdmin(){
        return auth.isSystemAdmin();
    }

    public boolean isNormalUser(){
        return !isSystemAdmin();
    }

    public void setName(String name) {
        if (StringUtils.hasText(name)) this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
