package ku.shop.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TaxThailand implements TaxCalculator {
    @Override
    public double calculateTax(double purchase) {
        return purchase * 0.07;
    }
}
