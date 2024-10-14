package DesignPatterns.StateDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Client {

    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Soda", 50);
        products.put("Chips", 30);

        VendingMachine vendingMachine = new VendingMachine(5, products);

        vendingMachine.selectProduct("Soda");
        vendingMachine.insertMoney(60);
        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();
    }
}
