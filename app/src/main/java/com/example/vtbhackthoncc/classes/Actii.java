package com.example.vtbhackthoncc.classes;

public class Actii {
    private int price;
    private String name;
    private String img;
 //   private String[] plus;
 //   private String[] minus;

    public Actii(String name,int price,String img){
        this.img=img;
        this.price=price;
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}
