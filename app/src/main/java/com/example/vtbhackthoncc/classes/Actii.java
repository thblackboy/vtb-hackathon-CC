package com.example.vtbhackthoncc.classes;

public class Actii {
    private int price;
    private String name;
    private int img;
 //   private String[] plus;
    public Actii[] dA=new Actii[4];
    private int i=0;

    public Actii(String name,int price,int img){
        this.img=img;
        this.price=price;
        this.name=name;
    }
    public void addDepAct(Actii act){
        dA[i]=act;
        i++;
    }
    public int getImg(){return img;}
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
