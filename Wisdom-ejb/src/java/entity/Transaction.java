/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private double amount; 
    private LocalDateTime time; // initialised to .now() upon construction
    
    @OneToOne(cascade = {CascadeType.DETACH})
    private Reader from;
    @OneToOne(cascade = {CascadeType.DETACH})
    private Author to;

    public Transaction(double amount, LocalDateTime time, Reader from, Author to) {
        this.amount = amount;
        this.time = LocalDateTime.now();
        this.from = from;
        this.to = to;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Reader getFrom() {
        return from;
    }

    public void setFrom(Reader from) {
        this.from = from;
    }

    public Author getTo() {
        return to;
    }

    public void setTo(Author to) {
        this.to = to;
    }
}
