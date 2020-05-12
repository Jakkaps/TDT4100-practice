package øvinger.StockListener;

import java.util.ArrayList;
import java.util.Collection;

public class Stock {
   private double price;
   private String ticker;
   private Collection<StockListener> stockListeners = new ArrayList<>();

   public Stock(double price, String ticker) {
      setPrice(price);
      this.ticker = ticker;
   }

   public void setPrice(double price) {
      double oldPrice = this.price;
      this.price = price;
      notifyListeners(oldPrice, price);
   }

   public double getPrice() {
      return price;
   }

   public String getTicker() {
      return ticker;
   }

   private void notifyListeners(double oldPrice, double newPrice){
      stockListeners.forEach(listener -> listener.stockPriceChanged(this, oldPrice, newPrice));
   }

   public void addStockListener(StockListener stockListener) {
      if (!stockListeners.contains(stockListener)){
         stockListeners.add(stockListener);
      }
   }

   public void removeStockListener(StockListener stockListener) {
      stockListeners.remove(stockListener);
   }
}
