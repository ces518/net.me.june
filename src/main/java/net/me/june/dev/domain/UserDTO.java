package net.me.june.dev.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDTO extends BaseDTO{

    private Logger logger = LoggerFactory.getLogger(UserDTO.class);

    private String userId;

    private String userPassword;

    private String userName;

    private String phone;

    private String email;

    @Builder
    public UserDTO(String userId, String userPassword, String userName, String phone, String email) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
    }

    public User toEntity() {
        return User.builder()
                    .userId(this.userId)
                    .userPassword(this.userPassword)
                    .userName(this.userName)
                    .phone(this.phone)
                    .email(this.email)
                .build();
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        this.userPassword = passwordEncoder.encode(this.userPassword);
        logger.debug("userPassword is encrypt {}",this.userPassword);
    }
}
