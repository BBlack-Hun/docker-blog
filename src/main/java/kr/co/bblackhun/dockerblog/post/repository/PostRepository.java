package kr.co.bblackhun.dockerblog.post.repository;

import kr.co.bblackhun.dockerblog.post.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
