package com.example.vtbhackthoncc;

public class News {
    private String head;
    private String mess;
    private String buy;
    private int lv;
    private int company;
    public News(String head,String mess,String buy){
        this.head=head;
        this.mess=mess;
        this.buy=buy;
 //       this.lv=lv;
 //       this.company=company;
    }
    String getHead(){
        return head;
    }
    String getMess(){
        return mess;
    }
    String getBuy(){
        return buy;
    }


}
