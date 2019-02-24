package net.me.june.dev.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString
public class User extends BaseEntity{

    @Column(name = "user_id", nullable =  false, length = 200)
    private String userId;

    @Column(name = "user_password", nullable =  false, length = 200)
    private String userPassword;

    @Column(name = "user_name", nullable = false, length = 200)
    private String userName;

    private String email;

    private String phone;

    @Builder
    public User(String userId, String userPassword, String userName, String email, String phone) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }
}
