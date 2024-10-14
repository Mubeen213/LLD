package VendingMachine.States;

import VendingMachine.Coin;
import VendingMachine.NOTE;
import VendingMachine.Product;

public interface VendingMachineState {

    void selectProduct(String productName);

    void insertCoin(Coin coin);

    void insertNote(NOTE note);

    void dispenseProduct();

    void returnChange();
}
