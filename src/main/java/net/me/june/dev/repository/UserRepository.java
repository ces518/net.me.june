package net.me.june.dev.repository;

import net.me.june.dev.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(String userId) throws DataAccessException;
}
