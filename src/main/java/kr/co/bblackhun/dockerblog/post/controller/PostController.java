package kr.co.bblackhun.dockerblog.post.controller;

import kr.co.bblackhun.dockerblog.post.payload.PostDto;
import kr.co.bblackhun.dockerblog.post.payload.PostResponse;
import kr.co.bblackhun.dockerblog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return postService.getAllPosts(page, pageSize);
    }

    // get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostbyId(@PathVariable(name= "id") long id) {
        return ResponseEntity.ok(postService.getpostById(id));
    }

    // update post by id
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);

        return  ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePOst(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
