package com.spark.atm;

//2.
//create an interface class
//An interface is a completely "abstract class" and is used to group related [methods] with empty bodies:

public interface AtmOperationInterface {
    public void viewBalance();  // interface method (does not have a body) -

    // the body will be implemented in AtmOperationInterfaceImplementation class
    public void withdrawAmount(double withdrawAmount); //takes 1 parameter

    public void depositAmount(double depositAmount);//takes 1 parameter

    public void viewMiniStatement();


}
