package kr.co.bblackhun.dockerblog.post.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private long id;
    private String title;
    private String description;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
