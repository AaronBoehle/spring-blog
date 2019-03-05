package com.codeup.blog.models;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_categories",
            joinColumns ={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

//    @Column()
//    private Date date;

//     Post object contructor(s)

    public Post (long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }
    public Post (long id, String title, String body, User user, List<PostImage> images) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
    }
    public Post (long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public Post (long id, String title, String body, User user, List<PostImage> images, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories = categories;
    }
    public Post (String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post (String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }
    public Post (String title, String body, User user, List<PostImage> images) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
    }
    public Post (String title, String body, User user, List<PostImage> images, List<Category> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories = categories;

    }
    public Post(){ }


//    Getters and Setters
    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}

    public String getBody(){return body;}
    public void setBody(String body) {this.body = body;}


    public User getUser(){ return user; }
    public void setUser(User user) { this.user = user; }

    public List<PostImage> getImages(){ return images;}
    public void setImages(List<PostImage> images){this.images = images;}

}
