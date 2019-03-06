package ku.shop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items;
    private LocalDateTime date;
    private TaxCalculator taxCalculator;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.taxCalculator = new TaxThailand();
    }

    public Order() {
        this(0);
    }

    public void setTaxCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void addItem(Product prod, int quantity) {
        items.add(new OrderItem(prod, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total + taxCalculator.calculateTax(total);
    }

}
