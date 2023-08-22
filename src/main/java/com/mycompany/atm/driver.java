/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atm;

import java.util.Scanner;

/**
 *
 * @author scott
 */
public class driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Bank b=new Bank();
        boolean done=false;
        boolean shutdown=false;
        do{
        String uid="",pin="",uid1="",line="",dest="";
        boolean authed=false;
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        do{
        //login
        System.out.println("Do you want to login or register? 1) login 2) register");
        line=s.nextLine();
        int choice=Integer.parseInt(line);
        switch(choice){
            case 1: {
              //login
                System.out.println("Enter your id and pin for login, separated by a space: ");
             line=s.nextLine();
             String[] tokens=line.split(" ");
             uid=tokens[0];
             pin=tokens[1];
              uid1=b.login(uid,pin);
              authed=true;
              break;
            }
            
            case 2: {
             //register
             System.out.println("Enter your id and pin, separated by a space: ");
             line=s.nextLine();
             String[] tokens=line.split(" ");
             uid=tokens[0];
             pin=tokens[1];
             b.register(uid,pin);
             break;
            }
            
            default: {
             System.out.println("Enter a valid choice 1) login 2) register");
             break;
            }
        }
        }while(!authed);
        
        //main menu
        do{
         System.out.println("Main Menu: 1) view transactions 2) withdraw 3) deposit 4) transfer 5) quit");
        line=s.nextLine();
        int choice=Integer.parseInt(line);
            
        
        switch(choice){
            
            //quit
            case 5: {
             done=true;
             System.out.println("Goodbye!!!");
             break;
            }
            
            //view all transactions
            case 1: {
             b.showAll(uid1);
             break;
            }
            
            //withdraw
            case 2: {
             System.out.println("Enter how much you want to pull out of your account: ");
             double amt=Double.parseDouble(s.nextLine());
             b.withdraw(uid1, amt);
             System.out.println("new balance is: "+b.getBalanceForUser(uid1));
             break;
            }
            
            //deposit
            case 3: {
             System.out.println("Enter how much you want to add to your account: ");
             double amt=Double.parseDouble(s.nextLine());
             b.deposit(uid1, amt);
             System.out.println("new balance is: "+b.getBalanceForUser(uid1));
             break;
            }
            
            //transfer
            case 4: {
             System.out.println("Enter your destination for transfer, and amount, separated by a space: ");
             line=s.nextLine();
             String[] tokens=line.split(" ");
             dest=tokens[0];
             double amt=Double.parseDouble(tokens[1]);
             b.transfer(uid1, dest, amt);
             System.out.println("new balance is: "+b.getBalanceForUser(uid1));
             break;
            }
        }
        
        System.out.println("Do you want to shut me down? 1) yes 2) no");
        line=s.nextLine();
        if(line.equals("1")) shutdown=true;
        }while(!done);
        }while(!shutdown);
        }catch(Exception e){e.printStackTrace();}
    }
    
}
