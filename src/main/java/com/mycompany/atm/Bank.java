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
public class Bank {
    
    public UserList users = new UserList();
    private String uid = "";
    
    //login and register
    public void register(String pin, String uid){
        try{
     if(users.pinFound(pin) && users.uidFound(uid)) System.out.println("User already exists, please login.");   
     else{
      User u=new User(pin,uid);
      users.createUser(u);
      System.out.println("User created.");
     }
        }catch(Exception e){
         System.out.println("Exception in register. Try again.");
        }
    }
    
    public String login(String pin, String uid){
        try{
     User u = users.readUser(uid);
     if(u.pin.equals(pin)){
      System.out.println("logged in successfully. Proceed.");
      uid=u.userId;
     }
     else System.out.println("could not find you in the system. Try again.");
        }catch(Exception e){
         System.out.println("Exception in login. ");
        }
     return uid;
    }
    
    //withdraw, deposit, transfer
    public void withdraw(String uid1, double amount){
     User u = users.readUser(uid1);
     u.withdraw(amount);
     users.deleteUser(uid1);
     users.createUser(u);
     u.toString();
    }
    
    public void deposit(String uid1, double amount){
     User u = users.readUser(uid1);
     u.deposit(amount);
     users.deleteUser(uid1);
     users.createUser(u);
     u.toString();
    }
    
    public void transfer(String uid1, String dest, double amount){
     User u = users.readUser(uid1);
     u.transfer(amount,dest);
     users.deleteUser(uid1);
     users.createUser(u);
     u.toString();
    }
    
    //constructor
    public Bank(){}
    
    //toString
    public String toString(){
     String str = "uid="+uid+",users: ";
     Iterator<User> iter= users.users.iterator();
     while(iter.hasNext()){
      User t = iter.next();
      str+=t.toString();
     }
     return str;
    }
    
    //get a balance for a given user id
    public double getBalanceForUser(String uid){
        try{
     User u=users.readUser(uid);
     return u.getBalance();
        }catch(Exception e){
         System.out.println("exception in getting balance.");
        }
        return 0.0;
    }
    
    //show all transactions for a given uid
    public void showAll(String uid){
     User u=users.readUser(uid);
     Iterator<Transaction> iter = u.transactions.iterator();
     
     while(iter.hasNext()){
      Transaction t = iter.next();
      System.out.println(t.toString());
     }
    }
    
}
