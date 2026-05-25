package behavioral.state;

public class VendingMachine {
    private VendingState state;
    private int stock;

    public VendingMachine(int stock) {
        this.stock = stock;
        this.state = new NoCoinState();
    }

    public void setState(VendingState state) { this.state = state; }
    public int  getStock()                   { return stock; }
    public void decreaseStock()              { stock--; }

    public void insertCoin()    { state.insertCoin(this); }
    public void selectProduct() { state.selectProduct(this); }
    public void dispense()      { state.dispense(this); }
}
