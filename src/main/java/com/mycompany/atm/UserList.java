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
public class UserList {
    public ArrayList<User> users = new ArrayList<User>();
    
    //create
    public void createUser(User u){
     users.add(u);
    }
    
    //read user
    public User readUser(String uid){
     Iterator<User> iter = users.iterator();
     while(iter.hasNext()){
      User u = iter.next();
      if(u.userId.equals(uid)) return u;
     }
     return null;
    }
    
    //update user
    public void updateUser(String uid, String pin){
      Iterator<User> iter = users.iterator();
     while(iter.hasNext()){
      User u = iter.next();
      if(u.userId.equals(uid)) u.pin=pin;
     }
    }
    
    //delete user
    public void deleteUser(String uid){
     Iterator<User> iter = users.iterator();
     while(iter.hasNext()){
      User u = iter.next();
      if(u.userId.equals(uid)) iter.remove();
     }
    }
    
    //is the pin found?
    public boolean pinFound(String pin){
      Iterator<User> iter = users.iterator();
     while(iter.hasNext()){
      User u = iter.next();
      if(u.pin.equals(pin)) return true;
     }
     return false;
    }
    
    //is the uid found?
    public boolean uidFound(String uid){
      Iterator<User> iter = users.iterator();
     while(iter.hasNext()){
      User u = iter.next();
      if(u.userId.equals(uid)) return true;
     }
     return false;
    }
}
