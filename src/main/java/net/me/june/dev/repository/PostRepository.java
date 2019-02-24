package net.me.june.dev.repository;

import net.me.june.dev.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findPostByPostName(String postName);

    @Query("select p from Post p where p.user.userName like :searchKeyword")
    List<Post> findPostByWriter(String searchKeyword);
}
