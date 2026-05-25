package behavioral.state;

public class HasCoinState implements VendingState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("  [Vending] Coin already inserted.");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("  [Vending] Product selected.");
        machine.setState(new SoldState());
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("  [Vending] Select a product first.");
    }
}
