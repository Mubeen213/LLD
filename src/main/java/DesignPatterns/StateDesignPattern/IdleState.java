package DesignPatterns.StateDesignPattern;

public class IdleState implements VendingMachineState {


    @Override
    public void selectProduct(String name, VendingMachine vendingMachine) {

        //     select product and set currentState as Ready
        System.out.println("Selected product");
        vendingMachine.setCurrentState(new ReadyState());
    }

    @Override
    public void insertMoney(int amount, VendingMachine vendingMachine) {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {

    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {

    }
}
