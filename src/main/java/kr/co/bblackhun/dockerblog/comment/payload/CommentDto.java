package kr.co.bblackhun.dockerblog.comment.payload;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class CommentDto {

    private long id;

    // name should not be null or empty
    @NotEmpty(message = "name should not be null or empty")
    private String name;

    // email should not be null or empty
    // email field validation
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;

    // comment body should not be null or empty
    // comment body must be minimum 10 characters
    @NotEmpty
    @Size(min=10, message = "comment body must be minimum 10 characters")
    private String body;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
