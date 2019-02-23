package net.me.june.dev.serivice;

import net.me.june.dev.domain.User;
import net.me.june.dev.domain.UserDTO;
import net.me.june.dev.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User finedUser = userRepository.findByUserId(userId);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        });
        return new org.springframework.security.core.userdetails.User(finedUser.getUserName(),finedUser.getUserPassword(),authorities);
    }

    public User createUser(UserDTO userDTO) {
        userDTO.encryptPassword(passwordEncoder);
        User user = userDTO.toEntity();
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
