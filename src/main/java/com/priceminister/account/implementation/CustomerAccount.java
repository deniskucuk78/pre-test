package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {
	
	/**
	 * The name of the user
	 */
	private String userName;
	
	
	/**
	 * The balance of the account
	 */
	private double balance;
	
	
	/**
	 * Constructor without parameters
	 */
    public CustomerAccount() {
		super();
		balance = 0d;
	}

    
	/**
	 * Constructor with parameters
	 *  @param userName - the name of the user
	 *  @param balance - the balance of the account
	 */
	public CustomerAccount(String userName, double balance) {
		this.userName = userName;
		this.balance = balance;
	}


    /**
     * Adds money to this account.
     * @param addedAmount - the money to add
     */
	public void add(Double addedAmount) {
        this.balance += addedAmount;
    }

    /**
     * Gets the current account balance.
     * @return the account's balance
     */
    public Double getBalance() {
        
        return this.balance;
    }
    

    /**
     * Sets the account balance.
     * @param balance - the new account's balance
     */
    public void setBalance(double balance) {
		this.balance = balance;
	}

    
    /**
     * Withdraws money from the account.
     * @param withdrawnAmount - the money to withdraw
     * @param rule - the AccountRule that defines which balance is allowed for this account
     * @return the remaining account balance
     * @throws IllegalBalanceException if the withdrawal leaves the account with a forbidden balance
     */
	public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
		double resultingAccountBalance = this.balance - withdrawnAmount;
        if(!rule.withdrawPermitted(resultingAccountBalance))
        	throw new IllegalBalanceException(resultingAccountBalance);
        else {
        	this.balance = resultingAccountBalance;
        	return this.balance;
        }
    }


	@Override
	public String toString() {
		return "CustomerAccount [balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAccount other = (CustomerAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
	

}
