package com.wss.mongodb.dao;

import com.wss.mongodb.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 王森森
 * @create 2020/12/12 19:34
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByParentid(String parentId, Pageable pageable);
}
