/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Yongxue
 */
@Entity
public class Reader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readerId;

    private String name; // format: [firstName lastName]
    private String email;
    private String pwd;
    private String picPath;
    private double balance = 0; // topped up credit - usage
    private ArrayList<String> topics = new ArrayList<>(); // interested topics
    
    @OneToMany(cascade = {CascadeType.DETACH})
    private ArrayList<Article> saved = new ArrayList<>(); // saved articles
    // available topics stored in client app

    public Reader(String name, String email, String pwd, double balance) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public ArrayList<Article> getSaved() {
        return saved;
    }

    public void setSaved(ArrayList<Article> saved) {
        this.saved = saved;
    }
}
