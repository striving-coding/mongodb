package com.wss.mongodb.service;

import com.wss.mongodb.pojo.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 王森森
 * @create 2020/12/12 19:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentserviceTest {
    @Autowired
    private CommentService commentService;

    @Test
    public   void testFindCommentList(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public   void testfindCommentById(){
        Comment comment = commentService.findCommentById("2");
        System.out.println(comment);
    }


    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    @Test
    public void testFindCommentListByParentId(){
        Page<Comment> page = commentService.findCommentListByParentId("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        List<Comment> content = page.getContent();
        System.out.println(content);
    }

    @Test
    public void testUpdateCommentClickNum(){
        commentService.updateCommentClickNum("1");
    }




}
