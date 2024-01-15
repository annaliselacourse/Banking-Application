import java.util.ArrayList;

class Customer {
  private String username;
  private String password;
  private ArrayList<Account> accounts = new ArrayList<>();

  //constructor
  public Customer(String name, String password) {
    username = name;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public ArrayList<Account> getAccounts() {
    return accounts;
  }

  public void setName(String name) {
    username = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Account createAccount(String type) {
    Account account = new Account(type);
    accounts.add(account);
    return account;
  }

  public boolean removeAccount(int num) {
    for(Account a: accounts) {
      if(a.getNumber() == num) {
        accounts.remove(a);
        return true;
      }
    }
    return false;
  }

  public boolean transfer(float amount, int from, int to) {
    Account afrom = null;
    Account ato = null;
    for(Account a: accounts) {
      if(from == a.getNumber())
        afrom = a;
      if(to == a.getNumber())
        ato = a;
    }

    if(afrom != null && ato != null) {
      afrom.withdraw(amount);
      ato.deposit(amount);
      return true;
    }
    else
      return false;
  }

  public void printInfo() {
    System.out.println("My accounts: ");
    for(Account a: accounts) {
      a.printInfo();
    }
    System.out.println("- - - - - - - - - - - - - - - - - ");
  }

  public Account getAccount(int num) {
    for(Account a: accounts){
      if(a.getNumber() == num)
        return a;
    }
    
    return null;
  }
  
} //end of customer class