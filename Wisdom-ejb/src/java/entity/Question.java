/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Yongxue
 */
@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String title;
    private String content; // reader's qtn
    private String status; // ANSWERED, REJECTED, PENDING, EXPIRED
    private String reply; // author's reply
    
    @OneToOne(cascade = {CascadeType.DETACH})
    private Reader reader; // raised the qtn
    @OneToOne(cascade = {CascadeType.DETACH})
    private Author author; // asked to answer
    @OneToOne(cascade = {CascadeType.DETACH})
    private Compensation compensation; 

    public Question() {
        
    }
    
    public Question(String title, String content, String status, Reader reader, Author author) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.reader = reader;
        this.author = author;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }
    
    
}
