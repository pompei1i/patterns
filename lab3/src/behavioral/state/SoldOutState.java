package behavioral.state;

public class SoldOutState implements VendingState {
    @Override public void insertCoin(VendingMachine m)    { System.out.println("  [Vending] Sold out — returning coin."); }
    @Override public void selectProduct(VendingMachine m) { System.out.println("  [Vending] Sold out."); }
    @Override public void dispense(VendingMachine m)      { System.out.println("  [Vending] Sold out."); }
}
