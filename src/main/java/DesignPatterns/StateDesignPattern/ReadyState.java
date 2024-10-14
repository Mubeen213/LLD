package DesignPatterns.StateDesignPattern;

public class ReadyState implements VendingMachineState{

    @Override
    public void selectProduct(String name, VendingMachine vendingMachine) {

    }

    @Override
    public void insertMoney(int amount, VendingMachine vendingMachine) {
    //     do calculation etc
    //     move to dispense state
        System.out.println("Money recieved");
        vendingMachine.setCurrentState(new DispenseState());
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
