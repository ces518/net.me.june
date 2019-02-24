package net.me.june.dev.domain;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PostDTO extends BaseDTO{

    @NotNull(message = "제목을 입력해주세요.")
    private String postName;

    @NotNull(message = "내용을 입력해주세요.")
    private String postContent;

    @Builder
    public PostDTO(String postName, String postContent) {
        this.postName = postName;
        this.postContent = postContent;
    }

    public Post toEntity(User user) {
        return Post.builder()
                    .postName(this.postName)
                    .postContent(this.postContent)
                    .user(user).build();
    }
}
