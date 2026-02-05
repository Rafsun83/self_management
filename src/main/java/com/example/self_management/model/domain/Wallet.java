package com.example.self_management.model.domain;

import jakarta.persistence.*;

import java.util.Date;


public class Wallet {
    private Long id;
    private Long userId;
    private String type;
    private Number amount;
    private String category;
    private Date createdTime;
    private Date updatedTime;


    public Wallet() {}

    public Wallet(Long id, String type, Number amount, String category, Long userId) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.userId = userId;
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

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
}
