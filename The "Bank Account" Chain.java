// Challenge 1: The "Bank Account" Chain (throws Propagation)
// Goal: Understand how exceptions propagate up the call stack using throws and how to handle them at the right level.

// Task: Create a custom unchecked (RuntimeException) exception named InsufficientFundsException.

// Structure:

// Create a BankAccount class with a withdraw(double amount) method. If the amount exceeds the balance, throw InsufficientFundsException.

// Create an ATM class with a dispenseCash(BankAccount account, double amount) method. This method should not catch the exception; it should just pass the buck upward using throws (or let it propagate naturally if you made it unchecked).

// Create a CustomerUI class (your main method). This is where you actually call dispenseCash(), wrap it in a try-catch block, and handle the error by printing a user-friendly warning.

// custom exception 

import java.util.Scanner;

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class BankAccount{
  private double balance;
  public BankAccount(double balance){
    this.balance=balance;
  }
  public double getBalance(){
    return balance;
  }
  public void withdraw(double amount){
    if(amount>balance){
      throw new InsufficientFundsException("Insufficient funds for withdrawal of " + amount);
    }    
  else{
    balance-=amount;
  }
  }
}
class ATM{
  public void dispenseCash(BankAccount account, double amount){
    account.withdraw(amount);
  }
}

public class curious {
      public static void main(String[] args) {
      System.out.println("Enter amount to deposit in the bank account:");
      Scanner sc= new Scanner(System.in);
      double initial= sc.nextDouble();
       BankAccount account = new BankAccount(initial);
          System.out.println(" account with balance: " + initial);
System.out.println("Enter amount to withdraw from the bank account:");
      Scanner amScanner= new Scanner(System.in);
      double amount= amScanner.nextDouble();
        ATM atm = new ATM();
          try {
              atm.dispenseCash(account, amount);
          } catch (InsufficientFundsException e) {
              System.out.println("Error: " + e.getMessage());
          }
          finally{
            System.out.println("Final balance in the account: " + account.getBalance());
            System.out.println("Thank you for using our ATM service.");
            System.out.println("Transaction completed.");
          } 
    }
}
