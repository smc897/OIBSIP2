/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atm;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author scott
 */
public class User {
    
    public String pin;
    public String userId;
    double balance=0.0;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    //withdraw
    public void withdraw(double amount){
     String timeStamp=""+System.currentTimeMillis();
     double startingBalance=balance;
     double endingBalance=startingBalance-amount;
     balance=endingBalance;
     Transaction t = new Transaction("withdrawal",timeStamp,amount,"self",endingBalance,startingBalance);
     transactions.add(t);
     t.toString();
    }
    
    //deposit
    public void deposit(double amount){
    String timeStamp=""+System.currentTimeMillis();
     double startingBalance=balance;
     double endingBalance=startingBalance+amount;
     balance=endingBalance;
     Transaction t = new Transaction("deposit",timeStamp,amount,"self",endingBalance,startingBalance);
     transactions.add(t);
     t.toString();
    }
    
    public void transfer(double amount, String dest){
    String timeStamp=""+System.currentTimeMillis();
     double startingBalance=balance;
     double endingBalance=startingBalance+amount;
     balance=endingBalance;
     Transaction t = new Transaction("transfer",timeStamp,amount,dest,endingBalance,startingBalance);
     transactions.add(t);
     t.toString();
    }
    
    //constructor
    public User(String pin1, String userId1){
     pin=pin1;
     userId=userId1;
    }
    
    //to string
    public String toString(){
     String str = "pin="+pin+",userId="+userId+",transactions: ";
     Iterator<Transaction> iter= transactions.iterator();
     while(iter.hasNext()){
      Transaction t = iter.next();
      str+=t.toString();
     }
     return str;
    }
    
    //get balance
    public double getBalance(){return balance;}
}
