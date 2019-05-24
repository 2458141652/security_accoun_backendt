package com.stock.account.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Account")
public class Account implements Serializable{
    @Id
    //@GeneratedValue
    private Long account_id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private boolean loss;

    public Account() {}
    public Account(Long id, String type) {
        this.account_id = id;
        this.type = type;
        this.loss = false;
    }

    public Long getId() {
        return account_id;
    }
    public void setId(Long id) {
        this.account_id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean getLoss() {
        return loss;
    }
    public void setLoss(boolean loss) {
        this.loss = loss;
    }
    public Account getAccount() {
        return this;
    }

}


