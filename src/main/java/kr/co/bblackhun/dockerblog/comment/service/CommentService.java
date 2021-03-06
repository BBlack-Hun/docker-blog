package kr.co.bblackhun.dockerblog.comment.service;


import kr.co.bblackhun.dockerblog.comment.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, long commentId);

    CommentDto updateComment(Long postId, long commentId,  CommentDto commentRequest);

    void deleteComment(Long postId, long commentId);
}
