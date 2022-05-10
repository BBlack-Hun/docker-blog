package kr.co.bblackhun.dockerblog.post.service;

import kr.co.bblackhun.dockerblog.post.payload.PostDto;
import kr.co.bblackhun.dockerblog.post.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int page, int pageSize, String sort, String sortDir);

    PostDto getpostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
