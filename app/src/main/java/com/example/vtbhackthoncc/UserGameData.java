package com.example.vtbhackthoncc;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class UserGameData implements Serializable {
    private HashMap<String, Integer> stockName_Amount = new HashMap<>();
    private int wallet;
    private boolean registrationStatus;
    public static String fileName = "UserGameData.data";
    private String nickname;
    private String dateOfBirth;
    private boolean sentToInvestStatus;

    UserGameData(){
        nickname = "SomeNickname";
        dateOfBirth = "01.01.1901";
        sentToInvestStatus = false;
        registrationStatus = false;
        wallet = 1000000;
        stockName_Amount.put("Pig", 0);
        stockName_Amount.put("Boar", 0);
        stockName_Amount.put("Cat", 0);
        stockName_Amount.put("Lion", 0);
        stockName_Amount.put("Tiger", 0);
        stockName_Amount.put("Elephant", 0);
        stockName_Amount.put("Cow", 0);
        stockName_Amount.put("Eagle", 0);
        stockName_Amount.put("Hippopotamus", 0);
        stockName_Amount.put("Crocodile", 0);
        stockName_Amount.put("Squirrel", 0);
        stockName_Amount.put("Leopard", 0);
        stockName_Amount.put("Llama", 0);
        stockName_Amount.put("Bear", 0);
        stockName_Amount.put("Giraffe", 0);
        stockName_Amount.put("Fox", 0);
        stockName_Amount.put("Parrot", 0);
        stockName_Amount.put("Donkey", 0);
        stockName_Amount.put("Mouse", 0);
        stockName_Amount.put("Rhino", 0);
        stockName_Amount.put("Deer", 0);
        stockName_Amount.put("Pigeon", 0);
        stockName_Amount.put("Dog", 0);
        stockName_Amount.put("Wolf", 0);
        stockName_Amount.put("Camel", 0);
        stockName_Amount.put("Platypus", 0);
        stockName_Amount.put("Flamingo", 0);
        stockName_Amount.put("Beaver", 0);
        stockName_Amount.put("Puma", 0);
        stockName_Amount.put("Horse", 0);
    }

    public void changeStockAmount(String name, int amount, boolean toAdd){
        //true - to add
        //false - to subtract
        if (toAdd) stockName_Amount.put(name, stockName_Amount.get(name)+amount);
        else stockName_Amount.put(name, stockName_Amount.get(name)-amount);
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public Integer getAmount(String name) {
        return stockName_Amount.get(name);
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSentToInvestStatus(boolean sentToInvestStatus) {
        this.sentToInvestStatus = sentToInvestStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean getSentToInvestStatus(){
        return  sentToInvestStatus;
    }

    public void saveToFile(Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static UserGameData readFromFile(Context context) {
        UserGameData userDataFile = null;
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userDataFile = (UserGameData) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userDataFile;
    }

}
