package ku.shop.model;

public class TaxThailand implements TaxCalculator {
    @Override
    public double calculateTax(double purchase) {
        return purchase * 0.07;
    }
}
