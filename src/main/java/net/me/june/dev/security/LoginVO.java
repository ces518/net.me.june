package net.me.june.dev.security;

import lombok.Getter;
import net.me.june.dev.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class LoginVO extends org.springframework.security.core.userdetails.User{

    private String userId;

    public LoginVO(String userId,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
    }
}
