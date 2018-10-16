package com.capgemini.lab_assignments;

import org.apache.log4j.Logger;
import java.util.Random;

// to print $ symbol, "\u0024"
// to print pounds, "\u00A3"

class Person {
	String name;
	float age;
	
	public Person(String name, float age) {
		this.name = name;
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
	long accNum;
	double balance;
	Person accHolder;
	
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
}

class SavingsAccount extends Account {
	final double minimumBalance = 100;
	Logger log = Logger.getLogger(SavingsAccount.class.getName());
	
	public SavingsAccount (double b, Person ah) {
		super(b, ah);
	}
	
	
	public void withdraw(double amount) {
		if (this.balance - amount < minimumBalance) {
			log.warn("Cannot withdraw until below Minimum Balance");
		} else {
			this.balance -= amount;
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
			if (amount > this.balance) {
				if (amount - this.balance + overdraftRecord > this.overdraftLimit) {
					this.balance = 0;
					this.overdraftRecord = this.overdraftLimit;
					log.warn("Cannot withdraw excess of overdraftLimit!");
				} else {
					this.overdraftRecord += amount - this.balance;
					this.balance = 0;
				}
			} else {
				this.balance -= amount;
			}
		}
		log.info("Balance: " + this.balance);
		log.info("Overdraft Record: " + this.overdraftRecord);
	}
}

public class AccountTest {
	
	static Logger log = Logger.getLogger(AccountTest.class.getName());
	Random generator = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrentAccount myAccount = new CurrentAccount(1700, new Person("Roy",25));
		log.info(myAccount.getAccNum());
		myAccount.withdraw(500.0);
		log.info(myAccount.getBalance());
		myAccount.withdraw(500.0);
		log.info(myAccount.getBalance());
		myAccount.withdraw(500.0);
		log.info(myAccount.getBalance());
		myAccount.withdraw(2300.0);
		log.info(myAccount.getBalance());
	}

}
