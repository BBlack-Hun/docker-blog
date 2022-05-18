package kr.co.bblackhun.dockerblog.post.payload;

import kr.co.bblackhun.dockerblog.comment.payload.CommentDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class PostDto {

    private long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
