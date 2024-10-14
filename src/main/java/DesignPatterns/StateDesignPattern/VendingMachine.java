package DesignPatterns.StateDesignPattern;

import java.util.Map;

public class VendingMachine {

    private VendingMachineState currentState;
    private String currentProduct;
    private int stock;
    private Map<String, Integer> productPrices;

    public VendingMachine(int stock, Map<String, Integer> productPrices) {
        this.stock = stock;
        this.productPrices = productPrices;

        if (stock > 0) {
            this.currentState = new IdleState();
        } else {
            System.out.println("Out of stock");
        }
    }

    public void selectProduct(String product) {
        currentState.selectProduct(product, this);
    }

    public void insertMoney(int amount) {
        currentState.insertMoney(amount, this);
    }

    public void dispenseProduct(){
        currentState.dispenseProduct(this);
    }

    public void returnChange() {
        currentState.returnChange(this);
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }
}
