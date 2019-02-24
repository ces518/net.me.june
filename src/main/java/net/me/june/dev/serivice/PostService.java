package net.me.june.dev.serivice;

import lombok.AllArgsConstructor;
import net.me.june.dev.domain.Post;
import net.me.june.dev.domain.PostDTO;
import net.me.june.dev.domain.User;
import net.me.june.dev.repository.PostRepository;
import net.me.june.dev.security.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private Logger logger = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> findBoards(PostDTO postDTO) {

        String searchCondition = postDTO.getSearchCondition();

        logger.debug("searchCondition = {}",searchCondition);

        if(StringUtils.isEmpty(searchCondition)) {
            return postRepository.findAll();
        }

        switch (searchCondition) {
            case "1" :
                return postRepository.findPostByPostName(postDTO.getSearchKeyword());
            case "2" :
                return postRepository.findPostByWriter(postDTO.getSearchKeyword());
        }
        return new ArrayList<>();
    }

    @Transactional
    public void createPost(PostDTO postDTO, LoginVO loginVO) {
        User user = userService.findUserById(loginVO.getUserId());
        Post post = postDTO.toEntity(user);
        postRepository.save(post);
    }
}
