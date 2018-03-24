/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yongxue
 */
@Entity
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String topic;
    private String title;
    private String description; // short intro text
    private String picPath; // path to article picture 
    private String content;
    private Integer numOfLikes;
    private LocalDateTime time;

    @OneToOne(cascade = {CascadeType.DETACH})
    private AuthorEntity author;
    
    @OneToMany(cascade = {CascadeType.DETACH}, mappedBy = "article")
    private List<RewardEntity> rewards = new ArrayList<>();
    
    /*
    ReaderEntity - ArticleEntity JoinTable
     */
    @XmlTransient
    @ManyToMany(cascade = {CascadeType.DETACH}, mappedBy = "savedArticles")
    private List<ReaderEntity> readers = new ArrayList<>();

    public ArticleEntity() {

    }

    public ArticleEntity(String topic, String title, String description,
            String content, AuthorEntity author) {
        this.topic = topic;
        this.title = title;
        this.numOfLikes = 0;
        this.description = description;
        this.content = content;
        this.author = author;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(Integer numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<ReaderEntity> getReaders() {
        return readers;
    }

    public void setReaders(List<ReaderEntity> readers) {
        this.readers = readers;
    }

    public List<RewardEntity> getRewards() {
        return rewards;
    }

    public void setRewards(List<RewardEntity> rewards) {
        this.rewards = rewards;
    }
    
    
}
