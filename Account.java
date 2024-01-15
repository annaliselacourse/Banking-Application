class Account {
  private int num;
  private String type;
  private float balance;

  public Account(String type) {
    this.type = type;
    balance = 0.0f;
    num = (int)(Math.random() * 89999 + 10000);
  }

  public int getNumber() {
    return num;
  }

  public String getType() {
    return type;
  }

  public float getBalance() {
    return balance;
  }

  public void deposit(float amount) {
    balance += amount;
  }

  public boolean withdraw(float amount) {
    if(balance >= amount){
      balance -= amount;
      return true;
    }
    else
      return false;
  }

  public void printInfo() {
    System.out.printf(type + " Account #" + num + ": $%.2f \n", balance);
  }
}