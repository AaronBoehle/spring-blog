package com.codeup.blog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;


    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;


    public Category(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}


}
