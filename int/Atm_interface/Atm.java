package Atm_interface;

import java.util.Scanner;


public class Atm {
    static Bank bank1 = new Bank();
    public static void withdraw(int amt){
        if(amt<=bank1.amount){
            bank1.amount-=amt;
            System.out.println("Your transaction is Successful!! \nYour available Balance is : "+bank1.amount);
        }
        else System.out.println("Insufficient Balance");
    }
    public static void deposit(int amt){
        bank1.amount+=amt;
        System.out.println("Your transaction is Successful!! \nYour available Balance is : "+bank1.amount);
    }
    public static void checkbalance(){
        System.out.println("Your available Balance is : "+bank1.amount);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choose = "yes";
        while(choose.equalsIgnoreCase("yes")){
            System.out.println("1.Balance Inquiry \n2.Withdrawl \n3.Deposit");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    checkbalance();
                    break;
                case 2:
                    System.out.print("Enter Amount : ");
                    withdraw(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Amount to Deposit : ");
                    deposit(scanner.nextInt());
                    break;
                default:
                    System.out.println("You entered a wrong key");
                    break;
            }
            System.out.println("\nIf you want to do another transaction press 'Yes' else 'No'");
            scanner.nextLine();
            choose = scanner.nextLine();
        }
        System.out.println("\n\nThanks for using the ATM");
    }
}

