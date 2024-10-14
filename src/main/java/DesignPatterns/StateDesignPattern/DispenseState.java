package DesignPatterns.StateDesignPattern;

public class DispenseState implements VendingMachineState{

    @Override
    public void selectProduct(String name, VendingMachine vendingMachine) {

    }

    @Override
    public void insertMoney(int amount, VendingMachine vendingMachine) {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Dispense and moved to return change");
        vendingMachine.setCurrentState(new ReturnChange());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
