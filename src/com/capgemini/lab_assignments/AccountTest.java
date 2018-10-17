package com.capgemini.lab_assignments;

import org.apache.log4j.Logger;
import java.util.Random;

// to print $ symbol, "\u0024"
// to print pounds, "\u00A3"

class AgeException extends Exception {
	public AgeException(){
		super("Age cannot be less than 15".toUpperCase());
	}
}

class Person {
	private String name;
	private float age;
	
	public Person(String name, float age) throws AgeException {
		this.name = name;
		if (age < 15) {
			throw new AgeException();
		}
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getAge() {
		return this.age;
	}
	@Override
	public String toString() {
		return this.name;
	}
}

class Account {
	Random r = new Random();
	private long accNum;
	private double balance;
	private Person accHolder;
	
	public Account (double b, Person ah) {
		this.accNum = r.nextLong();
		this.balance = b;
		this.accHolder = ah; 
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public long getAccNum() {
		return this.accNum;
	}
	
	public Person getAccHolder() {
		return this.accHolder;
	}
	
	public void setBalance(double amount) {
		this.balance = amount;
	}
	@Override
	public String toString() {
		return "You have " + this.balance + " in your account";
	}
}

class SavingsAccount extends Account {
	final double minimumBalance = 100;
	Logger log = Logger.getLogger(SavingsAccount.class.getName());
	
	public SavingsAccount (double b, Person ah) {
		super(b, ah);
	}
	
	
	public void withdraw(double amount) {
		if (this.getBalance() - amount < minimumBalance) {
			log.warn("Cannot withdraw until below Minimum Balance");
		} else {
			super.withdraw(amount);
		}
	}
}

class CurrentAccount extends Account {
	Logger log = Logger.getLogger(CurrentAccount.class.getName());
	final double overdraftLimit = 1000;
	double overdraftRecord = 0;
	
	public CurrentAccount (double b, Person ah) {
		super(b, ah);
	}
	
	public void withdraw(double amount) {
		if (this.overdraftRecord >= this.overdraftLimit) {
			log.warn("Cannot withdraw due to overdraftLimit reached");
		} else {
			if (amount > this.getBalance()) {
				if (amount - this.getBalance() + overdraftRecord > this.overdraftLimit) {
					this.setBalance(0);
					this.overdraftRecord = this.overdraftLimit;
					log.warn("Cannot withdraw excess of overdraftLimit!");
				} else {
					this.overdraftRecord += amount - this.getBalance();
					this.setBalance(0);
				}
			} else {
				super.withdraw(amount);
			}
		}
		log.info("Balance: " + this.getBalance());
		log.info("Overdraft Record: " + this.overdraftRecord);
	}
}

public class AccountTest {
	
	static Logger log = Logger.getLogger(AccountTest.class.getName());
	Random generator = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Person smith = new Person("Smith", 20);
			Person kathy = new Person("Kathy", 14);
			SavingsAccount sa_smith = new SavingsAccount(2000, smith);
			CurrentAccount ca_kathy = new CurrentAccount(3000, kathy);
			sa_smith.deposit(2000);
			ca_kathy.withdraw(2000);
			log.info("Updated balance in Smith's savings account : " + sa_smith.getBalance());
			log.info("Updated balance in Kathy's current account : " + ca_kathy.getBalance());
		
		} catch (AgeException e) {
			log.info(e.getMessage());
		}
		
	
	}

}
