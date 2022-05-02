package kr.co.bblackhun.dockerblog.post.service;

import kr.co.bblackhun.dockerblog.post.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getpostById(long id);
}
