package kr.co.bblackhun.dockerblog.comment.service;


import kr.co.bblackhun.dockerblog.comment.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
}
