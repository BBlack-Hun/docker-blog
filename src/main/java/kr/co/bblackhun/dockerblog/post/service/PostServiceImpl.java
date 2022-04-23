package kr.co.bblackhun.dockerblog.post.service;

import kr.co.bblackhun.dockerblog.post.entity.Post;
import kr.co.bblackhun.dockerblog.post.payload.PostDto;
import kr.co.bblackhun.dockerblog.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        // convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());
        return postResponse;
    }
}
