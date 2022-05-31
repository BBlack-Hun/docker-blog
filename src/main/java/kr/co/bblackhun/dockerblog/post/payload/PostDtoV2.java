package kr.co.bblackhun.dockerblog.post.payload;

import kr.co.bblackhun.dockerblog.comment.payload.CommentDto;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class PostDtoV2 {
    private long id;

    // title should not be null or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least characters")
    private String title;

    // post description should be not null or empty
    // post description should at least 10 characters
    @NotEmpty
    @Size(min = 10, message="Post description should have at least 10 characters")
    private String description;

    // post content should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
    private List<String> tags;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();
}
