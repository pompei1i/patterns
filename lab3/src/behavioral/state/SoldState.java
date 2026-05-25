package behavioral.state;

public class SoldState implements VendingState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("  [Vending] Wait — dispensing item.");
    }

    @Override
    public void selectProduct(VendingMachine machine) {
        System.out.println("  [Vending] Already dispensing.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        machine.decreaseStock();
        System.out.println("  [Vending] Item dispensed. Stock left: " + machine.getStock());
        if (machine.getStock() > 0) machine.setState(new NoCoinState());
        else {
            System.out.println("  [Vending] Out of stock!");
            machine.setState(new SoldOutState());
        }
    }
}
