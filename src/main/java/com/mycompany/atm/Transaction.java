/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atm;

/**
 *
 * @author scott
 */
public class Transaction {
    public String type;
    public String date;
    public double transAmount=0.0;
    public String destName;
    public double endingBalance=0.0;
    public double startingBalance=0.0;
    
    //constructor
    public Transaction(String type1, String date1,double transAmount1, String destName1, double endingBalance1, double startingBalance1){
     type=type1;
     date=date1;
     transAmount=transAmount1;
     destName=destName1;
     endingBalance=endingBalance1;
     startingBalance=startingBalance1;
    }
    
    //to string
    public String toString(){
     String str="type:"+type+",date:"+date+",transAmount:"+transAmount+",destName:"+destName+",endingBalance:"+endingBalance+",startingBalance:"+startingBalance;
     return str;
    }
}
