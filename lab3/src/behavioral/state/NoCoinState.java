package behavioral.state;

public class NoCoinState implements VendingState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("  [Vending] Coin inserted.");
        machine.setState(new HasCoinState());
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("  [Vending] Please insert a coin first.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("  [Vending] No coin inserted.");
    }
}
