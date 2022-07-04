package com.bank.atm;

//3. implement the AtmOperationInterface class here - otherwise make this class an abstract class
//4. create objects in main class
public class AtmOperationInterfaceImplementation implements AtmOperationInterface {




    public static final String ANSI_PURPLE = "\u001B[35m";
    //create object of ATM class to access its states with the help of getter & setter
    ATM atm = new ATM();


    @Override
    public void viewBalance() {
    System.out.println("Your Balance is:  $" + atm.getBalance());
// System.out.println( String.format("%,.2f" , atm.getBalance()));


    }

    @Override
    public void withdrawAmount(double withdrawAmount) {

    }

    @Override
    public void depositAmount(double depositAmount) {
        //show a message of the deposited amount
        System.out.println(ANSI_PURPLE + "Total of $" + depositAmount + " has been deposited into your account.");
        //Then add this amount into the available balance
        atm.setBalance(atm.getBalance() + depositAmount); //current balance + deposited amount
        viewBalance(); // immediately show the balance

    }

    @Override
    public void viewMiniStatement() {

    }
}
