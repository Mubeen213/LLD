package DesignPatterns.StateDesignPattern;

public class ReturnChange implements VendingMachineState {


    @Override
    public void selectProduct(String name, VendingMachine vendingMachine) {

    }

    @Override
    public void insertMoney(int amount, VendingMachine vendingMachine) {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Change returned");
        vendingMachine.setCurrentState(new IdleState());
    }
}
