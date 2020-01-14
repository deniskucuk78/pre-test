package com.priceminister.account;


public class IllegalBalanceException extends Exception {
    
    private static final long serialVersionUID = -9204191749972551939L;
    
	private Double balance;
	
	
    public Double getBalance() {
		return balance;
	}

	public IllegalBalanceException(Double illegalBalance) {
        balance = illegalBalance;
        System.out.println(this);
    }
    
    public String toString() {
        return "Illegal account balance: " + balance;
    }
}
