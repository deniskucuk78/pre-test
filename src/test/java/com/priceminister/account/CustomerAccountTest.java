package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(Double.valueOf(0),customerAccount.getBalance());
        assertNotNull(customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	customerAccount.add(20d);
    	assertEquals(Double.valueOf(20),customerAccount.getBalance());
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
    	
    	try {
    		customerAccount.withdrawAndReportBalance(Double.valueOf(10), rule);
    		}
    	catch(IllegalBalanceException e) {
    		assertEquals(Double.valueOf(-10),e.getBalance());
    	}
    	
    }
    

    
    // Also implement missing unit tests for the above functionalities.
    
    /**
     * Tests that an account with money always has a balance greater than 0
     */
    @Test
    public void testAccountWithMoneyHasBalanceGreaterThanZero() {
    	customerAccount.add(20d);
    	assertTrue(customerAccount.getBalance() > 0);
    }
    
    
    /**
     * Tests that a correct withdrawal affects the account balance as expected
     */
    @Test
    public void testCorrectWithdraw() {
    	customerAccount.add(20d);
    	try {
    		customerAccount.withdrawAndReportBalance(Double.valueOf(10), rule);
    		}
    	catch(IllegalBalanceException e) {
    	}
    	finally {
    		assertEquals(Double.valueOf(10), customerAccount.getBalance());
    	}
    	
    }
    
    /**
     * Tests that the withdrawPermitted rule returns True when the resulting account balance is positive
     */
    @Test
    public void testWithdrawRuleWithPositiveResultingAccountBalance() {
    	
    	double resultingAccountBalance = 20;
    	assertTrue(rule.withdrawPermitted(resultingAccountBalance));
    	
    }
    
    
    /**
     * Tests that the withdrawPermitted rule returns False when the resulting account balance is negative
     */
    @Test
    public void testWithdrawRuleWithNegativeResultingAccountBalance() {
    	
    	double resultingAccountBalance = -20;
    	assertFalse(rule.withdrawPermitted(resultingAccountBalance));
    	
    }
    
    

}
