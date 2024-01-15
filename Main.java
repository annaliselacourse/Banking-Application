import java.util.Scanner;

import java.util.ArrayList;

class Main {
    static Scanner scnr = new Scanner(System.in);
    static String response = "";
    static String username = "";
    static String password = "";
    static ArrayList<Customer> customers = new ArrayList<>();
  
  public static void main(String[] args) {
    home();
  }

  //HOME SCREEN
  public static void home() {
    System.out.println();
    System.out.println("-----Bank of Computer Science-----");
    System.out.println("Would you like to: ");
    System.out.println("a) Sign in to an existing user account");
    System.out.println("b) Create new user account");
    System.out.print("Type response here: ");
    response = scnr.next();
    System.out.println();
  
    if(response.equals("a")) {
      signIn();
    }
    else if(response.equals("b")) {
      createUser();
    }
  }

  //SIGN IN SCREEN
  public static void signIn() {
    String response = "";
    boolean user = false;
    
    System.out.println("-------------SIGN IN--------------");
    System.out.print("Enter Username: ");
    username = scnr.next();
    System.out.print("Enter Password: ");
    password = scnr.next();

    for(Customer customer: customers) {
      if(customer.getUsername().equals(username)) {
        user = true;
        if(customer.getPassword().equals(password)) {
          System.out.println();
          customerView(customer);
        }
        else {
          System.out.println();
          System.out.println("incorrect password");
          System.out.println();
          signIn();
        }
        }   
    }

    if(user == false) {
      System.out.println();
      System.out.println("The username entered is not registered with an existing account");
      System.out.println("Would you like to: ");
      System.out.println("a) continue with log in");
      System.out.println("b) create new user");
      System.out.print("Type response here: ");
      response = scnr.next();
      System.out.println();
      
      if(response.equals("a"))
        signIn();
      else if(response.equals("b"))
        createUser();
    }
    
  }

  //CREATE USER SCREEN
  public static void createUser() {
    System.out.println("-----------NEW ACCOUNT------------");
      System.out.print("Create Username: ");
      username = scnr.next();
      System.out.print("Create Password: ");
      password = scnr.next();

    Customer c = new Customer(username, password);
    customers.add(c);

    System.out.println("Account successfully created");

    home();
  }

  //CUSTOMER SCREEN
  public static void customerView(Customer customer) {
    int number1;
    int number2;
    String option = "";
    String type = "";
    float amount = 0f;
    boolean success;
    
    System.out.println("----------CUSTOMER VIEW-----------");
    System.out.println("Welcome Back " + customer.getUsername());
    customer.printInfo();
    System.out.println("Would you like to: ");
    System.out.println("a) deposit");
    System.out.println("b) withdraw");
    System.out.println("c) transfer");
    System.out.println("d) create new savings/checkings account");
    System.out.println("e) log out");
    System.out.print("Type response here: ");
    option = scnr.next();

    if(option.equals("a")) {
      System.out.print("Enter account number for deposit: ");
      number1 = scnr.nextInt();
      Account a = customer.getAccount(number1);
      System.out.print("Enter amount to deposit: ");
      amount = scnr.nextFloat();
      a.deposit(amount);
      System.out.println();
      customerView(customer);
    }
    else if(option.equals("b")) {
      System.out.print("Enter account number for withdraw: ");
      number1 = scnr.nextInt();
      Account a = customer.getAccount(number1);
      System.out.print("Enter amount to withdraw: ");
      amount = scnr.nextFloat();
      success = a.withdraw(amount);
      if(success == true)
        System.out.print("$" + amount + " Successfully withdrawn");
      else
        System.out.print("unable to withdraw given amount");
      System.out.println();
      customerView(customer);
    }
    else if(option.equals("c")) {
      System.out.print("Enter account number for transfer from: ");
      number1 = scnr.nextInt();
      System.out.print("Enter account to transfer to: ");
      number2 = scnr.nextInt();
      System.out.print("Enter amount to transfer: ");
      amount = scnr.nextFloat();
      success = customer.transfer(amount, number1, number2);
      if(success == true)
        System.out.print("Successfully transfered amount");
      else
        System.out.print("Unsuccessful");
      System.out.println();
      customerView(customer);
    }
    else if(option.equals("d")) {
      System.out.print("Enter account type: ");
      type = scnr.next();
      customer.createAccount(type);
      System.out.println("new" + type + "Account created");
      System.out.println();
      customerView(customer);
    }
    else if(option.equals("e")) {
      home();
    }
    
    
  }

}