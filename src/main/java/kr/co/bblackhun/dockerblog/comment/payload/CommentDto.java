package kr.co.bblackhun.dockerblog.comment.payload;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private long id;
    private String name;
    private String email;
    private String body;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
