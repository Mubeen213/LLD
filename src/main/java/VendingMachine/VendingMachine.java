package VendingMachine;

import VendingMachine.States.IdleState;
import VendingMachine.States.VendingMachineState;

public class VendingMachine {

    private final Inventory inventory;
    private final VendingMachineState currentState;

    public VendingMachine() {
        this.inventory = new Inventory();
        this.currentState = new IdleState(this);
    }

    public static final class VendingMachineInstanceHolder {
        private  static final VendingMachine instance = new VendingMachine();
    }

    public static VendingMachine getInstance() {
        return VendingMachineInstanceHolder.instance;
    }

    public void selectProduct(Product product) {
        // currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(NOTE note) {
        currentState.insertNote(note);
    }

    public void returnChange(){
        currentState.returnChange();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
