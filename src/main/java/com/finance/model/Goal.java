package com.finance.model;

import java.time.LocalDate;

public class Goal {
    private int id,userId;
    private String description;
    private double targetAmount,savedAmount;
    private LocalDate deadline;

    public Goal(){}
    public Goal(int id,int userId,String description,double targetAmount,double savedAmount,LocalDate deadline){
        this.id=id;this.userId=userId;this.description=description;this.targetAmount=targetAmount;
        this.savedAmount=savedAmount;this.deadline=deadline;
    }
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public double getTargetAmount(){return targetAmount;}
    public void setTargetAmount(double targetAmount){this.targetAmount=targetAmount;}
    public double getSavedAmount(){return savedAmount;}
    public void setSavedAmount(double savedAmount){this.savedAmount=savedAmount;}
    public LocalDate getDeadline(){return deadline;}
    public void setDeadline(LocalDate deadline){this.deadline=deadline;}
    public double getProgress(){return targetAmount==0?0:(savedAmount/targetAmount)*100;}
}
