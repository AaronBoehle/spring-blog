package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

// comes with built in findAll, findOne, save, and delete methods out of the box
public interface PostRepository extends CrudRepository<Post, Long> {

//    @Query("select all from Post where title like %:term%")
//    List<Post> searchByTitleLike(@Param("term") String term);

}
