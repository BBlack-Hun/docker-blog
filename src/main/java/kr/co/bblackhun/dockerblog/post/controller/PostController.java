package kr.co.bblackhun.dockerblog.post.controller;

import kr.co.bblackhun.dockerblog.post.payload.PostDto;
import kr.co.bblackhun.dockerblog.post.payload.PostResponse;
import kr.co.bblackhun.dockerblog.post.service.PostService;
import kr.co.bblackhun.dockerblog.system.utils.AppConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    // create blog post res api
    @PostMapping(value = "/")
    public ResponseEntity<PostDto> createPost(@Valid  @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "page", defaultValue = AppConstant.DEFAULT_PAGE_NUMBER, required = false) int page,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sort", defaultValue = AppConstant.DEFAULT_SORT_BY, required = false) String sort,
            @RequestParam(value = "sortDir", defaultValue = AppConstant.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPosts(page, pageSize, sort, sortDir);
    }

    // get post by id (use version header -> use produces(application/vnd.javaguides.v1+json))
    @GetMapping(value = "/{id}", produces = "application/vnd.javaguides.v1+json")
    public ResponseEntity<PostDto> getPostByIdV1(@PathVariable(name= "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    // update post by id
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);

        return  ResponseEntity.ok(postResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePOst(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
