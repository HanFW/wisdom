/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Yongxue
 */
@Entity
public class CompensationEntity extends TransactionEntity {

    @OneToOne(cascade = {CascadeType.DETACH})
    private QuestionEntity question;

    public CompensationEntity() {
        
    }
    
    public CompensationEntity(QuestionEntity question) {
        this.question = question;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}
