package kr.co.bblackhun.dockerblog.post.service;

import kr.co.bblackhun.dockerblog.post.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
