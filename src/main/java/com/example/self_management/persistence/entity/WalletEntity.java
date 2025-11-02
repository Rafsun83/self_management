package com.example.self_management.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="wallet" )
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Number amount;
    private String category;
    private Date createdTime;
    private Date updatedTime;

    public WalletEntity() {}

    public WalletEntity(Long id, String type, Number amount, String category) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public Number getAmount(){
        return amount;
    }
    public void setAmount(Number amount){
        this.amount = amount;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public Date getCreatedTime(){
        return createdTime;
    }
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    public Date getUpdatedTime(){
        return updatedTime;
    }
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}
