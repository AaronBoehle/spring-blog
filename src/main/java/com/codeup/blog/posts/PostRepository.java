package com.codeup.blog.posts;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// comes with built in findAll, findOne, save, and delete methods out of the box
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("from Post title where title like %:term%")
    List<Post> searchByTitleLike(@Param("term") String term);
}
