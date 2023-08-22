/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.atm.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author scott
 */
public class TestAuth {
    final double WITHDRAWAMOUNT = 5.5;
    final String DEST="Chase";
    final String TESTPIN="1234";
    final String TESTUID="SCottMC";
    
    public TestAuth() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    Bank b = new Bank();
    
    //auth test
    @Test
    public void testAuth(){
     b.register(TESTPIN,TESTUID);
     String uid=b.login(TESTPIN,TESTUID);
     assertEquals(uid,TESTUID);
     
     //withdraw 5.5 dollars
     double balance=b.getBalanceForUser(uid);
     b.withdraw(uid, WITHDRAWAMOUNT);
     double balance1=b.getBalanceForUser(uid);
     double difference=balance-balance1;
     assertEquals(difference,WITHDRAWAMOUNT);
     
     //deposit 5.5 dollars
     balance=b.getBalanceForUser(uid);
     b.deposit(uid, WITHDRAWAMOUNT);
     balance1=b.getBalanceForUser(uid);
     difference=balance1-balance;
     assertEquals(difference,WITHDRAWAMOUNT);
     
     //transfer 5.5 dollars
     balance=b.getBalanceForUser(uid);
     b.transfer(uid, DEST, WITHDRAWAMOUNT);
     balance1=b.getBalanceForUser(uid);
     difference=balance1-balance;
     assertEquals(difference,WITHDRAWAMOUNT);
    }
}
