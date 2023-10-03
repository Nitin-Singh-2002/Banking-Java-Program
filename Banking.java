package com.nitin;

import java.util.Scanner;

public class Banking {
    public static void main(String[] args){
        BankAccount obj = new BankAccount("Nitin Singh", "NS00001");
        obj.showMenu();
    }
}

class BankAccount {
    int Balance;
    int previousTransaction;
    String customerName;
    String customerId;


    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    void Deposit(int amount){
        if(amount != 0){
            Balance = Balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            Balance = Balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited:" + previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("withdraw:" + previousTransaction);
        }
        else {
            System.out.println("No Transaction Occured");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " +customerName);
        System.out.println("Welcome " +customerId);
        System.out.println("/n");


        System.out.println("A: Check Account Balance");
        System.out.println("B: Deposit Money");
        System.out.println("C: Withdraw Money");
        System.out.println("D: Previous Transaction Details");
        System.out.println("E: Calculate Fixed Deposit Interest");
        System.out.println("F: Calculate Saving Account Interest");
        System.out.println("G: Calculate Simple Interest");
        System.out.println("H: Calculate Compound Interest");

        System.out.println("Q: Exit");

        do{
            System.out.println("******************************************");
            System.out.println("Enter Your Option");
            System.out.println("******************************************");

            option = scanner.next().charAt(0);


            switch(option){
                case 'A':
                    System.out.println("----------------------------------------");
                    System.out.println("Account Balance = " +Balance);
                    System.out.println("----------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("----------------------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("----------------------------------------");
                    int amount = scanner.nextInt();
                    Deposit(amount);
                    System.out.println("Amount deposited in the account = " +amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    final int PIN_NUMBER = 1234; // Your predefined PIN

                    System.out.println("Enter Your PIN");
                    int enteredPIN = scanner.nextInt();

                    if (enteredPIN == PIN_NUMBER)
                    {
                        System.out.println("PIN is correct. You can proceed with the withdrawal.");

                        System.out.println("----------------------------------------");
                        System.out.println("Enter an amount to withdraw");
                        System.out.println("----------------------------------------");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println("amount withdraw from the account =" +amount2);
                        System.out.println("\n");
                        break;

                    }
                    else
                    {
                        System.out.println("Error: The entered PIN number is wrong.");
                    }
                    break;


                case 'D':
                    System.out.println("----------------------------------------");
                    System.out.println("Your previous transaction status is: \n ");
                    getPreviousTransaction();
                    System.out.println("----------------------------------------");
                    System.out.println("\n");
                    break;

                case'E':
                    double rate = 7.1;

                    System.out.println("Enter the principal amount: ");
                    double principal = scanner.nextDouble();

                    System.out.println("Enter the time period(in years): ");
                    double time = scanner.nextDouble();

                    //Fixed Deposit

                    double fdInterest = (principal*rate*time)/100;
                    System.out.println("Interest for Fixed Deposit: " +fdInterest);
                    break;

                case'F':
                    double interest = 5;

                    System.out.println("Enter the principal amount: ");
                    double principalAmount = scanner.nextDouble();

                    System.out.println("Enter the time period(in years): ");
                    double timePeriod = scanner.nextDouble();

                    double saInterest = (principalAmount*Math.pow((1 + interest/100), timePeriod) - principalAmount);
                    System.out.println("Interest for Savings Account: " +saInterest);
                    break;

                case'G':

                    System.out.print("Enter principal amount: ");
                    double PR = scanner.nextDouble();

                    System.out.print("Enter interest rate (in percentage): ");
                    double R = scanner.nextDouble();

                    System.out.print("Enter time (in years): ");
                    double T = scanner.nextDouble();

                    double simpleInterest = (PR * R * T) / 100;

                    System.out.println("Simple Interest: " + simpleInterest);
                    break;

                case'H':
                    System.out.print("Enter principal amount: ");
                    double Principal = scanner.nextDouble();

                    System.out.print("Enter interest rate (in percentage): ");
                    double Rate = scanner.nextDouble();

                    System.out.print("Enter time (in years): ");
                    double Time = scanner.nextDouble();

                    System.out.print("Enter the number of times interest is compounded per year: ");
                    int n = scanner.nextInt();

                    double Amount = Principal * Math.pow(1 + (Rate / (n * 100)), n * Time);
                    double compoundInterest = Amount - Principal;

                    System.out.println("Compound Interest: " + compoundInterest);
                    break;


                case 'Q':
                    System.out.println("Preparing to exit....");
                    break;

                      default:
                          System.out.println("Invalid Option!! Please Enter One Of The Valid Option");
                          break;
                }
            }
            while(option != 'Q');
            System.out.println("Thank You For Using Our Services.....!!");

        }
    }



