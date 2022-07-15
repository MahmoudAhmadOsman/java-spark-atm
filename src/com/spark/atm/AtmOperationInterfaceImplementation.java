package com.spark.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

//3. implement the AtmOperationInterface class here - otherwise make this class an abstract class
//4. create objects in main class
public class AtmOperationInterfaceImplementation implements AtmOperationInterface {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";

    //create object of ATM class to access its states with the help of getter & setter
    ATM atm = new ATM();
    public Long customerServiceNumber = 1800555999L; //customer service number

    Map<Double, String> miniStatement = new HashMap<>();//Map for mini-statement details

    //show transaction date & time
    private DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("MM/dd/yyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();


    @Override
    public void viewBalance() {
        System.out.println("========================= ");
        System.out.println("Your available balance is:  $" + atm.getBalance());
        System.out.println("========================= ");

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        double maxAmount = 300;
        if (withdrawAmount > maxAmount) {//allowed amount for withdrawal per day
            System.out.println("You are not allow to withdraw more than $" + maxAmount + " per day!");
        }
         else if (withdrawAmount > atm.getBalance()){ // if account is empty or too low
            System.out.println("Your balance is too low for the amount of $"
                    + withdrawAmount + " to be withdrawn. Your available balance is: $" + atm.getBalance());
            System.out.println(ANSI_PURPLE + "Please contact Customer Service if you have any question at: " + customerServiceNumber);
        }
          else if (withdrawAmount <= atm.getBalance()) { //if there is a balance in the account
            miniStatement.put(withdrawAmount, " withdrawn on | " + currentDate.format(now));
            atm.setBalance(atm.getBalance() - withdrawAmount);
            System.out.println("The amount of " + withdrawAmount + " has been withdrawn");
            viewBalance();

        } else {
            System.out.println(ANSI_RED + "ATM is out of service! > ERROR: 009478MXUD");
            System.out.println();
        }

    }

    @Override
    public void depositAmount(double depositAmount) {

        miniStatement.put(depositAmount, " deposited on | " + currentDate.format(now));
        //show a message of the deposited amount
        System.out.println(ANSI_PURPLE + "Total amount of $" + depositAmount + " has been deposited into your account.");
        //Then add this amount into the available balance
        atm.setBalance(atm.getBalance() + depositAmount); //current balance + deposited amount
        viewBalance(); // immediately show the balance


    }

    @Override
    public void viewMiniStatement() {
        //loop through the Map interface
        for (Map.Entry<Double, String> mini : miniStatement.entrySet()) {
            System.out.println(mini.getKey() + "" + mini.getValue());
        }

        System.out.println("===============================================");
        System.out.println();
    }
}