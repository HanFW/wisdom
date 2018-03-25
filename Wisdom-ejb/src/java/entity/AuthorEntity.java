/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yongxue
 */
@Entity
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String username; 
    private String description; // short intro text
    private String email;
    private String pwd;
    private BigDecimal balance; // received credit
    private BigDecimal qtnPrice;  // author-defined question price (default to 5)

    @XmlTransient
    @OneToMany(cascade = {CascadeType.DETACH}, mappedBy = "author")
    private List<ArticleEntity> articles = new ArrayList<>();

    @XmlTransient
    @OneToMany(cascade = {CascadeType.DETACH}, mappedBy = "author")
    private List<QuestionEntity> questions = new ArrayList<>();

    /*
     AuthorEntity - ReaderEntity JoinTable
     */
    @XmlTransient
    @ManyToMany(cascade = {CascadeType.DETACH}, mappedBy = "following")
    private List<ReaderEntity> followers = new ArrayList<>();

    public AuthorEntity() {

    }

    public AuthorEntity(String username, String description, String email, String pwd) {
        this.username = username;
        this.description = description;
        this.email = email;
        this.pwd = pwd;
        this.balance = new BigDecimal(0);
        this.qtnPrice = new BigDecimal(5);
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getQtnPrice() {
        return qtnPrice;
    }

    public void setQtnPrice(BigDecimal qtnPrice) {
        this.qtnPrice = qtnPrice;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public List<ReaderEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(List<ReaderEntity> followers) {
        this.followers = followers;
    }
}
