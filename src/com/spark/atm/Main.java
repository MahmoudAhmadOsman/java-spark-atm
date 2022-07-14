package com.spark.atm;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String RED_BACKGROUND = "\u001B[41m";

    public static void main(String[] args) {
//        int atnNum = 25000;
//        int pinNum = 5000;


        double accountNumber = Math.random() * 25000;
        double accountPinNumber = Math.random() * 5000;

        // cast the double to whole number
        int atnNum = (int) accountNumber;
        int pinNum = (int) accountPinNumber;
//        System.out.println("ATM Number:" + atnNum);
//        System.out.println("Pin Number: " + pinNum);


        //4. create AtmOperationInterface objects here
        AtmOperationInterface operation = new AtmOperationInterfaceImplementation();


//Scanner - ask the user his/her ATM & pin-number

        System.out.println("Welcome to Easter Bank ATM. Please use below ATM credentials.\n ");
        System.out.println("ATM Number is: " + atnNum + " | " + " Pin Number is: " + ANSI_GREEN + pinNum);


        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + "Enter you ATM number: ");
        int atmNumber = in.nextInt();
        System.out.print(ANSI_BLUE + "Enter your pin number: ");
        int atmPinNumber = in.nextInt();


//Check if the atm number and the pin-number are correct
        boolean run = true;
        if ((atnNum == atmNumber & pinNum == atmPinNumber)) {
            while (run) {
                System.out.println(ANSI_GREEN +
                        "1.View Balance\n" +
                        "2.Withdraw Money\n" +
                        "3.Deposit Money\n" +
                        "4.View Account Activities\n" +
                        "5.Exit or end activity"
                );
                System.out.println(ANSI_BLUE + "Please choose an option\n ");
                int choice = in.nextInt();
                if (choice == 1) {
                    operation.viewBalance();
                    System.out.println(" ");

                } else if (choice == 2) {
                    System.out.println(ANSI_RED + "Enter the amount you want to withdraw ");
                    double withdrawAmount = in.nextDouble();
                    operation.withdrawAmount(withdrawAmount);

                } else if (choice == 3) {
                    System.out.println("Enter the amount you want to deposit");
                    double depositAmount = in.nextDouble();
                    operation.viewBalance(); // immediately call view balance & show the available balance
                    operation.depositAmount(depositAmount);


                } else if (choice == 4) {
                    operation.viewMiniStatement();
//                    operation.viewMiniStatement();

                } else if (choice == 5) {
                    System.out.println("============ Thank you ============");
                    System.out.println(ANSI_RED + "Please take your card. See you soon again!");
                    System.exit(1);

                } else {
                    System.out.println(ANSI_RED + "Invalid option! Please choose valid option ");
                }//end of main if statement


            }//end while
        } else {
            System.out.println(ANSI_RED + "Invalid ATM number or pin number!");
            System.out.println(ANSI_RED + "Please, enter valid credentials!");

        }

        in.close();
    }
}
