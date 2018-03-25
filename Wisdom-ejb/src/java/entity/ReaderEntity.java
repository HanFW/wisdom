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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yongxue
 */
@Entity
public class ReaderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readerId;

    private String name; // format: [firstName lastName]
    private String email;
    private String pwd;
    private String picPath;
    private BigDecimal balance; // topped up credit - usage
    private ArrayList<String> topics = new ArrayList<>(); // interested topics
    
    // available topics stored in client app
    

    @XmlTransient
    @OneToMany(cascade = {CascadeType.DETACH}, mappedBy = "reader")
    private List<QuestionEntity> questions = new ArrayList<>();
    
    /*
    AuthorEntity - ReaderEntity JoinTable
     */
    @XmlTransient//? should it be returned?
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ReaderFollowAuthor")
    private List<AuthorEntity> following = new ArrayList<>();
    
     
    /*
    ReaderEntity - ArticleEntity JoinTable
     */
    @XmlTransient
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ReaderSaveArticle")
    private List<ArticleEntity> savedArticles = new ArrayList<>();
    

    public ReaderEntity() {
        
    }
    
    public ReaderEntity(String name, String email, String pwd) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.balance = new BigDecimal (0);
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }



    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public List<ArticleEntity> getSavedArticles() {
        return savedArticles;
    }

    public void setSavedArticles(List<ArticleEntity> savedArticles) {
        this.savedArticles = savedArticles;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public List<AuthorEntity> getFollowing() {
        return following;
    }

    public void setFollowing(List<AuthorEntity> following) {
        this.following = following;
    }
}
