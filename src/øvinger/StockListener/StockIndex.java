package øvinger.StockListener;

import java.util.Collection;
import java.util.List;

public class StockIndex implements StockListener {
    private String name;
    private Collection<Stock> stocks;

    public StockIndex(String name, Stock... stocks) {
        this.name = name;
        this.stocks = List.of(stocks);
        this.stocks.forEach(stock -> stock.addStockListener(this));
    }

    public void addStock(Stock stock) {
        if (!stocks.contains(stock)){
            stocks.add(stock);
        }
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public double getIndex(){
        return stocks.stream().mapToDouble(Stock::getPrice).sum();
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        System.out.println(stock.getTicker() + " changed. " + name + " is now at " + getIndex());
    }

    public static void main(String[] args) {
        Stock tesla = new Stock(100, "TSLA");
        Stock ford = new Stock(100, "FRD");
        StockIndex index = new StockIndex("S&P 500", tesla, ford);
        tesla.setPrice(150);
        ford.setPrice(0);
    }
}
