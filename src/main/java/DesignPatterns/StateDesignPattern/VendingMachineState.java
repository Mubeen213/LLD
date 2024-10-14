package DesignPatterns.StateDesignPattern;

public interface VendingMachineState {

    void selectProduct(String name, VendingMachine vendingMachine);

    void insertMoney(int amount, VendingMachine vendingMachine);

    void dispenseProduct(VendingMachine vendingMachine);

    void returnChange(VendingMachine vendingMachine);
}
