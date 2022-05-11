package kr.co.bblackhun.dockerblog.comment.repository;

import kr.co.bblackhun.dockerblog.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
