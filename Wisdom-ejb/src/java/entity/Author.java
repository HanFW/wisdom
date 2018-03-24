/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yongxue
 */
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String name; // format: [firstName lastName]
    private String description; // short intro text
    private String email;
    private String pwd;
    private String picPath; // path to profile pic
    private double balance = 0; // received credit
    private double qtnPrice = 5; // author-defined question price (default to 5)

    public Author() {
        
    }
    
    public Author(String name, String description, String email, String pwd, double balance) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.pwd = pwd;
        this.balance = balance;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getQtnPrice() {
        return qtnPrice;
    }

    public void setQtnPrice(double qtnPrice) {
        this.qtnPrice = qtnPrice;
    }

}
