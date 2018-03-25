/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author Yongxue
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class TransactionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private BigDecimal amount;
    private LocalDateTime time; // initialised to .now() upon construction

    @OneToOne(cascade = {CascadeType.DETACH})
    private ReaderEntity from;
    @OneToOne(cascade = {CascadeType.DETACH})
    private AuthorEntity to;

    public TransactionEntity() {

    }

    public TransactionEntity(BigDecimal amount, LocalDateTime time, ReaderEntity from, AuthorEntity to) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ReaderEntity getFrom() {
        return from;
    }

    public void setFrom(ReaderEntity from) {
        this.from = from;
    }

    public AuthorEntity getTo() {
        return to;
    }

    public void setTo(AuthorEntity to) {
        this.to = to;
    }
}
