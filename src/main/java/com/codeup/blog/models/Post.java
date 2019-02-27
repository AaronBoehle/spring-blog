package com.codeup.blog.models;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

//     Mapped to SQL
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 512)
    private String body;

//     Post object contructor(s)
    public Post (long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post (String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(){ }


//    Getters and Setters
    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}

    public String getBody(){return body;}
    public void setBody(String body) {this.body = body;}
}
