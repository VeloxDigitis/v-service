package me.veloxdigitis.vservice.comments;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    Set<Comment> findAllBy();

}
