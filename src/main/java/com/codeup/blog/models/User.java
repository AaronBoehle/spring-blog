package com.codeup.blog.models;
import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {

    //     Mapped to SQL
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 512)
    private String password;

    //Copy constructor - used as an alternative to cloning an object
    public User (User copy) {
        id = copy.id;
        email  = copy.email;
        username = copy.username;
        password = copy.password;


    }

    //     User object contructor(s)
    public User (long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User (String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User (String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(){ }


    //    Getters and Setters
    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public String getUsername(){return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail(){return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword(){return password;}
    public void setPassword(String password) {this.password = password;}
}
