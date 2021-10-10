package com.example.vtbhackthoncc.classes;

public class News {
    private String head;
    private String mess;
    private String buy;
    private Actii action;
    private double val;
    private int company;
    public News(String head,String mess,String buy,double val){
        this.head=head;
        this.mess=mess;
        this.buy=buy;
        if(buy.equals(1))
            this.val=val;
        else
            this.val=-val;
    //    this.action=action;
 //       this.company=company;
    }
    public String getHead(){
        return head;
    }
    public String getMess(){
        return mess;
    }
    public String getBuy(){
        return buy;
    }
    public double getVal(){return val;}



}
