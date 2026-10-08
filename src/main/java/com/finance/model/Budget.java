package com.finance.model;

public class Budget {
    private int id, userId;
    private String category, duration;
    private double amount;

    public Budget() {}
    public Budget(int id,int userId,String category,double amount,String duration){
        this.id=id;this.userId=userId;this.category=category;this.amount=amount;this.duration=duration;
    }
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId=userId;}
    public String getCategory(){return category;}
    public void setCategory(String category){this.category=category;}
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount=amount;}
    public String getDuration(){return duration;}
    public void setDuration(String duration){this.duration=duration;}
}
