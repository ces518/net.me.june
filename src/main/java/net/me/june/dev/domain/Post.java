package net.me.june.dev.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post extends BaseEntity{

    @Column(name = "post_name", nullable = false ,length = 500)
    private String postName;

    @Column(name = "post_content", nullable = false ,length = 4000)
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;

    @Builder
    public Post(String postName, String postContent, User user) {
        this.postName = postName;
        this.postContent = postContent;
        this.user = user;
    }
}
