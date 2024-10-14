package DesignPatterns.Singleton;

public class SingletonClient {

    public static void main(String[] args) {
        // Singleton singleton = new Singleton();

        Singleton singleton = Singleton.getInstance();
        singleton.accessSingleton();
    }

}

class Singleton {

    private Singleton() {

    }

    public static final class SingletonInstanceHolder {
        private static final  Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }

    public void accessSingleton() {
        System.out.println("Congratulations!!");
    }
}