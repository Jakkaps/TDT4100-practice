package øvinger.StockListener;

public interface StockListener {
    void stockPriceChanged(Stock stock, double oldValue, double newValue);
}
