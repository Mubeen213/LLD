package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.NOTE;
import VendingMachine.Product;
import VendingMachine.VendingMachine;

public class IdleState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productName) {

        // if(!vendingMachine.getInventory().isAvailable(product)) {
        //     System.out.println("Product is not available");
        //     return;
        // }

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product first");
    }

    @Override
    public void insertNote(NOTE note) {
        System.out.println("Please select the product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select the product first");
    }

    @Override
    public void returnChange() {
        System.out.println("Please select the product first");
    }
}
