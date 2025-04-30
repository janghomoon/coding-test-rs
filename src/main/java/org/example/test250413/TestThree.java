package org.example.test250413;

import org.example.test250413.TestThree.BankAccountState;
import org.example.test250413.TestThree.StateInfo;

class BankAccount {
  private BankAccountState loggedIn;
  private BankAccountState loggedOut;
  private BankAccountState suspended;
  private BankAccountState bankAccountState;
  private int cashBalance;
  private String password;
  private int passwordRetries;
  private int resetCode;

  public BankAccount(int cashBalance, String password, int resetCode) {
    // YOUR SOLUTION HERE
    this.cashBalance = cashBalance;
    this.password = password;
    this.passwordRetries = 0;
    this.resetCode = resetCode;
    this.loggedIn = new LoggedIn(this);
    this.loggedOut = new LoggedOut(this);
    this.suspended = new Suspended(this);
    this.bankAccountState = this.loggedOut; // Initial state is LoggedOut
  }

  public void setState(BankAccountState state) {
    this.bankAccountState = state;
  }

  public BankAccountState getState() {
    return this.bankAccountState;
  }

  public BankAccountState getLoggedInState() {
    return this.loggedIn;
  }

  public BankAccountState getLoggedOutState() {
    return this.loggedOut;
  }

  public BankAccountState getSuspendedState() {
    return this.suspended;
  }

  public StateInfo login(String password) {
    return this.bankAccountState.login(password);
  }

  public StateInfo logout() {
    return this.bankAccountState.logout();
  }

  public StateInfo unlock(int resetCode) {
    return this.bankAccountState.unlock(resetCode);
  }

  public StateInfo withdrawMoney(int amount) {
    return this.bankAccountState.withdrawMoney(amount);
  }

  public void setCashBalance(int amount) {
    this.cashBalance = amount;
  }

  public int getCashBalance() {
    return this.cashBalance;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPasswordRetries(int passwordRetries) {
    this.passwordRetries = passwordRetries;
  }

  public int getPasswordRetries() {
    return this.passwordRetries;
  }

  public int getResetCode() {
    return this.resetCode;
  }
}

class TestThree {
  enum StateInfo {
    LOGGED_IN, LOGGED_OUT, SUSPENDED, ERROR
  }
  interface BankAccountState {
    public StateInfo login(String password);
    public StateInfo logout();
    public StateInfo unlock(int resetCode);
    public StateInfo withdrawMoney(int amount);
  }




}

// YOUR SOLUTION HERE
class LoggedIn implements BankAccountState {
  private BankAccount bankAccount;

  public LoggedIn(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
  }

  @Override
  public StateInfo login(String password) {
    System.out.println("Already logged in.");
    return StateInfo.LOGGED_IN;
  }

  @Override
  public StateInfo logout() {
    bankAccount.setState(bankAccount.getLoggedOutState());
    System.out.println("Logged out successfully.");
    return StateInfo.LOGGED_OUT;
  }

  @Override
  public StateInfo unlock(int resetCode) {
    System.out.println("Cannot unlock while logged in.");
    return StateInfo.LOGGED_IN;
  }

  @Override
  public StateInfo withdrawMoney(int amount) {
    if (amount > 0 && bankAccount.getCashBalance() >= amount) {
      bankAccount.setCashBalance(bankAccount.getCashBalance() - amount);
      System.out.println("Withdrew $" + amount + ". Current balance: $" + bankAccount.getCashBalance());
      return StateInfo.LOGGED_IN;
    } else if (amount <= 0) {
      System.out.println("Withdrawal amount must be positive.");
      return StateInfo.LOGGED_IN;
    } else {
      System.out.println("Insufficient funds.");
      return StateInfo.LOGGED_IN;
    }
  }
}

// YOUR SOLUTION HERE
class LoggedOut implements BankAccountState {
  private BankAccount bankAccount;

  public LoggedOut(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
  }

  @Override
  public StateInfo login(String password) {
    if (password.equals(bankAccount.getPassword())) {
      bankAccount.setState(bankAccount.getLoggedInState());
      bankAccount.setPasswordRetries(0);
      System.out.println("Logged in successfully.");
      return StateInfo.LOGGED_IN;
    } else {
      bankAccount.setPasswordRetries(bankAccount.getPasswordRetries() + 1);
      System.out.println("Incorrect password. Attempts remaining: " + (3 - bankAccount.getPasswordRetries()));
      if (bankAccount.getPasswordRetries() >= 3) {
        bankAccount.setState(bankAccount.getSuspendedState());
        System.out.println("Account suspended due to too many failed login attempts.");
        return StateInfo.SUSPENDED;
      }
      return StateInfo.LOGGED_OUT;
    }
  }

  @Override
  public StateInfo logout() {
    System.out.println("Already logged out.");
    return StateInfo.LOGGED_OUT;
  }

  @Override
  public StateInfo unlock(int resetCode) {
    System.out.println("Cannot unlock while logged out. Please log in first.");
    return StateInfo.LOGGED_OUT;
  }

  @Override
  public StateInfo withdrawMoney(int amount) {
    System.out.println("Please log in to withdraw money.");
    return StateInfo.LOGGED_OUT;
  }
}


// YOUR SOLUTION HERE
class Suspended implements BankAccountState {
  private BankAccount bankAccount;

  public Suspended(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
  }

  @Override
  public StateInfo login(String password) {
    System.out.println("Account is suspended. Cannot log in.");
    return StateInfo.SUSPENDED;
  }

  @Override
  public StateInfo logout() {
    System.out.println("Account is suspended. Cannot log out.");
    return StateInfo.SUSPENDED;
  }

  @Override
  public StateInfo unlock(int resetCode) {
    if (resetCode == bankAccount.getResetCode()) {
      bankAccount.setState(bankAccount.getLoggedOutState());
      bankAccount.setPasswordRetries(0);
      System.out.println("Account unlocked successfully. Please log in.");
      return StateInfo.LOGGED_OUT;
    } else {
      System.out.println("Incorrect reset code.");
      return StateInfo.SUSPENDED;
    }
  }

  @Override
  public StateInfo withdrawMoney(int amount) {
    System.out.println("Account is suspended. Cannot withdraw money.");
    return StateInfo.SUSPENDED;
  }
}

