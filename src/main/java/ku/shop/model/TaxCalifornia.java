package ku.shop.model;

public class TaxCalifornia implements TaxCalculator {
    @Override
    public double calculateTax(double purchase) {
        double tax = 0.06;
        if (purchase < 100)
            tax = 0.04;
        else if (purchase < 500)
            tax = 0.05;
        return purchase * tax;
    }
}
