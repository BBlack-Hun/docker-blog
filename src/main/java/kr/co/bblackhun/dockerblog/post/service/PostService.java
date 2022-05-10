package kr.co.bblackhun.dockerblog.post.service;

import kr.co.bblackhun.dockerblog.post.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts(int page, int pageSize);

    PostDto getpostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
