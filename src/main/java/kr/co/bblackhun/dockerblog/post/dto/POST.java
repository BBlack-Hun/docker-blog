package kr.co.bblackhun.dockerblog.post.dto;

import ch.qos.logback.classic.db.names.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "posts" ,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class POST {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name="descripion", nullable = false)
    private String description;
    @Column(name = "content", nullable = false )
    private String content;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();
}
