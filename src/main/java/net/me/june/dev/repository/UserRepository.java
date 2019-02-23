package net.me.june.dev.repository;

import net.me.june.dev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserId(String userId);
}
